package io.pivotal.security.service;

import io.pivotal.security.constants.CipherTypes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

@SuppressWarnings("unused")
@ConditionalOnProperty(value = "encryption.provider", havingValue = "hsm", matchIfMissing = true)
@Component
public class LunaEncryptionConfiguration implements EncryptionConfiguration {

  @Value("${hsm.partition}")
  String partitionName;

  @Value("${hsm.partition-password}")
  String partitionPassword;

  @Value("${hsm.encryption-key-name}")
  String encryptionKeyAlias;

  private Provider provider;
  private SecureRandom secureRandom;
  private EncryptionKey key;
  private List<EncryptionKey> keys;

  public LunaEncryptionConfiguration() throws Exception {
    provider = (Provider) Class.forName("com.safenetinc.luna.provider.LunaProvider").newInstance();
    Security.addProvider(provider);

    initializeKeys();
    keys = asList(key);
  }

  @Override
  public Provider getProvider() {
    return provider;
  }

  @Override
  public SecureRandom getSecureRandom() {
    return secureRandom;
  }

  @Override
  public EncryptionKey getActiveKey() {
    return key;
  }

  @Override
  public List<EncryptionKey> getKeys() {
    return keys;
  }

  @Override
  public Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
    return Cipher.getInstance(CipherTypes.GCM.toString(), provider);
  }

  @Override
  public IvParameterSpec generateParameterSpec(byte[] nonce) {
    return new IvParameterSpec(nonce);
  }

  private void initializeKeys() throws Exception {
    Object lunaSlotManager = Class.forName("com.safenetinc.luna.LunaSlotManager").getDeclaredMethod("getInstance").invoke(null);
    lunaSlotManager.getClass().getMethod("login", String.class, String.class).invoke(lunaSlotManager, partitionName, partitionPassword);

    KeyStore keyStore = KeyStore.getInstance("Luna", provider);
    keyStore.load(null, null);
    secureRandom = SecureRandom.getInstance("LunaRNG");
    KeyGenerator aesKeyGenerator = KeyGenerator.getInstance("AES", provider);
    aesKeyGenerator.init(128);

    if (!keyStore.containsAlias(encryptionKeyAlias)) {
      SecretKey aesKey = aesKeyGenerator.generateKey();
      keyStore.setKeyEntry(encryptionKeyAlias, aesKey, null, null);
    }

    key = new EncryptionKey(this, keyStore.getKey(encryptionKeyAlias, null));
  }
}
