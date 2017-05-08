package com.luxoft.example.service.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.luxoft.example.model.util.GlobalPropertyKeys;

/**
 * Utility to perform the loading of the properties general file and retrieval
 * of such property values.
 * 
 * @author alexisallmighty
 *
 */
public class PropertiesServiceUtil {
	// Define the name of the global properties file
	private static final String filename = "config";

	// Keep a static map for performance improvement
	private static final Map<String, ResourceBundle> properties = new HashMap<String, ResourceBundle>();

	static {
		// Get the language bundles supported and keep them in memory from the
		// beginning since they're used all across the project
		properties.put(LanguageManagerUtil.ENGLISH, getBundle(LanguageManagerUtil.ENGLISH));
		properties.put(LanguageManagerUtil.SPANISH, getBundle(LanguageManagerUtil.SPANISH));
	}

	/**
	 * Retrieves the appropriate ResourceBundle from the classpath based on the
	 * language parameter.
	 * 
	 * @param language
	 * @return
	 */
	private static ResourceBundle getBundle(String language) {
		ResourceBundle bundle;

		Locale locale = new Locale(language);
		bundle = ResourceBundle.getBundle(filename, locale);

		return bundle;
	}

	/**
	 * Retrieves the appropriate ResourceBundle from the in-memory map based on
	 * the language parameter.
	 * 
	 * @param language
	 * @return
	 */
	public static ResourceBundle getProperties(String language) {

		return properties.get(language);
	}

	/**
	 * Gets the actual value of a property based on a particular key.
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {

		return getProperties(LanguageManagerUtil.getCurrentLanguage()).getString(key);
	}

	// TODO: BORRAR!!
	public static void main(String[] args) {
		LanguageManagerUtil.setSpecificLanguage(LanguageManagerUtil.SPANISH);

		System.out.println(getProperty(GlobalPropertyKeys.ERROR_MSG_USER_DOESNT_MATCH_BRAND));
		System.out.println(getProperty(GlobalPropertyKeys.ERROR_MSG_PASSWORD_DONT_MATCH));
		System.out.println(getProperty(GlobalPropertyKeys.ERROR_MSG_USER_ALREADY_EXISTS));
		System.out.println(getProperty(GlobalPropertyKeys.ERROR_MSG_USER_NOT_FOUND));
		System.out.println(getProperty(GlobalPropertyKeys.ERROR_MSG_VALIDATOR_MUST_ACCEPT_TERMS));
		System.out.println(getProperty(GlobalPropertyKeys.ERROR_MSG_VALIDATOR_PASSWORD_REQUIRED));
		System.out.println(getProperty(GlobalPropertyKeys.ERROR_MSG_VALIDATOR_USERNAME_REQUIRED));
	}
}
