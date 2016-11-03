package io.pivotal.security.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.pivotal.security.controller.v1.PasswordGenerationParameters;
import io.pivotal.security.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Objects;

@Component
class SecretEncryptionHelper {

  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  EncryptionService encryptionService;

  void refreshEncryptedValue(EncryptedValueContainer encryptedValueContainer, String clearTextValue) {
    if (clearTextValue == null) {
      encryptedValueContainer.setNonce(null);
      encryptedValueContainer.setEncryptedValue(null);
      return;
    }
    try {
      if (encryptedValueContainer.getNonce() == null || encryptedValueContainer.getEncryptedValue() == null || !Objects.equals(clearTextValue, encryptionService.decrypt(encryptedValueContainer.getNonce(), encryptedValueContainer.getEncryptedValue()))) {
        final EncryptionService.Encryption encryption = encryptionService.encrypt(clearTextValue);
        encryptedValueContainer.setNonce(encryption.nonce);
        encryptedValueContainer.setEncryptedValue(encryption.encryptedValue);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  String retrieveClearTextValue(EncryptedValueContainer encryptedValueContainer) {
    if (encryptedValueContainer.getNonce() == null || encryptedValueContainer.getEncryptedValue() == null) {return null;}
    try {
      return encryptionService.decrypt(encryptedValueContainer.getNonce(), encryptedValueContainer.getEncryptedValue());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void refreshEncryptedGenerationParameters(NamedPasswordSecret namedPasswordSecret, PasswordGenerationParameters generationParameters) {
    try {
      refreshEncryptedValue(new ParametersAdapter(namedPasswordSecret), objectMapper.writeValueAsString(generationParameters));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public PasswordGenerationParameters retrieveGenerationParameters(NamedPasswordSecret namedPasswordSecret) {
    String password = retrieveClearTextValue(namedPasswordSecret);
    Assert.notNull(password, "Password length generation parameter cannot be restored without an existing password");
    String json = retrieveClearTextValue(new ParametersAdapter(namedPasswordSecret));
    if (json == null) {
      return null;
    }
    try {
      return objectMapper.readValue(json, PasswordGenerationParameters.class).setLength(password.length());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static class ParametersAdapter implements EncryptedValueContainer {
    private final NamedPasswordSecret namedPasswordSecret;

    ParametersAdapter(NamedPasswordSecret namedPasswordSecret) {
      this.namedPasswordSecret = namedPasswordSecret;
    }

    @Override
    public byte[] getEncryptedValue() {
      return namedPasswordSecret.getEncryptedGenerationParameters();
    }

    @Override
    public void setEncryptedValue(byte[] encryptedValue) {
      namedPasswordSecret.setEncryptedGenerationParameters(encryptedValue);
    }

    @Override
    public byte[] getNonce() {
      return namedPasswordSecret.getParametersNonce();
    }

    @Override
    public void setNonce(byte[] nonce) {
      namedPasswordSecret.setParametersNonce(nonce);
    }
  }
}
