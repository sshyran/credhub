package org.cloudfoundry.credhub.utils;

final public class TestConstants {

  private TestConstants() {
    super();
  }

  public static final String INVALID_PRIVATE_KEY_NO_HEADERS;

  static {
    INVALID_PRIVATE_KEY_NO_HEADERS = "some-invalid-private-key";
  }

  public static final String INVALID_PRIVATE_KEY_WITH_HEADERS;

  static {
    INVALID_PRIVATE_KEY_WITH_HEADERS =
      "-----BEGIN RSA PRIVATE KEY----- fake\n" +
        "MIIEpQIBAAKCAQEAwqIrV8HpCuPyuJ6VvyG7gVhYJGAOX4zhclxkTAKT5rkE4Lfj\n" +
        "048GZsDghK+pHs+tVotfyrJzYGJoEBTn9Wy7kP5pQmLRF54imDztep15OlyoJmLZ\n" +
        "fRgct/8Kyxkjgg3PKVw68IiNhnTlYaw4CAyZ/13mvw2cWIYlag9LV5R2ifcyubaY\n" +
        "llxJhdWSXrcbYxrts1kRsUQTo99jJzKu71meLigMryaMry8xvjv1X8Yjq3s3Lud6\n" +
        "gWZ6BuaaaVVIjI9clGgR1MkgKJgVkWjNzDRiCxYnq1LHCho9bgKgiY4p604zPk9M\n" +
        "w4FhtCbOim6HOsHTimONZXfDNmfsJ9wJefA0UwIDAQABAoIBAEwsTcxFvuAdQFRS\n" +
        "9IZePFUt7yklUtrAd0dbs4EwDRRiWu9b6NVWh4nVeMlVOlotq0hQucfJuXACc3m/\n" +
        "xNx/lpTzjNyHcg/NOvrb9ZFkahqWQtTrIPVdZ3f3YBEGoKf4oZgtWX/j4Ye63j8w\n" +
        "uKklzWttI66oNAVNUv1ESRdYql/p5/BVSJaVK4bdkXqYHX2j3PrPd30ICwxz0bGd\n" +
        "41UdMiKMJhlkhIESsB8bcdRAEaMS2OaFKmBYIQF4RuY3syvFizJDtp/QEYfjy9tT\n" +
        "Xokd3Wzs6dncn/yyfvT0+yCDjYsNAgFvBmfHNBorywxILdtgJHuc9oO2EOeg58VK\n" +
        "Vt4eugECgYEA/wxb29pVamwxF71gKx/msBa5kwxV5N7NhTLdYyHwhQVErQlwn7Dg\n" +
        "J8qLfZqmn231yoGpKLZsu2mxdRvpd9nvOiW+ZF+fsrS8SEs5dMEqhojALm8rur+Y\n" +
        "5M0/Sk/A0lCbSmV+X7vmqaGzyNdgH7tYVIxXjAo4sEYN6GevjUB1JQECgYEAw1wZ\n" +
        "BhhsIvW9gfbuCdiTGlezUuIO3oxjvSSTNUaGAB7GUqB26toBnXi6oQi5iGu/dCYU\n" +
        "3CILOkV7kTX//2njOfWLp/kP+5nVKDgHoA/0gL609sgrdgkQ0KdZ3iuurimeqvDm\n" +
        "U5hpPrNcwz7yPJ/M081ve84pHq3wzVKpi1dMNVMCgYEA4e5JxTTg63hR+MyqTylg\n" +
        "SmanF2sa/7aa6r6HPRTIop1rG7m8Cco+lyEmdiq0JZDb5fr8JXOMWGylZa9HHwNw\n" +
        "ltrukK3gowbVr1jr2dBv4mNrkvaqDzFAuJZU1XhWwDfliH7l9tpV17jFsUmQ/isQ\n" +
        "cT0tJIG9e/Fiyphm+8K4wwECgYEAwXbCHUQwSoq7aiokX0HHo624G1tcyE2VNCk1\n" +
        "UuwNJa9UTV01hqvwL4bwoyqluZCin55ayAk6vzEyBoLIiqLM8IfXDrhaeJpF+jdK\n" +
        "bdt/EcRKJ53hVFnz+f3QxHDT4wu6YqSAI8bqarprIbuDXkAOMq3eOmfWVtiAgITc\n" +
        "++2uvZsCgYEAmpN2RfHxO3huEWFoE7LTy9WTv4DDHI+g8PeCUpP2pN/UmczInyQ4\n" +
        "OlKeNTSxn9AkyYx9PJ8i1TIx6GyFIX4pkJczLEu+XINm82MKSBGuRL1EUvkVddx3\n" +
        "6clZk5BLDXjmCtCr5DGZ01EbT0wsbsBM1GtoCS4+vUQkJVHb0r6/ZdXX=\n" +
        "-----END RSA PRIVATE KEY-----";
  }

  // generate with ./build/credhub n -t ssh -n foo -k 4096
  public static final String SSH_PUBLIC_KEY_4096;

  static {
    SSH_PUBLIC_KEY_4096 =
      "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQDs8lQIdJ+tnc9jufX9wLzCPVS1utoTJ"
        + "wzQO2NS5F07OEWXnR94XtYY3KtBLu10LHjZzH5maxdWYkyb4GgYSwV+6ln+Txn7"
        + "9LQT8gStbK+mJBFWnGplHNU+loHdHkKckOVihBgDfjsW58s46X9HmKAiUetXBaz"
        + "QX2pVOhOKBETgEstVKB1CoN0fP98mbergW+THHxDpbtodep1EoWZePn/Qe/jly7"
        + "joL8HZuVAwzunmBsrrm0B1cRF3mG4/XZDdHqbz1humoz/8V8KMBuC899XhN1yZv"
        + "mdZqe3OhpENr8O3e26p7xxTyCyOs5kk2Myv7YqWOyr43obFIzGUcLLMj3p1SDuk"
        + "gzpxCHPmiZ72zO/hZ+HkB6319iZPsZgrR8vapQsJY5MfYJO9KPj0BKlFdi9y578"
        + "VCj1pw6OYz7fuRrSfu/W0S1l9FLI450aFsNSji5ZX7elJ5A0qDQaFblECAsmbMj"
        + "T9MCDyJDjZfmtb9UY4j/ywFeYP26RLqbdWMZBYgukVg+isCyxJczecaJKRWBnUr"
        + "yz5sSvbsOC38rdu7LAl/vxf8m2ZY6d/TZ2SgTEDgD4YxOG6WZEm2z2JGpgGtQcV"
        + "O4ulfSa/xqovvidLc/kTWR15dVts+r1Uv7Btaax7XqTKqBkrxjhbpXD2RVQAeZh"
        + "BOQ80pPbFtvUPN1pAdgc14w==";
  }

  public static final String SSH_PUBLIC_KEY_4096_WITH_COMMENT;

