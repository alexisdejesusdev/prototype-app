package com.luxoft.example.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.luxoft.example.model.exception.ControlledException;
import com.luxoft.example.model.util.Message;

/**
 * Utility controller to manage globally thrown exceptions in a centralized way.
 * 
 * @author alexisallmighty
 *
 */
@ControllerAdvice
public class ExceptionHandlingController {
	/**
	 * Manages all ControlledException and wraps them into a standardized model
	 * for the front-end to process.
	 * 
	 * @param request
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(ControlledException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public Message handleGlobalEdgeException(HttpServletRequest request, ControlledException e) {
		// Get the message of the returned exception to the front end
		Message message = new Message(e.getMessage());

		// TODO: Log the exception's stack trace temporarily for development
		// purposes
		e.printStackTrace();

		return message;

	}

	/**
	 * Manages all Exception and wraps them into a standardized model for the
	 * front-end to process.
	 * 
	 * @param request
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Exception.class })
	public Message handleError(HttpServletRequest request, Exception e) {
		// Get the message of the returned exception to the front end
		Message message = new Message(e.getMessage());

		// TODO: Log the exception's stack trace temporarily for development
		// purposes
		e.printStackTrace();

		return message;

	}
}
