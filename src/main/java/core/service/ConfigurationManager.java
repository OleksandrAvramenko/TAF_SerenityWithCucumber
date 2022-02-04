package core.service;

import enums.Props;
import exceptions.ReadingPropertiesException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class ConfigurationManager {
    private static final Logger LOGGER = LogManager.getLogger();
    private static Properties properties = new Properties();

    private static final String ENV_PROPERTY = "env";
    private static final String RESOURCES_PATH = System.getProperty("user.dir") + File.separator + "src" +
            File.separator + "main" + File.separator + "resources";
    private static final String PROPERTY_FILE_PATH_MASK = RESOURCES_PATH + File.separator +
            "environments" + File.separator + "%s.properties";

    private ConfigurationManager() {
    }

    public static String getProperty(final Props propertyName) {
        return properties.getProperty(propertyName.getValue());
    }

    public static void loadProperties() {
        String environment = System.getProperty(ENV_PROPERTY);
        try {
            File file = new File(String.format(PROPERTY_FILE_PATH_MASK, environment));
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            throw new ReadingPropertiesException("Configuration properties file cannot be found." +
                    " Unable to read properties");
        }
        logConfiguration();
    }

    private static void logConfiguration() {
        Arrays.stream(Props.values()).forEach(key -> LOGGER.debug("Read property " +
                key.name() + ":'" + key.getValue() + "' -> '" + getProperty(key) + "'"));
    }
}