  static {
    SSH_PUBLIC_KEY_4096_WITH_COMMENT =
      "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQDs8lQIdJ+tnc9jufX9wLzCPVS1utoTJ"
        + "wzQO2NS5F07OEWXnR94XtYY3KtBLu10LHjZzH5maxdWYkyb4GgYSwV+6ln+Txn7"
        + "9LQT8gStbK+mJBFWnGplHNU+loHdHkKckOVihBgDfjsW58s46X9HmKAiUetXBaz"
        + "QX2pVOhOKBETgEstVKB1CoN0fP98mbergW+THHxDpbtodep1EoWZePn/Qe/jly7"
        + "joL8HZuVAwzunmBsrrm0B1cRF3mG4/XZDdHqbz1humoz/8V8KMBuC899XhN1yZv"
        + "mdZqe3OhpENr8O3e26p7xxTyCyOs5kk2Myv7YqWOyr43obFIzGUcLLMj3p1SDuk"
        + "gzpxCHPmiZ72zO/hZ+HkB6319iZPsZgrR8vapQsJY5MfYJO9KPj0BKlFdi9y578"
        + "VCj1pw6OYz7fuRrSfu/W0S1l9FLI450aFsNSji5ZX7elJ5A0qDQaFblECAsmbMj"
        + "T9MCDyJDjZfmtb9UY4j/ywFeYP26RLqbdWMZBYgukVg+isCyxJczecaJKRWBnUr"
        + "yz5sSvbsOC38rdu7LAl/vxf8m2ZY6d/TZ2SgTEDgD4YxOG6WZEm2z2JGpgGtQcV"
        + "O4ulfSa/xqovvidLc/kTWR15dVts+r1Uv7Btaax7XqTKqBkrxjhbpXD2RVQAeZh"
        + "BOQ80pPbFtvUPN1pAdgc14w== dan@foo";
  }

  public static final String RSA_PUBLIC_KEY_4096;

  static {
    RSA_PUBLIC_KEY_4096 =
      "-----BEGIN PUBLIC KEY-----\n"
        + "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEA7PJUCHSfrZ3PY7n1/cC8\n"
        + "wj1UtbraEycM0DtjUuRdOzhFl50feF7WGNyrQS7tdCx42cx+ZmsXVmJMm+BoGEsF\n"
        + "fupZ/k8Z+/S0E/IErWyvpiQRVpxqZRzVPpaB3R5CnJDlYoQYA347FufLOOl/R5ig\n"
        + "IlHrVwWs0F9qVToTigRE4BLLVSgdQqDdHz/fJm3q4Fvkxx8Q6W7aHXqdRKFmXj5/\n"
        + "0Hv45cu46C/B2blQMM7p5gbK65tAdXERd5huP12Q3R6m89YbpqM//FfCjAbgvPfV\n"
        + "4Tdcmb5nWantzoaRDa/Dt3tuqe8cU8gsjrOZJNjMr+2Kljsq+N6GxSMxlHCyzI96\n"
        + "dUg7pIM6cQhz5ome9szv4Wfh5Aet9fYmT7GYK0fL2qULCWOTH2CTvSj49ASpRXYv\n"
        + "cue/FQo9acOjmM+37ka0n7v1tEtZfRSyOOdGhbDUo4uWV+3pSeQNKg0GhW5RAgLJ\n"
        + "mzI0/TAg8iQ42X5rW/VGOI/8sBXmD9ukS6m3VjGQWILpFYPorAssSXM3nGiSkVgZ\n"
        + "1K8s+bEr27Dgt/K3buywJf78X/JtmWOnf02dkoExA4A+GMThulmRJts9iRqYBrUH\n"
        + "FTuLpX0mv8aqL74nS3P5E1kdeXVbbPq9VL+wbWmse16kyqgZK8Y4W6Vw9kVUAHmY\n"
        + "QTkPNKT2xbb1DzdaQHYHNeMCAwEAAQ==\n"
        + "-----END PUBLIC KEY-----";
  }

  public static final String PRIVATE_KEY_4096;

  static {
    PRIVATE_KEY_4096 =
      "-----BEGIN RSA PRIVATE KEY----- fake\n"
        + "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\n"
        + "-----END RSA PRIVATE KEY-----";
  }

  public static final String TEST_CA;

  static {
    TEST_CA =
      "-----BEGIN CERTIFICATE-----\n" +
        "MIIDTTCCAjWgAwIBAgIULxxoB3zfye0MzzRQGtKtw8CC2p4wDQYJKoZIhvcNAQEL\n" +
        "BQAwGjEYMBYGA1UEAwwPZm9vX2NlcnRpZmljYXRlMB4XDTE3MTEyMTE2MjQ1NFoX\n" +
        "DTE4MTEyMTE2MjQ1NFowGjEYMBYGA1UEAwwPZm9vX2NlcnRpZmljYXRlMIIBIjAN\n" +
        "BgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvgmVFC08CaGlp2ENKc5mym9BkcEL\n" +
        "E2030VXTJJSiLH1Py3s79rbJL4F/loxAMSbQCuKIADZZ4Wu7Xp8bFY92u0nNrAuG\n" +
        "Xw1omhfF5UTi1vewRG8inxdJZs9vxsiXZWI6WzUpvJZeCMvvKlkhA/C+GwjpIdRg\n" +
        "3fVZ44JvdZOx4cDUagRkDRcsHABp/ip19xhfZGLwFuJw1wd5kxZmZKCreoel+b/5\n" +
        "BaQyFD0L9OkSfq1Y/nMqOdIbXEnpeg8sawhQan0s7G98MTsvDF14jnucCECLO1fg\n" +
        "1YpxoBTDkNlrIPq4G8UO4+GNz5FJEIBGOsiRmEn0VjFEpZ3k+t/Nkf/b6wIDAQAB\n" +
        "o4GKMIGHMB0GA1UdDgQWBBQ3ZlJJaG9Brzf3IM6tWsMJce6YIDBVBgNVHSMETjBM\n" +
        "gBQ3ZlJJaG9Brzf3IM6tWsMJce6YIKEepBwwGjEYMBYGA1UEAwwPZm9vX2NlcnRp\n" +
        "ZmljYXRlghQvHGgHfN/J7QzPNFAa0q3DwILanjAPBgNVHRMBAf8EBTADAQH/MA0G\n" +
        "CSqGSIb3DQEBCwUAA4IBAQAlbxUF4Eaz0tXSo7oM02Mt3YqhuP7XZpZE5KYpn5qE\n" +
        "utYzJdSJeMsfUpZcmv1pbZ4uepxgBxQKssKRmglzEMX2wxl9WyEPxKkyLTX+XCX9\n" +
        "Vd6IBi5Pft6v2u94bKlGZKigNojGfbzXDYuSU6SAud5GD77RM1vx/pPAa2eG8qSX\n" +
        "OcGQAtHrcSAvl58IqXAmci3akNKN4G5PxNoze5lQ25umQbHTlwvOMwFgPSXseYvm\n" +
        "/f98b+Q6lIdklw6g3XWUCmTkscRM+5mvb+1FKHWU8KiXN7CM+ONXjudO8Ixyyion\n" +
        "pBumFgiA2FQXUpunDCv38dccPb8y/EyhRSQyx+olXqo+\n" +
        "-----END CERTIFICATE-----";
  }

  public static final String TEST_TRUSTED_CA;

