package com.luxoft.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxoft.example.dao.UserDao;
import com.luxoft.example.model.User;
import com.luxoft.example.model.exception.ControlledException;
import com.luxoft.example.model.util.GlobalPropertyKeys;
import com.luxoft.example.service.UserService;
import com.luxoft.example.service.util.LanguageManagerUtil;
import com.luxoft.example.service.util.PropertiesServiceUtil;
import com.luxoft.example.service.validator.factory.UserValidatorFactory;

/**
 * Default implementation of the supported User operations that uses an
 * in-memory repository to store the data.
 * 
 * @author Alexis De Jesús
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User signUp(User user, String brand, String language) throws ControlledException {
		// Switch the locale based on the "language" parameter
		LanguageManagerUtil.setSpecificLanguage(language);

		// Validate the user data according to brand
		UserValidatorFactory.getValidator(brand).validate(user);

		// Set the corresponding brand into the user model since it's not
		// established already
		user.setBrand(brand);

		// Insert the user into the repository
		User stored = userDao.add(user);

		// Clear the password field temporarily just so it doesn't go to
		// the upper layers for security
		stored.setPassword(null);

		return stored;
	}

	@Override
	public User signIn(User user, String brand, String language) throws ControlledException {
		// Switch the locale based on the "language" parameter
		LanguageManagerUtil.setSpecificLanguage(language);

		// Get the user from the repository
		User stored = userDao.get(user);

		// Test if the user doesn't correspond to the specified brand, then send
		// the appropriate message
		if (!stored.getBrand().equals(brand)) {
			throw new ControlledException(
					PropertiesServiceUtil.getProperty(GlobalPropertyKeys.ERROR_MSG_USER_DOESNT_MATCH_BRAND));
		}

		// Test if the passwords don't match, then send the appropriate message
		if (!stored.getPassword().equals(user.getPassword())) {
			throw new ControlledException(
					PropertiesServiceUtil.getProperty(GlobalPropertyKeys.ERROR_MSG_PASSWORD_DONT_MATCH));
		}

		// Clear the password field temporarily just so it doesn't go to
		// the upper layers for security
		stored.setPassword(null);

		return stored;
	}

}
