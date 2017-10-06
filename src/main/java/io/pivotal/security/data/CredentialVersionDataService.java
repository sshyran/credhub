package io.pivotal.security.data;

import io.pivotal.security.domain.Credential;
import io.pivotal.security.domain.CredentialFactory;
import io.pivotal.security.entity.CredentialVersion;
import io.pivotal.security.entity.CredentialName;
import io.pivotal.security.exceptions.ParameterizedValidationException;
import io.pivotal.security.repository.CredentialVersionRepository;
import io.pivotal.security.service.EncryptionKeyCanaryMapper;
import io.pivotal.security.view.FindCredentialResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.collect.Lists.newArrayList;
import static io.pivotal.security.repository.CredentialVersionRepository.BATCH_SIZE;

@Service
public class CredentialVersionDataService {

  private final CredentialVersionRepository credentialVersionRepository;
  private final CredentialNameDataService credentialNameDataService;
  private final JdbcTemplate jdbcTemplate;
  private final EncryptionKeyCanaryMapper encryptionKeyCanaryMapper;
  private final CredentialFactory credentialFactory;

  @Autowired
  protected CredentialVersionDataService(
      CredentialVersionRepository credentialVersionRepository,
      CredentialNameDataService credentialNameDataService,
      JdbcTemplate jdbcTemplate,
      EncryptionKeyCanaryMapper encryptionKeyCanaryMapper,
      CredentialFactory credentialFactory
  ) {
    this.credentialVersionRepository = credentialVersionRepository;
    this.credentialNameDataService = credentialNameDataService;
    this.jdbcTemplate = jdbcTemplate;
    this.encryptionKeyCanaryMapper = encryptionKeyCanaryMapper;
    this.credentialFactory = credentialFactory;
  }

  public <Z extends Credential> Z save(Z namedSecret) {
    return (Z) namedSecret.save(this);
  }

  public <Z extends Credential> Z save(CredentialVersion credentialVersion) {
    if (credentialVersion.getEncryptionKeyUuid() == null && credentialVersion.getEncryptedValue() != null) {
      credentialVersion.setEncryptionKeyUuid(encryptionKeyCanaryMapper.getActiveUuid());
    }

    CredentialName credentialName = credentialVersion.getCredentialName();

    if (credentialName.getUuid() == null) {
      credentialVersion.setCredentialName(credentialNameDataService.save(credentialName));
    } else {
      Credential existingCredential = findMostRecent(credentialName.getName());
      if (existingCredential != null && !existingCredential.getCredentialType()
          .equals(credentialVersion.getCredentialType())) {
        throw new ParameterizedValidationException("error.type_mismatch");
      }
    }

    return (Z) credentialFactory
        .makeCredentialFromEntity(credentialVersionRepository.saveAndFlush(credentialVersion));
  }

  public List<String> findAllPaths() {
    return credentialNameDataService.findAll()
        .stream()
        .map(CredentialName::getName)
        .flatMap(CredentialVersionDataService::fullHierarchyForPath)
        .distinct()
        .sorted()
        .collect(Collectors.toList());
  }

  private static Stream<String> fullHierarchyForPath(String path) {
    String[] components = path.split("/");
    if (components.length > 1) {
      StringBuilder currentPath = new StringBuilder();
      List<String> pathSet = new ArrayList<>();
      for (int i = 0; i < components.length - 1; i++) {
        String element = components[i];
        currentPath.append(element).append('/');
        pathSet.add(currentPath.toString());
      }
      return pathSet.stream();
    } else {
      return Stream.of();
    }
  }

  public Credential findMostRecent(String name) {
    CredentialName credentialName = credentialNameDataService.find(name);

    if (credentialName == null) {
      return null;
    } else {
      return credentialFactory.makeCredentialFromEntity(credentialVersionRepository
          .findFirstByCredentialNameUuidOrderByVersionCreatedAtDesc(credentialName.getUuid()));
    }
  }

