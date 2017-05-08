package com.luxoft.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.luxoft.example.model.User;
import com.luxoft.example.model.exception.ControlledException;
import com.luxoft.example.service.UserService;

/**
 * REST endpoint for user operations.
 * 
 * @author Alexis De Jesús
 *
 */
@RestController
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * Adds a user to the requested brand pending the appropriate validations.
	 * 
	 * @param user
	 * @param brand
	 * @param lan
	 * @param request
	 * @return
	 * @throws ControlledException
	 */
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value = "/user/signUp", method = RequestMethod.POST)
	public User signUp(@RequestBody User user, @RequestParam String brand, @RequestParam String lan,
			HttpServletRequest request) throws ControlledException {
		User response = userService.signUp(user, brand, lan);

		return response;
	}

	/**
	 * Signs in an existing user to the requested brand pending the appropriate validations.
	 * 
	 * @param user
	 * @param brand
	 * @param lan
	 * @param request
	 * @return
	 * @throws ControlledException
	 */
	@ResponseBody
	@RequestMapping(value = "/user/signIn", method = RequestMethod.POST)
	public User signIn(@RequestBody User user, @RequestParam String brand, @RequestParam String lan,
			HttpServletRequest request) throws ControlledException {
		User response = userService.signIn(user, brand, lan);

		return response;
	}
}
