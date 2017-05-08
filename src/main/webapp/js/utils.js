/**
 * Connects the appropriate functions to the modals's events to be hidden or shown depending on the user feedback.
 */
function prepareModals() {
	// Work with the style of the modals and the window events to hide these modals accordingly
	var modalSignIn = $("#modalSignIn");
	var modalSignUp = $("#modalSignUp");

	$(window).click(function(e) {
		if (e.target.id == modalSignIn.attr("id")) {
			modalSignIn.addClass("hidden");
			
			// Clear any previous server errors
			clear("sign-in-errors");
			clear("sign-up-errors");

		} else if (e.target.id == modalSignUp.attr("id")) {
			modalSignUp.addClass("hidden");
			
			// Clear any previous server errors
			clear("sign-in-errors");
			clear("sign-up-errors");

		} else if (e.target.id == "iniciarSesion") {
			modalSignIn.removeClass("hidden");
			modalSignUp.removeClass("hidden");
		}
	});

	// Hide the sections that depend on business requirements
	if (brand == "Alpha") {
		$(".terms-field").addClass("hidden");
	}
}

/**
 * Gets a parameter value from the URL.
 */
function getParameter(name) {
	var url = location.search.substring(1);

	var array = url.split('&');

	for (var i = 0; i < array.length; i++) {
		var parameter = array[i].split('=');

		if (parameter[0] == name) {

			return parameter[1];
		}
	}
}

/**
 * Loads the properties according to the "language" parameter.
 */
function loadProperties(language) {
	$.i18n.properties({
		path : "properties/",
		name : "Messages",
		mode : "both",
		language : language,
		async : false
	});
}

/**
 * Replaces the placeholder values of the base page with the corresponding properties in the requested language.
 */
function populateBasePage() {
	var text = $("#wrap").html();
	text = replaceKey(text, "button.signIn");

	$("#wrap").html(text);
}

/**
 * Replaces the placeholder values of the Sign In template with the corresponding properties in the requested language.
 */
function populateSignInTemplate(template) {
	var text = template.html();

	text = replaceKey(text, "placeholder.username");
	text = replaceKey(text, "placeholder.password");
	text = replaceKey(text, "label.remember");
	text = replaceKey(text, "label.forgot");
	text = replaceKey(text, "button.signIn.submit");
	text = replaceKey(text, "label.noAccount");
	text = replaceKey(text, "label.signUp");

	template = $.parseHTML(text);

	return template;
}

/**
 * Replaces the placeholder values of the Sign Up template with the corresponding properties in the requested language.
 */
function populateSignUpTemplate(template) {
	var text = template.html();

	text = replaceKey(text, "header.signUp");
	text = replaceKey(text, "placeholder.username");
	text = replaceKey(text, "placeholder.password");
	text = replaceKey(text, "label.terms");
	text = replaceKey(text, "error.terms");
	text = replaceKey(text, "button.signUp.submit");

	template = $.parseHTML(text);

	return template;
}

/**
 * Replaces the placeholder values of the index page with the corresponding properties in the requested language.
 */
function populateIndexPage() {
	var lan = getParameter('lan');

	$.i18n.properties({
		path : "../properties/",
		name : "Messages",
		mode : "both",
		language : lan,
		async : false
	});

	var text = $("#wrap").html();
	text = replaceKey(text, "label.signIn.success");
	text = replaceKey(text, "button.goback");

	$("#wrap").html(text);
}

/**
 * Replaces a placeholder value with a specified property key value.
 */
function replaceKey(text, key) {
	var placeholder = "{{" + key + "}}";
	text = text.replace(placeholder, getPropertyValue(key));

	return text;
}

/**
 * Gets the property value based on a specific key.
 */
function getPropertyValue(key) {
	var value = $.i18n.prop(key);

	return value;
}

/**
 * Shows a generic message for unimplemented functionality.
 */
function underConstruction() {
	alert(getPropertyValue("error.underConstruction"));
}

/**
 * Process server error messages generically.
 */
function error(response, containerId) {
	var message = response.responseJSON.message;

	$("#" + containerId).html(message);
}

/**
 * Clears the inner HTML of a given container.
 */
function clear(containerId) {
	$("#" + containerId).html("");
}


/**
 * Defines a post function to hide the implementation of the call.
 */
function post(url, data, successHandler, errorHandler) {
	var jqxhr = $.ajax({
		url : url,
		type : "POST",
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		dataType : "json",
	}).done(successHandler).fail(errorHandler);
}