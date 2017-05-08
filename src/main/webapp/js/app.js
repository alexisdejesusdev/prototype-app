// Global variables
var brand = getParameter("brand");
var language = getParameter("lan");

var signUpUrl = "rest/user/signUp?brand=" + brand + "&lan=" + language;
var signInUrl = "rest/user/signIn?brand=" + brand + "&lan=" + language;

var indexUrl = "secure/index.html?brand=" + brand + "&lan=" + language;

/**
 * Sets up the page's view based on the URL parameters:
 * 1. Initializes the template views for the forms used.
 * 2. Loads the localized properties based on the "language" global variable and adds them to the view.
 * 3. Prepares the modals's events.
 * 
 */
function init() {
	// Get the template views from the server to better separate views from model
	// They're loaded before the document is actually ready for better performance
	var signInTemplate = $("<div>").load("templates/signIn.html");
	var signUpTemplate = $("<div>").load("templates/signUp.html");

	// Get the properties according to the URL's "lan" parameter
	loadProperties(language);

	$(document).ready(function() {
		// Populate the templates according to the configuration and URL data
		populateBasePage();
		signInTemplate = populateSignInTemplate(signInTemplate);
		signUpTemplate = populateSignUpTemplate(signUpTemplate);

		// Put the templates in the document
		$("#wrap").append(signInTemplate);
		$("#wrap").append(signUpTemplate);

		// Prepare the modals to close when the required conditions are met
		prepareModals();
	});
}

/**
 * Performs the User Sign In operation based on the page's form and pre-configured values and functional requirements.
 */
function signIn() {
	// Clear any previous server errors
	clear("sign-in-errors");

	// Get the values from the form fields
	var username = $("#username").val();
	var password = $("#password").val();

	// Validate the business rules
	validateRequired("username", "error.username");
	validateRequired("password", "error.password");

	validateEmailFormat("username", "error.username.format");

	// Create the data model to be sent
	var user = {
		username : username,
		password : password
	};

	// Post the request to the server
	post(signInUrl, user, signInSuccess, signInError);
}

/**
 * Redirects to an index page after a successful server authentication response.
 */
function signInSuccess(response) {
	// Temporarily just redirect to a welcome page when the credentials are correct
	window.location.href = indexUrl;
}

/**
 * Performs the User Sign Up operation based on the page's form and pre-configured values and functional requirements.
 */
function signUp() {
	// Clear any previous server errors
	clear("sign-up-errors");

	// Get the values from the form fields
	var username = $("#newUsername").val();
	var password = $("#newPassword").val();
	var termsAccepted = $("#termsAccepted").is(":checked");

	// Validate the business rules
	validateRequired("newUsername", "error.username");
	validateRequired("newPassword", "error.password");

	validateEmailFormat("newUsername", "error.username.format");

	// Validate the acceptance of the terms for the "Beta" brand only
	if (brand == "Beta") {
		validateRequiredCheckbox("termsAccepted", "terms-error-msg");
	}

	// Create the data model to be sent
	var user = {
		username : username,
		password : password,
		termsAccepted : termsAccepted
	};

	// Post the request to the server
	post(signUpUrl, user, signUpSuccess, signUpError);
}

/**
 * Reloads the current page after a successful server Sign Up response.
 */
function signUpSuccess(response) {
	alert(getPropertyValue("label.signUp.success"));

	// Temporarily just reload the page when the sign up was correct
	location.reload();
}

/**
 * Process server Sign In error messages generically.
 */
function signInError(response) {
	error(response, "sign-in-errors");
}

/**
 * Process server Sign In error messages generically.
 */
function signUpError(response) {
	error(response, "sign-up-errors");
}