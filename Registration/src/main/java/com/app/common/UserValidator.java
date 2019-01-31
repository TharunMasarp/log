package com.app.common;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.beans.UserRegistration;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistration.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		/*UserRegistration userRegistration = (UserRegistration) target;*/
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required", "Name is required");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "userId.required", "User Id is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "emailId.required", "Email Id is required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required", "Password is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cPassword", "cPassword.required", "Conform Password is required");
	}

}
