package com.luxoft.example.service.validator;

import com.luxoft.example.model.User;
import com.luxoft.example.model.exception.ControlledException;

/**
 * General operations for User model validations.
 * 
 * @author alexisallmighty
 *
 */
public interface UserValidator {
	/**
	 * Defines a generic operation for user validation.
	 * 
	 * @param user
	 * @throws ControlledException
	 */
	public abstract void validate(User user) throws ControlledException;
}