  static {
    TEST_TRUSTED_CA =
      "-----BEGIN CERTIFICATE-----\n" +
        "MIIDTTCCAjWgAwIBAgIULxxoB3zfye0MzzRQGtKtw8CC2p4wDQYJKoZIhvcNAQEL\n" +
        "BQAwGjEYMBYGA1UEAwwPZm9vX2NlcnRpZmljYXRlMB4XDTE3MTEyMTE2MjQ1NFoX\n" +
        "DTE4MTEyMTE2MjQ1NFowGjEYMBYGA1UEAwwPZm9vX2NlcnRpZmljYXRlMIIBIjAN\n" +
        "BgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvgmVFC08CaGlp2ENKc5mym9BkcEL\n" +
        "E2030VXTJJSiLH1Py3s79rbJL4F/loxAMSbQCuKIADZZ4Wu7Xp8bFY92u0nNrAuG\n" +
        "Xw1omhfF5UTi1vewRG8inxdJZs9vxsiXZWI6WzUpvJZeCMvvKlkhA/C+GwjpIdRg\n" +
        "3fVZ44JvdZOx4cDUagRkDRcsHABp/ip19xhfZGLwFuJw1wd5kxZmZKCreoel+b/5\n" +
        "BaQyFD0L9OkSfq1Y/nMqOdIbXEnpeg8sawhQan0s7G98MTsvDF14jnucCECLO1fg\n" +
        "1YpxoBTDkNlrIPq4G8UO4+GNz5FJEIBGOsiRmEn0VjFEpZ3k+t/Nkf/b6wIDAQAB\n" +
        "o4GKMIGHMB0GA1UdDgQWBBQ3ZlJJaG9Brzf3IM6tWsMJce6YIDBVBgNVHSMETjBM\n" +
        "gBQ3ZlJJaG9Brzf3IM6tWsMJce6YIKEepBwwGjEYMBYGA1UEAwwPZm9vX2NlcnRp\n" +
        "ZmljYXRlghQvHGgHfN/J7QzPNFAa0q3DwILanjAPBgNVHRMBAf8EBTADAQH/MA0G\n" +
        "CSqGSIb3DQEBCwUAA4IBAQAlbxUF4Eaz0tXSo7oM02Mt3YqhuP7XZpZE5KYpn5qE\n" +
        "utYzJdSJeMsfUpZcmv1pbZ4uepxgBxQKssKRmglzEMX2wxl9WyEPxKkyLTX+XCX9\n" +
        "Vd6IBi5Pft6v2u94bKlGZKigNojGfbzXDYuSU6SAud5GD77RM1vx/pPAa2eG8qSX\n" +
        "OcGQAtHrcSAvl58IqXAmci3akNKN4G5PxNoze5lQ25umQbHTlwvOMwFgPSXseYvm\n" +
        "/f98b+Q6lIdklw6g3XWUCmTkscRM+5mvb+1FKHWU8KiXN7CM+ONXjudO8Ixyyion\n" +
        "pBumFgiA2FQXUpunDCv38dccPb8y/EyhRSQyx+Trusted+\n" +
        "-----END CERTIFICATE-----";
  }

  public static final String TEST_CERTIFICATE;

  static {
    TEST_CERTIFICATE =
      "-----BEGIN CERTIFICATE-----\n" +
        "MIIDSjCCAjKgAwIBAgIUdpQ3G/AnIilrPAsvMz3Zf9VnvWgwDQYJKoZIhvcNAQEL\n" +
        "BQAwGjEYMBYGA1UEAwwPZm9vX2NlcnRpZmljYXRlMB4XDTE3MTEyMTE2MjUyMFoX\n" +
        "DTE4MTEyMTE2MjUyMFowGjEYMBYGA1UEAwwPZm9vX2NlcnRpZmljYXRlMIIBIjAN\n" +
        "BgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwqIrV8HpCuPyuJ6VvyG7gVhYJGAO\n" +
        "X4zhclxkTAKT5rkE4Lfj048GZsDghK+pHs+tVotfyrJzYGJoEBTn9Wy7kP5pQmLR\n" +
        "F54imDztep15OlyoJmLZfRgct/8Kyxkjgg3PKVw68IiNhnTlYaw4CAyZ/13mvw2c\n" +
        "WIYlag9LV5R2ifcyubaYllxJhdWSXrcbYxrts1kRsUQTo99jJzKu71meLigMryaM\n" +
        "ry8xvjv1X8Yjq3s3Lud6gWZ6BuaaaVVIjI9clGgR1MkgKJgVkWjNzDRiCxYnq1LH\n" +
        "Cho9bgKgiY4p604zPk9Mw4FhtCbOim6HOsHTimONZXfDNmfsJ9wJefA0UwIDAQAB\n" +
        "o4GHMIGEMB0GA1UdDgQWBBTyAOrrFMy88bGgEBVI4PRGD4b02jBVBgNVHSMETjBM\n" +
        "gBQ3ZlJJaG9Brzf3IM6tWsMJce6YIKEepBwwGjEYMBYGA1UEAwwPZm9vX2NlcnRp\n" +
        "ZmljYXRlghQvHGgHfN/J7QzPNFAa0q3DwILanjAMBgNVHRMBAf8EAjAAMA0GCSqG\n" +
        "SIb3DQEBCwUAA4IBAQBC1x2+E35y+iX3Mu+SWD1I3RNTGE3qKdUqj+O+QeavqCRQ\n" +
        "01nolxFaSvrM/4znAlWukfp9lCOHl8foD3vHQ+meW+PlLIH9HlBjn9T3c6h4p8EQ\n" +
        "iYV93tyCmUlPdtzW7k4Onl3IroNNHem9Uj+OSZxGtw35YU84T+hM1kaDKtZeS1je\n" +
        "FWF1W8DCORxD2rFXFwe2nJd6SSeF3KWzuKAKDqJ7CmbdRb1TtgjUym6X55SQfW2a\n" +
        "dwNE+9ztMBQm4ERhwMU/NMx14UjsOPvNjF1VVei52qQ2ce7c1vgW1RI2cYFgV8q8\n" +
        "oFjMdJePy7eLbGRaW7Jpdy9MOiEZOj513lT5MBGk\n" +
        "-----END CERTIFICATE-----";
  }

  public static final String TEST_PRIVATE_KEY;

