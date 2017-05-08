package com.luxoft.example.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.luxoft.example.dao.UserDao;
import com.luxoft.example.model.User;
import com.luxoft.example.model.exception.ControlledException;
import com.luxoft.example.model.util.GlobalPropertyKeys;
import com.luxoft.example.service.util.PropertiesServiceUtil;

/**
 * Implements the Data Access Object layer operations for the User model using a
 * static in-memory repository.
 * 
 * 
 * @author Alexis De Jesús
 *
 */
@Repository
public class UserDaoInMemoryImpl implements UserDao {
	// Store the users in memory temporarily
	private static Map<String, User> users;

	static {
		// Initialize the user container
		users = new HashMap<String, User>();
	}

	@Override
	public User add(User user) throws ControlledException {
		String username = user.getUsername();

		// Test if the collection contains the desired user
		boolean contains = users.containsKey(username);

		if (!contains) {
			// Add user to the container making a copy that can't be modified
			// since it's stored in memory temporarily
			users.put(username, new User(user));

		} else {
			// Send a message to the service if the user is already contained
			throw new ControlledException(
					PropertiesServiceUtil.getProperty(GlobalPropertyKeys.ERROR_MSG_USER_ALREADY_EXISTS));
		}

		return user;
	}

	@Override
	public User get(User user) throws ControlledException {
		// Get the user from the container
		User stored = users.get(user.getUsername());

		// Test if there was no match for the user query and send the
		// appropriate message
		if (stored == null) {
			throw new ControlledException(
					PropertiesServiceUtil.getProperty(GlobalPropertyKeys.ERROR_MSG_USER_NOT_FOUND));
		}

		// Return a copy of the stored user so it can't be modified since it's
		// stored in memory temporarily
		return new User(stored);
	}

}
