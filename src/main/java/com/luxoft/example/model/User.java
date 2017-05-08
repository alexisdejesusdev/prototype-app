package com.luxoft.example.model;

/**
 * Represents a User model to encapsulate the appropriate data based on the
 * project requirements.
 * 
 * @author Alexis De Jesús
 *
 */
public class User {
	private String username;
	private String password;

	private String brand;

	private Boolean termsAccepted;

	/**
	 * Constructs an empty User
	 */
	public User() {

	}

	/**
	 * Constructs a copy of an existing User
	 * 
	 * @param user
	 */
	public User(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.brand = user.getBrand();
	}

	@Override
	public boolean equals(Object obj) {
		// Override the equals condition to validate if the username has the
		// same value
		if (this == obj) {

			return true;
		}

		if (obj instanceof User) {

			return username.equals(((User) obj).getUsername());

		} else {

			return false;
		}
	}

	@Override
	public int hashCode() {
		// Compute the hashcode of the class based on the username's native
		// hashcode
		int hashCode = username.hashCode();

		return hashCode;
	}

	// Setters and getters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Boolean getTermsAccepted() {
		return termsAccepted;
	}

	public void setTermsAccepted(Boolean termsAccepted) {
		this.termsAccepted = termsAccepted;
	}
}
