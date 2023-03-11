package configuration;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String getApiUrl() {
        return properties.getProperty("apiUrl");
    }


    public static String browserName() {
        return properties.getProperty("browser");
    }

//    public static String username() {return properties.getProperty("username");}
//    public static String password() {return properties.getProperty("password");}

    public static String username() {
        return System.getProperty("usernameCICD");
    }

    public static String password() {
        return System.getProperty("passwordCICD");
    }

    public static String database() {
        return properties.getProperty("database");
    }

    public static String token() {
        return properties.getProperty("token") + properties.getProperty("token2");
    }


    public static String owner() {
        return properties.getProperty("owner");
    }


    public static boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }

    public static int timeout() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }
}