  public Credential findByUuid(String uuid) {
    return credentialFactory
        .makeCredentialFromEntity(credentialVersionRepository.findOneByUuid(UUID.fromString(uuid)));
  }

  public List<String> findAllCertificateCredentialsByCaName(String caName) {
    return this.findCertificateNamesByCaName(caName);
  }

  public List<FindCredentialResult> findContainingName(String name) {
    return findMatchingName("%" + name + "%");
  }

  public List<FindCredentialResult> findStartingWithPath(String path) {
    path = StringUtils.prependIfMissing(path, "/");
    path = StringUtils.appendIfMissing(path, "/");

    return findMatchingName(path + "%");
  }

  public boolean delete(String name) {
    return credentialNameDataService.delete(name);
  }

  public List<Credential> findAllByName(String name) {
    CredentialName credentialName = credentialNameDataService.find(name);

    return credentialName != null ? credentialFactory.makeCredentialsFromEntities(
        credentialVersionRepository.findAllByCredentialNameUuidOrderByVersionCreatedAtDesc(credentialName.getUuid()))
        : newArrayList();
  }

  public List<Credential> findNByName(String name, int numberOfVersions) {
    CredentialName credentialName = credentialNameDataService.find(name);

    if (credentialName != null) {
      List<CredentialVersion> credentialVersions = credentialVersionRepository
          .findAllByCredentialNameUuidOrderByVersionCreatedAtDesc(credentialName.getUuid())
          .stream()
          .limit(numberOfVersions)
          .collect(Collectors.toList());
      return credentialFactory.makeCredentialsFromEntities(credentialVersions);
    } else {
      return newArrayList();
    }
  }

  public Long count() {
    return credentialVersionRepository.count();
  }

  public Long countAllNotEncryptedByActiveKey() {
    return credentialVersionRepository.countByEncryptedCredentialValueEncryptionKeyUuidNot(
        encryptionKeyCanaryMapper.getActiveUuid()
    );
  }

  public Long countEncryptedWithKeyUuidIn(List<UUID> uuids) {
    return credentialVersionRepository.countByEncryptedCredentialValueEncryptionKeyUuidIn(uuids);
  }

  public Slice<Credential> findEncryptedWithAvailableInactiveKey() {
    final Slice<CredentialVersion> credentialDataSlice = credentialVersionRepository
        .findByEncryptedCredentialValueEncryptionKeyUuidIn(
            encryptionKeyCanaryMapper.getCanaryUuidsWithKnownAndInactiveKeys(),
            new PageRequest(0, BATCH_SIZE)
        );
    return new SliceImpl(
        credentialFactory.makeCredentialsFromEntities(credentialDataSlice.getContent()));
  }

  private List<FindCredentialResult> findMatchingName(String nameLike) {
    final List<FindCredentialResult> credentialResults = jdbcTemplate.query(
        " select name.name, credential_version.version_created_at from ("
            + "   select"
            + "     max(version_created_at) as version_created_at,"
            + "     credential_uuid"
            + "   from credential_version group by credential_uuid"
            + " ) as credential_version inner join ("
            + "   select * from credential"
            + "     where lower(name) like lower(?)"
            + " ) as name"
            + " on credential_version.credential_uuid = name.uuid"
            + " order by version_created_at desc",
        new Object[]{nameLike},
        (rowSet, rowNum) -> {
          final Instant versionCreatedAt = Instant
              .ofEpochMilli(rowSet.getLong("version_created_at"));
          final String name = rowSet.getString("name");
          return new FindCredentialResult(versionCreatedAt, name);
        }
    );
    return credentialResults;
  }

  private List<String> findCertificateNamesByCaName(String caName){
    String query = "select distinct credential.name from "
        + "credential, credential_version, certificate_credential "
        + "where credential.uuid=credential_version.credential_uuid "
        + "and credential_version.uuid=certificate_credential.uuid "
        + "and lower(certificate_credential.ca_name) "
        + "like lower(?)";
    return jdbcTemplate.queryForList(query, String.class, caName);
  }
}