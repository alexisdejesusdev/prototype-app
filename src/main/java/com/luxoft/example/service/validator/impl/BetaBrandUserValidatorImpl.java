package com.luxoft.example.service.validator.impl;

import org.springframework.util.StringUtils;

import com.luxoft.example.model.User;
import com.luxoft.example.model.exception.ControlledException;
import com.luxoft.example.model.util.GlobalPropertyKeys;
import com.luxoft.example.service.util.PropertiesServiceUtil;
import com.luxoft.example.service.validator.UserValidator;

/**
 * Implements a UserValidator with specific business rules defined for the Beta
 * Brand
 * 
 * @author alexisallmighty
 *
 */
public class BetaBrandUserValidatorImpl implements UserValidator {
	// Define the unique instance that's going to be used for this class
	private static BetaBrandUserValidatorImpl instance;

	// Hide the constructor so it can only be used as a singleton class
	private BetaBrandUserValidatorImpl() {

	}

	/**
	 * Gets a singleton instance of this class to avoid re-instantiation
	 * 
	 * @return
	 */
	public static BetaBrandUserValidatorImpl getInstance() {
		if (instance == null) {
			instance = new BetaBrandUserValidatorImpl();
		}

		return instance;
	}

	@Override
	public void validate(User user) throws ControlledException {
		if (StringUtils.isEmpty(user.getUsername())) {
			throw new ControlledException(
					PropertiesServiceUtil.getProperty(GlobalPropertyKeys.ERROR_MSG_VALIDATOR_USERNAME_REQUIRED));
		}

		if (StringUtils.isEmpty(user.getPassword())) {
			throw new ControlledException(
					PropertiesServiceUtil.getProperty(GlobalPropertyKeys.ERROR_MSG_VALIDATOR_PASSWORD_REQUIRED));
		}

		if (!Boolean.TRUE.equals(user.getTermsAccepted())) {
			throw new ControlledException(
					PropertiesServiceUtil.getProperty(GlobalPropertyKeys.ERROR_MSG_VALIDATOR_MUST_ACCEPT_TERMS));
		}
	}
}