  static {
    TEST_PRIVATE_KEY =
      "-----BEGIN RSA PRIVATE KEY----- fake\n" +
        "MIIEpQIBAAKCAQEAwqIrV8HpCuPyuJ6VvyG7gVhYJGAOX4zhclxkTAKT5rkE4Lfj\n" +
        "048GZsDghK+pHs+tVotfyrJzYGJoEBTn9Wy7kP5pQmLRF54imDztep15OlyoJmLZ\n" +
        "fRgct/8Kyxkjgg3PKVw68IiNhnTlYaw4CAyZ/13mvw2cWIYlag9LV5R2ifcyubaY\n" +
        "llxJhdWSXrcbYxrts1kRsUQTo99jJzKu71meLigMryaMry8xvjv1X8Yjq3s3Lud6\n" +
        "gWZ6BuaaaVVIjI9clGgR1MkgKJgVkWjNzDRiCxYnq1LHCho9bgKgiY4p604zPk9M\n" +
        "w4FhtCbOim6HOsHTimONZXfDNmfsJ9wJefA0UwIDAQABAoIBAEwsTcxFvuAdQFRS\n" +
        "9IZePFUt7yklUtrAd0dbs4EwDRRiWu9b6NVWh4nVeMlVOlotq0hQucfJuXACc3m/\n" +
        "xNx/lpTzjNyHcg/NOvrb9ZFkahqWQtTrIPVdZ3f3YBEGoKf4oZgtWX/j4Ye63j8w\n" +
        "uKklzWttI66oNAVNUv1ESRdYql/p5/BVSJaVK4bdkXqYHX2j3PrPd30ICwxz0bGd\n" +
        "41UdMiKMJhlkhIESsB8bcdRAEaMS2OaFKmBYIQF4RuY3syvFizJDtp/QEYfjy9tT\n" +
        "Xokd3Wzs6dncn/yyfvT0+yCDjYsNAgFvBmfHNBorywxILdtgJHuc9oO2EOeg58VK\n" +
        "Vt4eugECgYEA/wxb29pVamwxF71gKx/msBa5kwxV5N7NhTLdYyHwhQVErQlwn7Dg\n" +
        "J8qLfZqmn231yoGpKLZsu2mxdRvpd9nvOiW+ZF+fsrS8SEs5dMEqhojALm8rur+Y\n" +
        "5M0/Sk/A0lCbSmV+X7vmqaGzyNdgH7tYVIxXjAo4sEYN6GevjUB1JQECgYEAw1wZ\n" +
        "BhhsIvW9gfbuCdiTGlezUuIO3oxjvSSTNUaGAB7GUqB26toBnXi6oQi5iGu/dCYU\n" +
        "3CILOkV7kTX//2njOfWLp/kP+5nVKDgHoA/0gL609sgrdgkQ0KdZ3iuurimeqvDm\n" +
        "U5hpPrNcwz7yPJ/M081ve84pHq3wzVKpi1dMNVMCgYEA4e5JxTTg63hR+MyqTylg\n" +
        "SmanF2sa/7aa6r6HPRTIop1rG7m8Cco+lyEmdiq0JZDb5fr8JXOMWGylZa9HHwNw\n" +
        "ltrukK3gowbVr1jr2dBv4mNrkvaqDzFAuJZU1XhWwDfliH7l9tpV17jFsUmQ/isQ\n" +
        "cT0tJIG9e/Fiyphm+8K4wwECgYEAwXbCHUQwSoq7aiokX0HHo624G1tcyE2VNCk1\n" +
        "UuwNJa9UTV01hqvwL4bwoyqluZCin55ayAk6vzEyBoLIiqLM8IfXDrhaeJpF+jdK\n" +
        "bdt/EcRKJ53hVFnz+f3QxHDT4wu6YqSAI8bqarprIbuDXkAOMq3eOmfWVtiAgITc\n" +
        "++2uvZsCgYEAmpN2RfHxO3huEWFoE7LTy9WTv4DDHI+g8PeCUpP2pN/UmczInyQ4\n" +
        "OlKeNTSxn9AkyYx9PJ8i1TIx6GyFIX4pkJczLEu+XINm82MKSBGuRL1EUvkVddx3\n" +
        "6clZk5BLDXjmCtCr5DGZ01EbT0wsbsBM1GtoCS4+vUQkJVHb0r6/ZdM=\n" +
        "-----END RSA PRIVATE KEY-----";
  }

  public static final String TEST_PRIVATE_KEY_PKCS8;

  static {
    TEST_PRIVATE_KEY_PKCS8 =
      "-----BEGIN PRIVATE KEY----- fake\n" +
        "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDCoitXwekK4/K4\n" +
        "npW/IbuBWFgkYA5fjOFyXGRMApPmuQTgt+PTjwZmwOCEr6kez61Wi1/KsnNgYmgQ\n" +
        "FOf1bLuQ/mlCYtEXniKYPO16nXk6XKgmYtl9GBy3/wrLGSOCDc8pXDrwiI2GdOVh\n" +
        "rDgIDJn/Xea/DZxYhiVqD0tXlHaJ9zK5tpiWXEmF1ZJetxtjGu2zWRGxRBOj32Mn\n" +
        "Mq7vWZ4uKAyvJoyvLzG+O/VfxiOrezcu53qBZnoG5pppVUiMj1yUaBHUySAomBWR\n" +
        "aM3MNGILFierUscKGj1uAqCJjinrTjM+T0zDgWG0Js6Kboc6wdOKY41ld8M2Z+wn\n" +
        "3Al58DRTAgMBAAECggEATCxNzEW+4B1AVFL0hl48VS3vKSVS2sB3R1uzgTANFGJa\n" +
        "71vo1VaHidV4yVU6Wi2rSFC5x8m5cAJzeb/E3H+WlPOM3IdyD806+tv1kWRqGpZC\n" +
        "1Osg9V1nd/dgEQagp/ihmC1Zf+Phh7rePzC4qSXNa20jrqg0BU1S/URJF1iqX+nn\n" +
        "8FVIlpUrht2RepgdfaPc+s93fQgLDHPRsZ3jVR0yIowmGWSEgRKwHxtx1EARoxLY\n" +
        "5oUqYFghAXhG5jezK8WLMkO2n9ARh+PL21NeiR3dbOzp2dyf/LJ+9PT7IIONiw0C\n" +
        "AW8GZ8c0GivLDEgt22Ake5z2g7YQ56DnxUpW3h66AQKBgQD/DFvb2lVqbDEXvWAr\n" +
        "H+awFrmTDFXk3s2FMt1jIfCFBUStCXCfsOAnyot9mqafbfXKgakotmy7abF1G+l3\n" +
        "2e86Jb5kX5+ytLxISzl0wSqGiMAubyu6v5jkzT9KT8DSUJtKZX5fu+apobPI12Af\n" +
        "u1hUjFeMCjiwRg3oZ6+NQHUlAQKBgQDDXBkGGGwi9b2B9u4J2JMaV7NS4g7ejGO9\n" +
        "JJM1RoYAHsZSoHbq2gGdeLqhCLmIa790JhTcIgs6RXuRNf//aeM59Yun+Q/7mdUo\n" +
        "OAegD/SAvrT2yCt2CRDQp1neK66uKZ6q8OZTmGk+s1zDPvI8n8zTzW97zikerfDN\n" +
        "UqmLV0w1UwKBgQDh7knFNODreFH4zKpPKWBKZqcXaxr/tprqvoc9FMiinWsbubwJ\n" +
        "yj6XISZ2KrQlkNvl+vwlc4xYbKVlr0cfA3CW2u6QreCjBtWvWOvZ0G/iY2uS9qoP\n" +
        "MUC4llTVeFbAN+WIfuX22lXXuMWxSZD+KxBxPS0kgb178WLKmGb7wrjDAQKBgQDB\n" +
        "dsIdRDBKirtqKiRfQcejrbgbW1zITZU0KTVS7A0lr1RNXTWGq/AvhvCjKqW5kKKf\n" +
        "nlrICTq/MTIGgsiKoszwh9cOuFp4mkX6N0pt238RxEonneFUWfP5/dDEcNPjC7pi\n" +
        "pIAjxupqumshu4NeQA4yrd46Z9ZW2ICAhNz77a69mwKBgQCak3ZF8fE7eG4RYWgT\n" +
        "stPL1ZO/gMMcj6Dw94JSk/ak39SZzMifJDg6Up41NLGf0CTJjH08nyLVMjHobIUh\n" +
        "fimQlzMsS75cg2bzYwpIEa5EvURS+RV13HfpyVmTkEsNeOYK0KvkMZnTURtPTCxu\n" +
        "wEzUa2gJLj69RCQlUdvSvr9l0w==\n" +
        "-----END PRIVATE KEY-----";
  }

  public static final String TEST_PRIVATE_KEY_EC;

  static {
    TEST_PRIVATE_KEY_EC =
      "-----BEGIN EC PRIVATE KEY----- fake\n" +
        "MHcCAQEEINZ8J4RQ62sqtAPjcXxDjGbXxw09K+9elaypfMlPwsNSoAoGCCqGSM49\n" +
        "AwEHoUQDQgAEvTOI8qakeZy8Y1K/yS8pgM9w1vJRBjWc8nz7E1ggm4RrMTyXzcZN\n" +
        "1S4D2k7uEFzZxn5eA6xMZIkh7NhT27mUkg==\n" +
        "-----END EC PRIVATE KEY-----";
  }

