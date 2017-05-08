package com.luxoft.example.service;

import com.luxoft.example.model.User;
import com.luxoft.example.model.exception.ControlledException;

/**
 * Defines a set of operations that can be performed based on the User model and
 * the project's requirements.
 * 
 * @author Alexis De Jesús
 *
 */
public interface UserService {

	/**
	 * Registers a user based on it's data model and particular brand and
	 * selected language.
	 * 
	 * @param user
	 * @param brand
	 * @param language
	 * @return
	 */
	public abstract User signUp(User user, String brand, String language) throws ControlledException;

	/**
	 * Validates a user's credentials based on it's data model and particular
	 * brand and selected language.
	 * 
	 * @param user
	 * @param brand
	 * @param language
	 * @return
	 */
	public abstract User signIn(User user, String brand, String language) throws ControlledException;

}
