package com.luxoft.example.dao;

import com.luxoft.example.model.User;
import com.luxoft.example.model.exception.ControlledException;

/**
 * Interface to expose the Data Access Object layer operations for the User
 * model.
 * 
 * 
 * @author Alexis De Jesús
 *
 */
public interface UserDao {
	/**
	 * Adds a user to the appropriate repository.
	 * 
	 * @param user
	 * @return
	 * @throws ControlledException
	 */
	public abstract User add(User user) throws ControlledException;

	/**
	 * Gets a user from the appropriate repository.
	 * 
	 * @param user
	 * @return
	 */
	public abstract User get(User user) throws ControlledException;
}
