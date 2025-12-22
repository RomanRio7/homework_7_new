package config;

public final class TestConfig {
    private TestConfig() {}

    public static final String BASE_URL =
            System.getProperty("baseUrl", "https://cinescope.t-qa.ru");

    public static final String USER_EMAIL =
            System.getProperty("userEmail", "roman_sarsengaliev@mail.ru");

    public static final String USER_PASSWORD =
            System.getProperty("userPassword", "CHANGE_ME");

    public static final long TIMEOUT_MS =
            Long.parseLong(System.getProperty("timeoutMs", "10000"));

    public static final String BROWSER =
            System.getProperty("browser", "chrome");

    public static final String BROWSER_SIZE =
            System.getProperty("browserSize", "1920x1080");
}