package com.rpg.utils;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.rpg.constants.CommonConstants;

/**
 * Loads the resources from classpath resource.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public class PropertyUtils {

    private static ResourceBundle INSTANCE = ResourceBundle.getBundle(CommonConstants.RESOURCE_BASE_PACKAGE);

    private PropertyUtils() {
        //hides constructor.
    }

    /**
     * get the value from classpath resource.
     * @param key
     * @return
     */
    public static String getPropertyValue(final String key) {
        return getValue(key, Locale.getDefault());
    }

    /**
     * get the string value from the bundle.
     *
     * @param name   the key
     * @param locale the locale
     * @return the string value
     * @since 1.0-SNAPSHOT.
     */
    private static String getValue(String name, Locale locale) {
        if (INSTANCE != null) {
            try {
                return INSTANCE.getString(name);
            } catch (MissingResourceException mre) {
                mre.printStackTrace();
            }
        }
        return name;
    }

}
