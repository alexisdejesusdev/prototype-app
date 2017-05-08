package com.luxoft.example.model.exception;

/**
 * General Exception for any kind of business or technical error based on the
 * scope of the project.
 * 
 * @author Alexis De Jesús
 *
 */
public class ControlledException extends Exception {
	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = -91780172907801722L;

	/**
	 * Creates a ControlledException based on only a textual message.
	 * 
	 * @param message
	 */
	public ControlledException(String message) {
		super(message);
	}

	/**
	 * Creates a Controlled Exception based on both a textual message and the
	 * complete Exception and/or Error chain.
	 * 
	 * @param message
	 * @param e
	 */
	public ControlledException(String message, Throwable e) {
		super(message, e);
	}

}
