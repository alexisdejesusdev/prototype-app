package com.luxoft.example.service.validator.factory;

import com.luxoft.example.model.exception.ControlledException;
import com.luxoft.example.model.util.GlobalPropertyKeys;
import com.luxoft.example.service.util.PropertiesServiceUtil;
import com.luxoft.example.service.validator.UserValidator;
import com.luxoft.example.service.validator.impl.AlphaBrandUserValidatorImpl;
import com.luxoft.example.service.validator.impl.BetaBrandUserValidatorImpl;

/**
 * Utility class to hide the actual way to get the correct instance of a
 * UserValidator based on any supported mechanism.
 * 
 * @author alexisallmighty
 *
 */
public class UserValidatorFactory {

	/**
	 * Gets the appropriate validator based on the requested brand.
	 * 
	 * @param brand
	 * @return
	 * @throws ControlledException
	 */
	public static UserValidator getValidator(String brand) throws ControlledException {
		UserValidator userValidator;

		switch (brand) {
			case "Alpha":
				userValidator = AlphaBrandUserValidatorImpl.getInstance();

				break;
			case "Beta":
				userValidator = BetaBrandUserValidatorImpl.getInstance();

				break;

			default:
				throw new ControlledException(
						PropertiesServiceUtil.getProperty(GlobalPropertyKeys.ERROR_MSG_VALIDATOR_UNSUPPORTED));
		}

		return userValidator;
	}
}
