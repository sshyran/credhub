package io.pivotal.security.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greghaskins.spectrum.Spectrum;
import io.pivotal.security.CredentialManagerApp;
import io.pivotal.security.util.DatabaseProfileResolver;
import io.pivotal.security.view.CertificateAuthority;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import static com.greghaskins.spectrum.Spectrum.afterEach;
import static com.greghaskins.spectrum.Spectrum.beforeEach;
import static com.greghaskins.spectrum.Spectrum.describe;
import static com.greghaskins.spectrum.Spectrum.it;
import static io.pivotal.security.helper.SpectrumHelper.wireAndUnwire;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsNull.notNullValue;

import java.time.Instant;
import java.util.UUID;

@RunWith(Spectrum.class)
@ActiveProfiles(value = {"unit-test"}, resolver = DatabaseProfileResolver.class)
@SpringBootTest(classes = CredentialManagerApp.class)
public class NamedCertificateAuthorityTest {
  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  JdbcTemplate jdbcTemplate;

  private NamedCertificateAuthority subject;

  {
    wireAndUnwire(this, false);

    beforeEach(() -> {
      subject = new NamedCertificateAuthority("Foo");
      subject.setCertificate("cert");
      subject.setPrivateKey("priv");
      subject.setType("root");
    });

    afterEach(() -> {
      jdbcTemplate.execute("delete from named_secret");
      jdbcTemplate.execute("delete from named_certificate_authority");
      jdbcTemplate.execute("delete from encryption_key_canary");
    });

    it("creates a model from entity", () -> {
      UUID uuid = UUID.randomUUID();
      subject.setUuid(uuid);
      CertificateAuthority certificateAuthority = CertificateAuthority.fromEntity(subject);
      String expectedJson = "{" +
          "\"updated_at\":null," +
          "\"type\":\"root\"," +
          "\"value\":{" +
          "\"certificate\":\"cert\"," +
          "\"private_key\":\"priv\"" +
          "}," +
          "\"id\":\"" + uuid.toString() + "\"" +
          "}";
      assertThat(objectMapper.writer().writeValueAsString(certificateAuthority), equalTo(expectedJson));
    });

    it("set updated-at time on generated view", () -> {
      Instant now = Instant.now();
      subject.setUpdatedAt(now);
      CertificateAuthority actual = CertificateAuthority.fromEntity(subject);
      assertThat(actual.getUpdatedAt(), equalTo(now));
    });

    it("sets the nonce and the encrypted private key", () -> {
      subject.setPrivateKey("my-priv");
      assertThat(subject.getEncryptedValue(), notNullValue());
      assertThat(subject.getNonce(), notNullValue());
    });

    it("can decrypt the private key", () -> {
      subject.setPrivateKey("my-priv");
      assertThat(subject.getPrivateKey(), equalTo("my-priv"));
    });

    describe("#copyInto", () -> {
      it("should copy the correct values", () -> {
        Instant frozenTime = Instant.ofEpochSecond(1400000000L);
        UUID uuid = UUID.randomUUID();
        UUID encryptionKeyUuid = UUID.randomUUID();

        subject = new NamedCertificateAuthority("name");
        subject.setCertificate("fake-certificate");
        subject.setEncryptedValue("fake-private-key".getBytes());
        subject.setNonce("fake-nonce".getBytes());
        subject.setUuid(uuid);
        subject.setUpdatedAt(frozenTime);
        subject.setEncryptionKeyUuid(encryptionKeyUuid);

        NamedCertificateAuthority copy = new NamedCertificateAuthority();
        subject.copyInto(copy);

        assertThat(copy.getName(), equalTo("name"));
        assertThat(copy.getEncryptedValue(), equalTo("fake-private-key".getBytes()));
        assertThat(copy.getNonce(), equalTo("fake-nonce".getBytes()));
        assertThat(copy.getEncryptionKeyUuid(), equalTo(encryptionKeyUuid));

        assertThat(copy.getUuid(), not(equalTo(uuid)));
        assertThat(copy.getUpdatedAt(), not(equalTo(frozenTime)));
      });
    });
  }
}
