package io.pivotal.security.service;

import io.pivotal.security.config.LunaProviderProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

@Component
@ConditionalOnProperty(value = "encryption.provider", havingValue = "hsm", matchIfMissing = true)
class LunaConnection implements RemoteEncryptionConnectable {

  private final LunaProviderProperties lunaProviderProperties;
  private Provider provider;
  private Object lunaSlotManager;
  private KeyStore keyStore;
  private SecureRandom secureRandom;
  private KeyGenerator aesKeyGenerator;

  @Autowired
  public LunaConnection(LunaProviderProperties lunaProviderProperties) throws Exception {
    this.lunaProviderProperties = lunaProviderProperties;
    provider = (Provider) Class.forName("com.safenetinc.luna.provider.LunaProvider").newInstance();
    Security.addProvider(provider);
    lunaSlotManager = Class.forName("com.safenetinc.luna.LunaSlotManager")
        .getDeclaredMethod("getInstance").invoke(null);

    //https://www.pivotaltracker.com/story/show/148107855
    //SecureRandom seed is 440 bytes in accordance with NIST Special Publication 800-90A Revision 1, section 10.1
    //http://nvlpubs.nist.gov/nistpubs/SpecialPublications/NIST.SP.800-90Ar1.pdf

    SecureRandom lunaRandom = SecureRandom.getInstance("LunaRNG");
    secureRandom = SecureRandom.getInstance("SHA1PRNG");
    secureRandom.setSeed(lunaRandom.generateSeed(440));

    aesKeyGenerator = KeyGenerator.getInstance("AES", provider);
    aesKeyGenerator.init(128);
  }

  @Override
  public synchronized void reconnect(Exception reasonForReconnect) {
    if (!isLoggedIn()) {
      try {
        reinitialize();
        login(lunaProviderProperties.getPartitionName(),
            lunaProviderProperties.getPartitionPassword());
        makeKeyStore();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }

  public Provider getProvider() {
    return provider;
  }

  SecureRandom getSecureRandom() {
    return secureRandom;
  }

  public SecretKey generateKey() {
    return aesKeyGenerator.generateKey();
  }

//  public KeyStore getKeyStore() {
//    return keyStore;
//  }

  private void makeKeyStore() throws Exception {
    keyStore = KeyStore.getInstance("Luna", provider);
    keyStore.load(null, null);
  }

  private void login(String partitionName, String partitionPassword) {
    try {
      lunaSlotManager.getClass().getMethod("login", String.class, String.class)
          .invoke(lunaSlotManager, partitionName, partitionPassword);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void reinitialize() {
    try {
      lunaSlotManager.getClass().getMethod("reinitialize").invoke(lunaSlotManager);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private boolean isLoggedIn() {
    try {
      return (boolean) lunaSlotManager.getClass().getMethod("isLoggedIn").invoke(lunaSlotManager);
    } catch (IllegalAccessException | NoSuchMethodException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      return false;
    }
  }

  public boolean containsAlias(String encryptionKeyAlias) throws KeyStoreException {
    return keyStore.containsAlias(encryptionKeyAlias);
  }

  public void setKeyEntry(String encryptionKeyAlias, SecretKey aesKey) throws KeyStoreException {
    keyStore.setKeyEntry(encryptionKeyAlias, aesKey, null , null);
  }

  public Key getKey(String encryptionKeyAlias)
      throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {
    return keyStore.getKey(encryptionKeyAlias, null);
  }
}
