package com.luxoft.example.model.util;

/**
 * Utility that abstracts the return message model to return to the front-end
 * layer in a standardized way.
 * 
 * @author Alexis De Jesús
 *
 */
public class Message {
	private String message;

	/**
	 * Constructs a message model with a textual field
	 * 
	 * @param message
	 */
	public Message(String message) {
		this.message = message;
	}

	// Setters and Getterss
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