  public static final String ENCRYPTED_TEST_PRIVATE_KEY_PKCS8;

  static {
    ENCRYPTED_TEST_PRIVATE_KEY_PKCS8 =
      "-----BEGIN ENCRYPTED PRIVATE KEY----- fake\n" +
        "MIIE6jAcBgoqhkiG9w0BDAEDMA4ECPt3btTgM9ZcAgIIAASCBMh26jzOmE54opmm\n" +
        "v5Pj0nGz11DeOa/xc+W2BP0M/KonnbrEiCJuUShcp5Q4YRj68Ey/X1jJfo1Us5ad\n" +
        "ZDuBsHt66o3fACBPzzTqxBNUIhyHr7b44cigICgZrQZ+fxhtICoyoM7yn1rzFP+K\n" +
        "wrwIASb1UOy93ZBHYtnAvJnXkFXqU3Dw0+yDgwRc7Jo8MMJSOI6SviH5Bf2q9DQ4\n" +
        "7cx9BUr5d+jCmJWgtgq1OCbBuSruBaU6NVr1W9P67066PknQ6RnOLCFq/+YkoNXT\n" +
        "dWo3UdGs3sQ90+EkjxaegdmvlbxCXHPpLqDcwd6YwY2RJEt5bFyeYbkEOBK6jP8R\n" +
        "/F9zGfIEV1guvrd4DV4zgp1acn2R0gkCbKf8ZDZrrMSx85B+TDxiWlzLnCCR5DSw\n" +
        "4EmLZImvJR5WQlbS4kdvCWpZsBllEoBmBtqSwIoNy+gkPkgs/mF+NXpOis2SPID3\n" +
        "tbdckrVrEGKPWcPy47rGQ2FYKiA2BUruPjO2pL9kATs34Tgu9Dw3lhpSRsGHqM3a\n" +
        "nC7bQqAnqdWQsHEIWi/UnRB6qknbU3A5NJqP+0696Ewa3IVF1LYv0QIELx/q7jPN\n" +
        "KZXlcMQrCPEulzAAJTSzOhVgr61DXeAera/Fd8tDjOOgmdrwiER/V4l8ii2YaSJw\n" +
        "2X1H48dbeznhzbPIEOZwhxZfnlwTDYJpVtwp8eAW7QtYzOEfarw+zSk+PbAgKHpd\n" +
        "iW2UnO2GxVXO6VXmtyeRuBjNZEaNzZYYHulUmZx/k6YwRUe5OruDg3EljnESL+n7\n" +
        "QfJBK21VZnR70RLuGLFIQf8bWYtwVvOtliBJhgv1eICTXBFCNyFYf+QPVDHeQrQL\n" +
        "ekBggOUVOtWIZpovHKj/8FW/OLdMBKpwywX6HO0+zGhi6CI4BPwoWvCdUdGHMD7e\n" +
        "rfuNVU8w1ILbnoQeslbcOBU13iEKouVNGVQQ2GxQje6DP1B+7Kd0W8CU1tF5gANQ\n" +
        "vQaHRx6klb3SxXcFoIDNT9y3GXj73NCZtm897wUzrvbXATIjmggtctHwa39ElzK/\n" +
        "Y90Ihj0/+IFYByhwiz8YujuOaXAntkHSRT3H+6e7Zxb5e4pKakXGJAu9Ib3buXmv\n" +
        "GLHjJIAazYnp7HVD3kbkbNO4XOVt92P4+VKripRw+9NxfCJ297KxPiP4CXTTb0fE\n" +
        "HDx40giML8C2Y59l7D8ikxOjSsaB4R3EQtPE1MLXbkHBThltOAJy0broxP1U/0qb\n" +
        "IhM64CHRgXiJVEP4u021h2UAwpQ0q++5sSDthaf9xuEjnjuJIWxJdYDK3evmCzYi\n" +
        "DSk06OcyhE1wUkuTbuV9JmzK1/e1VV1XNEgFDMk6UCtKVPbwJH2/JFiFu1ZogDA+\n" +
        "1gGBX1oHgYlLurq3QtsCw31t82j9RNrNS45+aScdADhYRYnnHduDhWp91xFUxJQD\n" +
        "fnnkA9wEmrnhypT8f3ucGYKlXAOMtZkvH+YW3DWv1vE0Ls7TKJcLAstcEMyo/PSX\n" +
        "z5IGj7RWEPXzRLN+eInP5XWRiAc1FgSzAjilgM5sWGfXI0qA2j4zoLq/AKeG+k+U\n" +
        "1VNrYBSTI+u+ervajgm9vIkaFX8kw7UhvvgJW8rDVHZ0pujrnhAHTtnhjeglu3fK\n" +
        "j0zvXFM0rvA8UQHOWyU=\n" +
        "-----END ENCRYPTED PRIVATE KEY-----";
  }

  public static final String OTHER_TEST_CERTIFICATE;

  static {
    OTHER_TEST_CERTIFICATE =
      "-----BEGIN CERTIFICATE----- fake\n" +
        "MIIC5jCCAc4CCQDiRd5QC3sIpjANBgkqhkiG9w0BAQsFADA1MQswCQYDVQQGEwJ1\n" +
        "czELMAkGA1UECAwCbnkxCzAJBgNVBAcMAm55MQwwCgYDVQQDDANwaXYwHhcNMTkw\n" +
        "MzIwMTkzOTAzWhcNMTkwNDE5MTkzOTAzWjA1MQswCQYDVQQGEwJ1czELMAkGA1UE\n" +
        "CAwCbnkxCzAJBgNVBAcMAm55MQwwCgYDVQQDDANwaXYwggEiMA0GCSqGSIb3DQEB\n" +
        "AQUAA4IBDwAwggEKAoIBAQDmY9+PKJCe6Isk9hV4czDBE/iOu0Zi3rvwIK6dWbJq\n" +
        "j2z3lCJgmsLTG16r4kYXsKwjDfviBFhny0KtGfre+vizOeCHNf+RtIJ2W7bVmZoF\n" +
        "HGsv4niygmmYitlLRkVMBZ08SKEx7X6/TjsFFZYqt9GEVjwJEjSzDsb5HOEsFwgS\n" +
        "u9g7v07gQ2J2+AlsqLmM/IdpAJH1dHIha4wnxZaSlIyvKTMgs2RmOrFEEk1tuKqz\n" +
        "P7XdtWZC1DGxVPpNjyCHjVmcK9uI6nQU6S+FWObOngGYyaOw6nICgPCGmLUt7adK\n" +
        "MIZdYifjC0d4tJFIbKtHT9QcKOYu7EeAD6YVg6Xz8VHZAgMBAAEwDQYJKoZIhvcN\n" +
        "AQELBQADggEBAKT7jsM9LB8tvxRErm1vENAiO6rIkqcSO4+/cnaOISOELu8A0mdi\n" +
        "9AaI9hE60BNeJvZdLuyQKOyIC3+ky2WCza+J9ajoVR2GWDDz60j2YIArSjFhm5Bo\n" +
        "YfnFyvT59b/QRy4Uh4xlHXRPOGfg5vC99tk3omgyV9w37sUzKah/BkwLhtqkCVGF\n" +
        "HIkal0qkT084giO8S7pV0MO3ua+cmaSr8C1pRsRX91uFf8alNTjV3eeobeOb8xe7\n" +
        "ZW83Uc7T0H06XgTr4pH4ploR2hm8d36NlUPaYw4UMmCidYbNliuY35Zc8PUApJGV\n" +
        "PTH1yYdWl8KRAujeBsA+t+pXHH3WxZac4nY=\n" +
        "-----END CERTIFICATE-----";
  }

