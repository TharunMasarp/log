package com.app.services;

import java.util.List;

import com.app.beans.UserRegistration;

public interface UserServices {
	public String saveUser(UserRegistration userRegistration);
	public List<UserRegistration> authenticateUser(String userId, String password);
	public List<UserRegistration> getAllRegistered();
}
