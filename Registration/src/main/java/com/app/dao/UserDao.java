package com.app.dao;

import java.util.List;

import com.app.beans.UserRegistration;

public interface UserDao {
	public String saveUser(UserRegistration userRegistration);
	public List<UserRegistration> authenticateUser(String userId, String password);
	public List<UserRegistration> getAllRegitered();
}
