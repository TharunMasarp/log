package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.beans.UserRegistration;
import com.app.dao.UserDao;


public class UserServicesImpl implements UserServices{
	
	@Autowired
	private UserDao userDao;

	@Override
	public String saveUser(UserRegistration userRegistration) {
		
		return userDao.saveUser(userRegistration);
	}

	@Override
	public List<UserRegistration> authenticateUser(String userId, String password) {
		return userDao.authenticateUser(userId, password);
	}

	@Override
	public List<UserRegistration> getAllRegistered() {
		return userDao.getAllRegitered();
	}

}
