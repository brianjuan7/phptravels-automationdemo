package org.brianjuan.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class Properties {

    private static final Logger logger = LoggerFactory.getLogger(Properties.class);

    private Properties() {}

    public static String getValueFromConfiguration(String key) {
        return getValue("properties/configuration.properties", key);
    }

    public static String getValueFromMessaging(String key) {
        return getValue("properties/messaging.properties", key);
    }

    public static String getValue(String filePath, String key) {
        InputStream input;
        java.util.Properties properties = new java.util.Properties();

        try {
            input = Properties.class.getClassLoader().getResourceAsStream(filePath);

            properties.load(input);
        } catch (NullPointerException e) {
            logger.error(String.format("Cannot find %s",filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(key);
    }
}
