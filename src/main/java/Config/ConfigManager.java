package Config;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

     private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis =
            new FileInputStream("src/main/resources/config-dev.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file");
        }
    }
     public static String get(String key) 
     {
        return properties.getProperty(key);
     }

    public static String getBaseUrl() 
    {
         String env = get("env");
        return properties.getProperty(env + ".base.url");
        
    }
    
}
