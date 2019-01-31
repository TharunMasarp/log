package com.app.common;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.beans.UserLogin;

public class UserLoginValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserLogin.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "userId.required", "User Id is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required", "Password is required");
	}
}
