/**
 * Validates that a specific input element value must be present.
 */
function validateRequired(id, key) {
	var message = getPropertyValue(key);

	var element = $("#" + id);

	var value = element.val();

	if (value == null || value == "") {
		addValidationClass(element);
		addValidationMessage(element, message);

		throw Error(message);
	}
}

/**
 * Validates that a specific checkbox element value must be checked.
 */
function validateRequiredCheckbox(id, containerId) {
	var element = $("#" + id);
	var containerElement = $("#" + containerId);

	var checked = element.is(":checked");

	if (checked == undefined || checked == null || checked == false) {
		showValidationMessage(containerElement);

		throw Error(id);
	}
}

/**
 * Validates that a specific input element value must be compliant to the following regex:
 * /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i
 */
function validateEmailFormat(id, key) {
	var message = getPropertyValue(key);

	var element = $("#" + id);

	var value = element.val();

	var pattern = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i;

	if (!pattern.test(value)) {
		element.val("");

		addValidationClass(element);
		addValidationMessage(element, message);

		throw Error(message);
	}
}

/**
 * Shows a specific container element.
 */
function showValidationMessage(containerElement) {
	containerElement.show();
}

/**
 * Hides a specific container element.
 */
function hideValidationMessage(containerElement) {
	containerElement.hide();
}

/**
 * Toggles the visibility a specific container element.
 */
function toggleValidationMessage(element, containerId) {
	var checked = $(element).is(":checked");
	var containerElement = $("#" + containerId);

	if (checked) {
		hideValidationMessage(containerElement);

	} else {
		showValidationMessage(containerElement);
	}
}

/**
 * Adds the specific message as a placeholder of an input element.
 */
function addValidationMessage(element, message) {
	element.attr("placeholder", message);
}

/**
 * Adds the specific css class to an element.
 * This way the css details are hidden from the javascript validations.
 */
function addValidationClass(element) {
	element.addClass("error");
}

/**
 * Removes the specific css class to an element.
 * This way the css details are hidden from the javascript validations.
 */
function removeValidationClass(element) {
	element.removeClass("error");
}