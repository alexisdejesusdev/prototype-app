package com.luxoft.example.service.util;

/**
 * Utility to switch globally the current language based on the front-end
 * layer's request
 * 
 * @author alexisallmighty
 *
 */
public class LanguageManagerUtil {
	// Define the currently supported languages
	public static final String ENGLISH = "en";
	public static final String SPANISH = "es";

	public static final String DEFAULT = ENGLISH;

	// Define and hide the global current language used
	private static String currentLocale;

	/**
	 * Returns the globally assigned current language.
	 * 
	 * @return
	 */
	public static String getCurrentLanguage() {
		if (currentLocale == null) {
			setDefaultLanguage();
		}

		return currentLocale;
	}

	/**
	 * Sets the default language globally.
	 * 
	 */
	public static void setDefaultLanguage() {
		currentLocale = DEFAULT;
	}

	/**
	 * Sets the current global language to the specified supported value, if the
	 * language parameter is not supported the current global language will be
	 * left as is.
	 * 
	 * Supported values: 
	 * LanguageManagerUtil.ENGLISH
	 * LanguageManagerUtil.SPANISH
	 * 
	 * LanguageManagerUtil.DEFAULT
	 * 
	 * @param language
	 */
	public static void setSpecificLanguage(String language) {
		// Temporarily just validate that the locale is supported, otherwise
		// don't assign it
		switch (language) {
			case ENGLISH:
			case SPANISH:
				currentLocale = language;
				break;

			default:
				break;
		}
	}
}
