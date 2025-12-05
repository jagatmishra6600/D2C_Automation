package com.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Common ConfigReader used by both Electrolux and Frigidaire packages.
 * Load precedence:
 *  1) System property -Dconfig.file=path (explicit override)
 *  2) Classpath resource config.properties
 *  3) Project file src/main/resources/config.properties
 * Does not throw in static init and is safe for parallel use.
 */
public class ConfigReader {
    private static final Properties properties = new Properties();
    private static volatile boolean loaded = false;

    static {
        loadPropertiesSafely();
    }

    private static synchronized void loadPropertiesSafely() {
        if (loaded) return;

        // 1) Prefer system-provided config file
        try {
            String alt = System.getProperty("config.file");
            if (alt != null && !alt.isBlank()) {
                File f2 = new File(alt);
                if (f2.exists() && f2.isFile()) {
                    try (FileInputStream fis = new FileInputStream(f2)) {
                        properties.load(fis);
                        loaded = true;
                        return;
                    }
                }
            }
        } catch (Exception ignored) {
            // ignore and continue to other fallbacks
        }

        // 2) Try to load from classpath (test runtime will typically use src/test/resources)
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                properties.load(input);
                loaded = true;
                return;
            }
        } catch (Exception ignored) {
        }

        // 3) Try project resources path (useful in IDE/run-from-source)
        try {
            String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config.properties";
            File f = new File(filePath);
            if (f.exists() && f.isFile()) {
                try (FileInputStream fis = new FileInputStream(f)) {
                    properties.load(fis);
                    loaded = true;
                    return;
                }
            }
        } catch (Exception ignored) {
        }

        // If we reach here, properties remain empty. Don't throw — return with defaults.
        System.err.println("[WARN] config.properties not found; continuing with empty properties. Provide config via classpath or -Dconfig.file=path/to/config.properties");
        loaded = true;
    }

    public static String getProperty(String key) {
        if (!loaded) loadPropertiesSafely();
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if (!loaded) loadPropertiesSafely();
        return properties.getProperty(key, defaultValue);
    }

    /**
     * Allows tests/suites to override a property at runtime (e.g., brand from TestNG).
     */
    public static void setRuntimeProperty(String key, String value) {
        if (!loaded) loadPropertiesSafely();
        if (key != null && value != null) {
            properties.setProperty(key, value);
        }
    }

    /**
     * Returns the selected brand. Precedence: system property (-Dbrand), runtime override,
     * then config file, defaulting to "frigidaire".
     */
    public static String getBrand() {
        String sys = System.getProperty("brand");
        if (sys != null && !sys.isBlank()) return sys.trim().toLowerCase();
        String prop = getProperty("brand", "frigidaire");
        return prop.trim().toLowerCase();
    }

    /**
     * Returns the base application URL based on selected brand.
     * Supported brands: frigidaire, electrolux|elux
     */
    public static String getAppUrl() {
        String brand = getBrand();
        System.out.println(brand);
        if (brand.equals("frigidaire")) {
            return getProperty("app.frigidaire");
        }
        if (brand.equals("electrolux") || brand.equals("elux")) {
            return getProperty("app.elux");
        }
        if (brand.equals("fsus") || brand.equals("family_Store_US")) {
            return getProperty("app.fsus");
        }

        // Fallback to Frigidaire if unknown brand
        return getProperty("app.frigidaire");
    }
}
