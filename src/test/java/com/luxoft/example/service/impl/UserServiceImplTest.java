package com.luxoft.example.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luxoft.example.model.User;
import com.luxoft.example.model.exception.ControlledException;
import com.luxoft.example.service.UserService;
import com.luxoft.example.service.util.LanguageManagerUtil;

/**
 * Temporarily just test the service layer as a prototype of how unit test would
 * be made.
 * 
 * @author alexisallmighty
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class UserServiceImplTest {
	private static final String BRAND_ALPHA = "Alpha";
	private static final String BRAND_BETA = "Beta";

	@Autowired
	private UserService service;

	@Test
	public void signUpSuccessAlphaBrand() throws ControlledException {
		// Create a successful user model
		User user = new User();
		user.setUsername("a@gmail.com");
		user.setPassword("test");

		// Call the sign up service
		service.signUp(user, BRAND_ALPHA, LanguageManagerUtil.ENGLISH);

		// Always assert true since an exception will be thrown if an error
		assertTrue(true);
	}

	@Test
	public void signUpSuccessBetaBrand() throws ControlledException {
		// Create a successful user model
		User user = new User();
		user.setUsername("b@gmail.com");
		user.setPassword("test");
		user.setTermsAccepted(true);

		// Call the sign up service
		service.signUp(user, BRAND_BETA, LanguageManagerUtil.ENGLISH);

		// Always assert true since an exception will be thrown if an error
		assertTrue(true);
	}

	@Test(expected = ControlledException.class)
	public void signUpErrorUserAlreadyExists() throws ControlledException {
		// Create a user model
		User user = new User();
		user.setUsername("aa@gmail.com");
		user.setPassword("test");

		// Call the sign up service twice so the second time it fails
		service.signUp(user, BRAND_ALPHA, LanguageManagerUtil.ENGLISH);
		service.signUp(user, BRAND_ALPHA, LanguageManagerUtil.ENGLISH);
	}

	@Test(expected = ControlledException.class)
	public void signUpErrorPasswordMissing() throws ControlledException {
		// Create a user model
		User user = new User();
		user.setUsername("aaa@gmail.com");

		// Call the sign up service
		service.signUp(user, BRAND_ALPHA, LanguageManagerUtil.ENGLISH);
	}

	@Test(expected = ControlledException.class)
	public void signUpErrorTermsNotAccepted() throws ControlledException {
		// Create a user model
		User user = new User();
		user.setUsername("bb@gmail.com");
		user.setPassword("test");
		user.setTermsAccepted(false);

		// Call the sign up service
		service.signUp(user, BRAND_BETA, LanguageManagerUtil.ENGLISH);
	}

	@Test
	public void signInSuccess() throws ControlledException {
		// Create a user model
		User user = new User();
		user.setUsername("aaaa@gmail.com");
		user.setPassword("test");

		// Call the sign up service
		service.signUp(user, BRAND_ALPHA, LanguageManagerUtil.ENGLISH);

		// Create the same user model
		user = new User();
		user.setUsername("aaaa@gmail.com");
		user.setPassword("test");

		// Call the sign in service
		service.signIn(user, BRAND_ALPHA, LanguageManagerUtil.ENGLISH);

		// Always assert true since an exception will be thrown if an error
		assertTrue(true);
	}

	@Test(expected = ControlledException.class)
	public void signInErrorPasswordDoesntMatch() throws ControlledException {
		// Create a user model
		User user = new User();
		user.setUsername("aaaaa@gmail.com");
		user.setPassword("test");

		// Call the sign up service
		service.signUp(user, BRAND_ALPHA, LanguageManagerUtil.ENGLISH);

		// Create a user model
		user = new User();
		user.setUsername("aaaaa@gmail.com");
		user.setPassword("other");

		// Call the sign in service
		service.signIn(user, BRAND_ALPHA, LanguageManagerUtil.ENGLISH);
	}

	@Test(expected = ControlledException.class)
	public void signInErrorBrandDoesntMatch() throws ControlledException {
		// Create a user model
		User user = new User();
		user.setUsername("aaaaaa@gmail.com");
		user.setPassword("test");
		user.setTermsAccepted(true);

		// Call the sign up service
		service.signUp(user, BRAND_ALPHA, LanguageManagerUtil.ENGLISH);

		// Create a user model
		user = new User();
		user.setUsername("aaaaaa@gmail.com");
		user.setPassword("test");
		user.setTermsAccepted(true);

		// Call the sign in service
		service.signIn(user, BRAND_BETA, LanguageManagerUtil.ENGLISH);
	}

}