  public static final String OTHER_TEST_PRIVATE_KEY;

  static {
    OTHER_TEST_PRIVATE_KEY =
      "-----BEGIN RSA PRIVATE KEY----- fake\n" +
        "MIIEpQIBAAKCAQEA5mPfjyiQnuiLJPYVeHMwwRP4jrtGYt678CCunVmyao9s95Qi\n" +
        "YJrC0xteq+JGF7CsIw374gRYZ8tCrRn63vr4sznghzX/kbSCdlu21ZmaBRxrL+J4\n" +
        "soJpmIrZS0ZFTAWdPEihMe1+v047BRWWKrfRhFY8CRI0sw7G+RzhLBcIErvYO79O\n" +
        "4ENidvgJbKi5jPyHaQCR9XRyIWuMJ8WWkpSMrykzILNkZjqxRBJNbbiqsz+13bVm\n" +
        "QtQxsVT6TY8gh41ZnCvbiOp0FOkvhVjmzp4BmMmjsOpyAoDwhpi1Le2nSjCGXWIn\n" +
        "4wtHeLSRSGyrR0/UHCjmLuxHgA+mFYOl8/FR2QIDAQABAoIBAQDLucUWcmhwHHHu\n" +
        "XSzfNf0GvwIsNK4o/4xw6nV97rM2R120D+nWQwPEaY9trskMac3Nsa/qTK1gGvz6\n" +
        "1N5iDsucsLE63yT/Uv+Kac9jUlA/9MFTto/ESk3V9fHv/lOIxe4kQJVJ8RkDUcoe\n" +
        "1NfVLna27wpnexHexFJuNntm4XbiGEtJhNyrkS9KyCygkojp+AAsY0nR6Rv+9Fua\n" +
        "n97DroAdSA0EbHky70E3efbb3obmpG1Fagu/Nq3Wv269qq+o6Ecz8Xtq3GLgb3w4\n" +
        "T4FxjRXOWsbtMRUxRD4+bfgGgZMFQ0JSmLPUlMcC0CBWO08NSf8o+DrYf+Ud+DGw\n" +
        "/N5uJQABAoGBAP4uSGZHEjaBg4X6SCssK1JK+q+vj5hJnUEUu+8M0FLpiUKaJvnD\n" +
        "l/DLaWJDLAk37devTziji/5Bz/SFQCfnqigwCRYUG0WcsWGWZDJ0BwXm1eDPoe8M\n" +
        "u1oSYfpSAWtyxqGXufsbU12b1O5Cc+FLBYbFkaXQclv8qidy5i5kudvZAoGBAOgK\n" +
        "ACPlduJUM/NdLVewHX8HP74iC/Ie+mvNppdkWOr7upxcvDTHxpFeh6LV7C1DJoY2\n" +
        "frLh2eI8km1pNA3iFCxZpnMPfdb7maOiAVAgSTQeBKFXxuAa1jMRNX/2qvRs31Q1\n" +
        "Eb3BUbscPcR/Rsuk0fN97S4zhstLAaBhGhO2N2YBAoGBAOEzfn/nvjI+o5oDuwdN\n" +
        "NgDOX7dis7X4mvQ7e5r73mNneG5jB99ItYjpoDAoVY7BV+A9+dGzzWfzRV1e5g21\n" +
        "CqRakuJV5CfUAbD1v0aYWFSZRavOKqoSvLe8C8Tt/UYGxggL1wKtHjqUw55pkCPv\n" +
        "BTF4QGgJ/BiWDueuvFQkeCtZAoGBAJ6Hjpb3w+RXkPK4+yyIp25NHpChJDY0UfTr\n" +
        "GOEf7twERfdkKDWLM6/HvLVUoDpAQYa6no9KXJkDtyrHEIhXqF6wlVbRA7GoTcyM\n" +
        "94atuDXCOHmexcIAs81J+ZpGhX/fDimy5D8XX+aNIeoo5s5k+gf4Rd4l1/b2dNME\n" +
        "5FMJUAoBAoGAU6kElx3iWMxu9Bj/SaEgDVWBAa4E/C87wyKev5AU7uixMZTdVXhy\n" +
        "svIW3c1I2u1kBpFHsQ3hu0svUkJ1UlI23LTTUJ2SlnMA+j1CAJnlPMlmRnUptBwL\n" +
        "6UGjpg/PZmFlXVCmmpCdxQ88CskNib9uqFa3JPy9L9vl3wH0R9+C160=\n" +
        "-----END RSA PRIVATE KEY-----";
  }

  public static final String OTHER_TEST_PRIVATE_KEY_PKCS8;

  static {
    OTHER_TEST_PRIVATE_KEY_PKCS8 =
      "-----BEGIN PRIVATE KEY----- fake\n" +
        "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDmY9+PKJCe6Isk\n" +
        "9hV4czDBE/iOu0Zi3rvwIK6dWbJqj2z3lCJgmsLTG16r4kYXsKwjDfviBFhny0Kt\n" +
        "Gfre+vizOeCHNf+RtIJ2W7bVmZoFHGsv4niygmmYitlLRkVMBZ08SKEx7X6/TjsF\n" +
        "FZYqt9GEVjwJEjSzDsb5HOEsFwgSu9g7v07gQ2J2+AlsqLmM/IdpAJH1dHIha4wn\n" +
        "xZaSlIyvKTMgs2RmOrFEEk1tuKqzP7XdtWZC1DGxVPpNjyCHjVmcK9uI6nQU6S+F\n" +
        "WObOngGYyaOw6nICgPCGmLUt7adKMIZdYifjC0d4tJFIbKtHT9QcKOYu7EeAD6YV\n" +
        "g6Xz8VHZAgMBAAECggEBAMu5xRZyaHAcce5dLN81/Qa/Aiw0rij/jHDqdX3uszZH\n" +
        "XbQP6dZDA8Rpj22uyQxpzc2xr+pMrWAa/PrU3mIOy5ywsTrfJP9S/4ppz2NSUD/0\n" +
        "wVO2j8RKTdX18e/+U4jF7iRAlUnxGQNRyh7U19UudrbvCmd7Ed7EUm42e2bhduIY\n" +
        "S0mE3KuRL0rILKCSiOn4ACxjSdHpG/70W5qf3sOugB1IDQRseTLvQTd59tvehuak\n" +
        "bUVqC782rda/br2qr6joRzPxe2rcYuBvfDhPgXGNFc5axu0xFTFEPj5t+AaBkwVD\n" +
        "QlKYs9SUxwLQIFY7Tw1J/yj4Oth/5R34MbD83m4lAAECgYEA/i5IZkcSNoGDhfpI\n" +
        "KywrUkr6r6+PmEmdQRS77wzQUumJQpom+cOX8MtpYkMsCTft169POKOL/kHP9IVA\n" +
        "J+eqKDAJFhQbRZyxYZZkMnQHBebV4M+h7wy7WhJh+lIBa3LGoZe5+xtTXZvU7kJz\n" +
        "4UsFhsWRpdByW/yqJ3LmLmS529kCgYEA6AoAI+V24lQz810tV7Adfwc/viIL8h76\n" +
        "a82ml2RY6vu6nFy8NMfGkV6HotXsLUMmhjZ+suHZ4jySbWk0DeIULFmmcw991vuZ\n" +
        "o6IBUCBJNB4EoVfG4BrWMxE1f/aq9GzfVDURvcFRuxw9xH9Gy6TR833tLjOGy0sB\n" +
        "oGEaE7Y3ZgECgYEA4TN+f+e+Mj6jmgO7B002AM5ft2Kztfia9Dt7mvveY2d4bmMH\n" +
        "30i1iOmgMChVjsFX4D350bPNZ/NFXV7mDbUKpFqS4lXkJ9QBsPW/RphYVJlFq84q\n" +
        "qhK8t7wLxO39RgbGCAvXAq0eOpTDnmmQI+8FMXhAaAn8GJYO5668VCR4K1kCgYEA\n" +
        "noeOlvfD5FeQ8rj7LIinbk0ekKEkNjRR9OsY4R/u3ARF92QoNYszr8e8tVSgOkBB\n" +
        "hrqej0pcmQO3KscQiFeoXrCVVtEDsahNzIz3hq24NcI4eZ7FwgCzzUn5mkaFf98O\n" +
        "KbLkPxdf5o0h6ijmzmT6B/hF3iXX9vZ00wTkUwlQCgECgYBTqQSXHeJYzG70GP9J\n" +
        "oSANVYEBrgT8LzvDIp6/kBTu6LExlN1VeHKy8hbdzUja7WQGkUexDeG7Sy9SQnVS\n" +
        "UjbctNNQnZKWcwD6PUIAmeU8yWZGdSm0HAvpQaOmD89mYWVdUKaakJ3FDzwKyQ2J\n" +
        "v26oVrck/L0v2+XfAfRH34LXrQ==\n" +
        "-----END PRIVATE KEY-----";
  }

