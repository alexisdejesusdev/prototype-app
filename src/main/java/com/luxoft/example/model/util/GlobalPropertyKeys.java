package com.luxoft.example.model.util;

/**
 * Utility that defines the usable property keys for messages and errors according to the
 * properties file /config.properties contained within the classpath.
 * 
 * @author alexisallmighty
 *
 */
public class GlobalPropertyKeys {
	// Dao layer
	public static final String ERROR_MSG_USER_ALREADY_EXISTS = "error.msg.user.already.exists";
	public static final String ERROR_MSG_USER_NOT_FOUND = "error.msg.user.not.found";

	// Service layer
	public static final String ERROR_MSG_USER_DOESNT_MATCH_BRAND = "error.msg.user.doesnt.match.brand";
	public static final String ERROR_MSG_PASSWORD_DONT_MATCH = "error.msg.password.dont.match";

	// Validator layer
	public static final String ERROR_MSG_VALIDATOR_USERNAME_REQUIRED = "error.msg.validator.username.required";
	public static final String ERROR_MSG_VALIDATOR_PASSWORD_REQUIRED = "error.msg.validator.password.required";

	public static final String ERROR_MSG_VALIDATOR_MUST_ACCEPT_TERMS = "error.msg.validator.must.accept.terms";

	public static final String ERROR_MSG_VALIDATOR_UNSUPPORTED = "error.msg.validator.unsupported";
}
