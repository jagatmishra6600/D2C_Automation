package com.automation.frigidaire.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            String filePath = System.getProperty("user.dir") + "/src/main/resources/config.properties";
            FileInputStream input = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}