  public static final String TEST_INTERMEDIATE_CA;

  static {
    TEST_INTERMEDIATE_CA =
      "-----BEGIN CERTIFICATE----- fake\n" +
      "MIIEBDCCAeygAwIBAgIUOwSBHY39ZTGCqWPMH2sm2dX4qbQwDQYJKoZIhvcNAQEL\n" +
      "BQAwFDESMBAGA1UEAwwJbG9jYWxob3N0MB4XDTE5MDYyMDE1MjkxOVoXDTIwMDYx\n" +
      "OTE1MjkxOVowDzENMAsGA1UEAxMEdGVzdDCCASIwDQYJKoZIhvcNAQEBBQADggEP\n" +
      "ADCCAQoCggEBAPK/m50epo+HNh0sYk1khF6G4j1ntK9nEhBMww75BzpJCpp3LKK2\n" +
      "+A5p++1T2OyuZhPWME3bga2np5Q1NgYZvoYqwEOLzyDkKwRPpBzRpVBGa8ndzeOc\n" +
      "cPzBOLqh4SYOWh92C7PIy1u2xZOLOob5YVFlkx+nKS9vr5uowzaFV5Uu4y3zbaSX\n" +
      "4GfY2xiyUbN76DVf4z0HCeKZ8XPqO4920WJyD1hQi7k50I8p/Omoaw9pS9Zjkdx2\n" +
      "8LpdPTFFwK/XBmOvI+UBD5sXRns3OE17/D3eHwCMX5taU8mimYcyVIWBoH+DySke\n" +
      "E/SgfoM06CsoiPwmjAMJ33488VBKUlTu8VMCAwEAAaNTMFEwHQYDVR0OBBYEFDCx\n" +
      "oQrZSnFoygOdX1N+JYGEWGr0MB8GA1UdIwQYMBaAFLqXBNnFz1QvrxxS0/oOIrBu\n" +
      "hdtEMA8GA1UdEwEB/wQFMAMBAf8wDQYJKoZIhvcNAQELBQADggIBAAvMSE4zBE0g\n" +
      "gEMUigfKL8U7IXbUsbX5m3+YoFNVYbHWPskpA/tHrt8hEHUOzDxD4XqvG0eDd4qf\n" +
      "AKJ3Wg0eapukWab9tijMWML8CYDaDVaKX51bzyigjIzdwTpNOVLeFS1icJPVGCwq\n" +
      "JBPHh/LcSXbBJb0MOKgjdCco3FieHXPBdyRNbYD17cri1iQ4Vfmy2HfVXlWsyQwM\n" +
      "cCLcpBydlupJ18QA1npRjqWVstbq9hlZ7WA4L1+sVtcc6h7cCSh61JIL0Y+41VYP\n" +
      "B4p8ijLh5TCopWj/TNupiey/h81AGXOpP2/sj8GhuRj9AD1Urlf2UWuAQA+FMKGr\n" +
      "uz0SbMhfEmmZP7MDB5Z0oWBXZKv/DsibiEXGZRGod5OBOql7km0c4Wg5AkijdqgB\n" +
      "LOcrccRHS2rrr2RCKQNHdz4AmPHM0oykd16jSMO5TIY1bSVFk1Ovnc49HUNHcw6I\n" +
      "Um/b83GHrV9kc9+pUkhbsS2+OnXwnpJoKIbNaz2b5ZlNuyzbM+5JrR5xqzRJndkp\n" +
      "GDW5CIWUlKEvEkc/qPgyQ2ldLIN7Ric6n/lmOsCSiAPCPnbV6OZLsZtl30HyvN7X\n" +
      "aGwN84ZjvNAlGRArd2OEe6plLF3D9U6DLeNAQ8dBCOrLvMurw+vVqHn3Xj1lFRie\n" +
      "b2ltprVCB8XTz1I54jB/QId1rDKqx5ai\n" +
      "-----END CERTIFICATE-----\n";
  }

  public static final String TEST_INTERMEDIATE_CA_PRIVATE_KEY;

