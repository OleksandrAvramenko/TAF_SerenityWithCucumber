package core.service;

import enums.Props;
import exceptions.ReadingPropertiesException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private static Properties properties = new Properties();

    private static final String ENV_PROPERTY = "env";
    private static final String RESOURCES_PATH = System.getProperty("user.dir") + File.separator + "src" +
            File.separator + "main" + File.separator + "resources";
    private static final String PROPERTY_FILE_PATH_MASK = RESOURCES_PATH + File.separator +
            "environments" + File.separator + "%s.properties";

    public static String getProperty(final Props propertyName) {
        if (instance == null) {
            instance = new ConfigurationManager();
            instance.loadProperties();
        }
        return properties.getProperty(propertyName.getValue());
    }

    private void loadProperties() {
        String environment = System.getProperty(ENV_PROPERTY);
        try {
            File file = new File(String.format(PROPERTY_FILE_PATH_MASK, environment));
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            throw new ReadingPropertiesException("Configuration properties file cannot be found." +
                    " Unable to read properties");
        }
    }
}