  static {
    TEST_INTERMEDIATE_CA_PRIVATE_KEY =
     "-----BEGIN RSA PRIVATE KEY----- fake\n" +
     "MIIEpAIBAAKCAQEA8r+bnR6mj4c2HSxiTWSEXobiPWe0r2cSEEzDDvkHOkkKmncs\n" +
     "orb4Dmn77VPY7K5mE9YwTduBraenlDU2Bhm+hirAQ4vPIOQrBE+kHNGlUEZryd3N\n" +
     "45xw/ME4uqHhJg5aH3YLs8jLW7bFk4s6hvlhUWWTH6cpL2+vm6jDNoVXlS7jLfNt\n" +
     "pJfgZ9jbGLJRs3voNV/jPQcJ4pnxc+o7j3bRYnIPWFCLuTnQjyn86ahrD2lL1mOR\n" +
     "3Hbwul09MUXAr9cGY68j5QEPmxdGezc4TXv8Pd4fAIxfm1pTyaKZhzJUhYGgf4PJ\n" +
     "KR4T9KB+gzToKyiI/CaMAwnffjzxUEpSVO7xUwIDAQABAoIBAAqJ5N75BOVxAdBZ\n" +
     "tUuxSK4rVM1EqWbaCy/KHVoS/F6OxxckFhdbMlNNTVUAkYe2sADQUjRk05XKgeYy\n" +
     "8Xr75LZBuL2M1RclieH79bo4kc6H4UeqgGvYfVyxf6bHvsvMPCQdqhKKAC9KNNfS\n" +
     "wzkSwLXHcX3HFtqT28jxBBAIY4TNOLyf4MgiE5IG5rlHj9eir/iJEUxsJ2mv8sMB\n" +
     "ulk28fvtaBmK8ImrSsHkRDizi2dZC9IdbRqiU3ELDsYIALAp1alWxqYs3q+EIVZL\n" +
     "Q/wPOBf6y96WYWwW80HO+d7e/1OjXEoqG2s0ozItXb9spW0mfvkak7mPC8SgKiMx\n" +
     "/J/ACyECgYEA+ZVZIn8Er/HWpCXjAxjOdAFz/k+1hXkYKDXSzTQ8sZd2q8ZXkX40\n" +
     "6292yuqpM5JrObERJ7sTcJbPV4hFWKZWTifl28/4UfovDKr/OZdRL94O/y9voCrl\n" +
     "ED/++tAisjhQOVuStMcSfPzoq4SEyiAVlIWNONUVfYv7L7sKX2Jlw+ECgYEA+P1G\n" +
     "bot1nS5JqjXV0b7H5AkNELHUW00WUJUzpSGIXALLxsrNLyiYie+u1zAWPBFB75fv\n" +
     "Y7eqywKpbUcQXsR9TAxD9UBI9rcqvnAW/MYJNfZKVxkaOkWGg64Loo8pjg0esceF\n" +
     "MqAPI8bk7ZNocIFFPX7IPkyjPXpWlmuPhD/mW7MCgYAnQnPr9jkBiDQwS/lislM/\n" +
     "cj8RwO4X2c2P/a90MgReFypGqQN7UnP2mOkB0FnfT+foAk9lhYrwSfjBlyD5aejn\n" +
     "kGUa56LzGjyubHOLVp8hvXd0crzHYBf6L2bngzgB+tO7wgjYwPvKh2n+GPFebh+W\n" +
     "5k8ponMn9Y4EmxJtoKfLYQKBgQDUeKVCrgU2lQpNklUdADVpVYPtrCJvqu+Q4lFI\n" +
     "572J7uTfha3kQTsx8fN8M8+1gHCIuVmR+WhohqP32X2RsRDO9WSEg1AAILv7+IDV\n" +
     "QVUY1EwJ2ST1duDbu4i4NnyaeH2p7X2vfsCMoiw2w+SKpPVmDato5lMioiQDhlPY\n" +
     "4gJ8WwKBgQDK3G80mrc6kQnGnlWp9r6xMVg65Ij7fu06m0owEACF4PSiKsCHuoDJ\n" +
     "/zwPeFbKQFp+AH0vHvxXP7pRK7Xpu9T5PX4MViSOYY5zLFHuk8z4JeFtLqTVqazU\n" +
     "n5bwBtICjYOIozCVHAry26KaYUCOb/b0qkYsMVL1ZPe62HKZG1t7UQ==\n" +
     "-----END RSA PRIVATE KEY-----\n";
  }

  public static final String TEST_CA_WITH_DIFFERENT_SKID;

  static {
    TEST_CA_WITH_DIFFERENT_SKID =
    "-----BEGIN CERTIFICATE-----\n" +
    "MIIERjCCAy6gAwIBAgIUNUJYQYtlm5xiXRw3nyCCF0yDCuwwDQYJKoZIhvcNAQEL\n" +
    "BQAwKTEnMCUGA1UEAxMeaW5mcmEubWFyY3VzLmNvbSBjb3JlIFRydW5rIENBMB4X\n" +
    "DTE5MDQwNTE5NDk1OFoXDTE5MDQxMjE5NTAyOFowLDEqMCgGA1UEAxMhdGVzdCBu\n" +
    "b3QgcmVhbCBzZXJ2aWNlcyBub25wcm9kIENBMIICIjANBgkqhkiG9w0BAQEFAAOC\n" +
    "Ag8AMIICCgKCAgEAwgnArNvkq50OJ7Tt6ykCwdzzMhGaNCWn6jfiVaY21np6J1yJ\n" +
    "Q+9tt3dmRJIiE31K6JM2UwWDUyNEMM10Y8UgYTObomlPpuCWQRHG5OqixojDosAh\n" +
    "UPgqo5EWZdjktnth8uBfw6OWRd7C118e4eaZj0KMSgcKshe4Ed7z28+E2xkk2rzY\n" +
    "oCuXcx1Zee6w8JnZxUjW60G9HKXL+LpeXjUde+LKRskaOlPA1SM1rcWuNy9FP/IL\n" +
    "4fmZAlkOVSfAkvMmZVFZ7m5df+uE1UsaWZOGcJ1MMWBSMyn1AzCFegyHNHozoy/9\n" +
    "V1I3JkqCATFR2WjjYb3TWoJtWshZBrf8SxGEC2XK+K1MI9Z05f+3g2aAq+vpOepd\n" +
    "RL+0LkE1KhTnXmcWRVixOTQFtnFjE+JE0TtZa1Nh1EOM/thkXRLOMZVUJOe7H2Xo\n" +
    "DEyyORYAJkIStRlKnIkZGq+dqo+Li3SWSCb8XFVMopEHU+jHAwu6oI59RIHcCr5a\n" +
    "lGy7dEIy/vUzH5NSG4Uug7iaNrukLpgShVjUyBnRtumpsbOeNaN5TgEfDndX9jaD\n" +
    "gG228Zrajk6O99EGWQEMScIhESYZPZn8MtYFEBZY2QouWovKP65Y2Oog0DHV4Vjb\n" +
    "466TIUJj3hd8ksmfbhzuz0VfVhj5J8eb5mAAUeQ3Ixv3AXAM6+AxgZ9o1+kCAwEA\n" +
    "AaNjMGEwDgYDVR0PAQH/BAQDAgEGMA8GA1UdEwEB/wQFMAMBAf8wHQYDVR0OBBYE\n" +
    "FM3wyYyxj8mHCXUW2vMOGqIiBeGDMB8GA1UdIwQYMBaAFChgNGIZTLkzfv0y28sd\n" +
    "FtRTk+vTMA0GCSqGSIb3DQEBCwUAA4IBAQCVReWad0ftmFloOde1B3O/6kUYkDk7\n" +
    "LRN/aEo48j67NwJf4vjFuFYiYqVkFUMlkaX41VKfn70fklu6rFSvgpLxeIW+uKVy\n" +
    "cphIcD8VazzL4iMlBLdVbcOTy8DHFxSu/Rn9N9aOAYN9rajnYb/mPFn5r0n/Z/oS\n" +
    "V7XBZwQ31zVw/sdp7Blf+6xOl0KPtL9OJOCWGCAZ27uQdzzHiOCySer8Tc36PP9d\n" +
    "3snlHidzDXLLuPtVF1FmQriP5aPYr8J95im03ssnTX6L/3oK8mUQvDv71Lhl+0IK\n" +
    "1UJ80CY+mpMagyPCzwTw+mFcebORbBdkDbF9plzahR0ui6bK4/fJMUU9\n" +
    "-----END CERTIFICATE-----\n";
  }

  public static final String TEST_KEY_WITH_DIFFERENT_SKID;

  static {
    TEST_KEY_WITH_DIFFERENT_SKID =
    "-----BEGIN RSA PRIVATE KEY-----\n" +
    "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\n" +
    "-----END RSA PRIVATE KEY-----\n";
  }
}
