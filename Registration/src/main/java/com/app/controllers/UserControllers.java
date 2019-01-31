package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.beans.UserLogin;
import com.app.beans.UserRegistration;
import com.app.common.UserLoginValidation;
import com.app.common.UserValidator;
import com.app.services.UserServices;

@Controller
public class UserControllers {
	
	@Autowired
	private UserServices userServices;
	
	@RequestMapping(value="/home.htm", method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value="/register.htm", method=RequestMethod.GET)
	public ModelAndView userSave() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("registration", new UserRegistration());
		mav.setViewName("register");
		return mav;
	}
	
	@RequestMapping(value="/register.htm", method=RequestMethod.POST)
	public ModelAndView userSave(@ModelAttribute("registration")UserRegistration userRegistration, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
	UserValidator userValidator = new UserValidator();
	userValidator.validate(userRegistration, result);
	if(result.hasErrors()) {
		mav.addObject("userRegValidations", result);
		mav.setViewName("register");
		return mav;
	}
		if(userRegistration.getPassword().equals(userRegistration.getcPassword())) {
			/*IdGenerators idg = new IdGenerators();
			idg.setPrefix(userRegistration.getName());*/ //-NotWorking
			String status =userServices.saveUser(userRegistration);
			System.out.println(status);
			mav.addObject("name", userRegistration.getName());
			mav.addObject("emailId", userRegistration.getEmailId());
			//mav.addObject("userId", userRegistration.getUserId());
			mav.addObject(userRegistration);
			mav.setViewName("reg_success");
			return mav;
		}else {
			mav.addObject("status", "Password and Confirm Password must match");
			mav.setViewName("register");
			return mav;
		}
	}
	
	@RequestMapping(value="/login.htm", method=RequestMethod.GET)
	public ModelAndView userAuthentication() {
		ModelAndView mav =new ModelAndView();
		mav.addObject("login", new UserLogin());
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value="/login.htm", method=RequestMethod.POST)
	public ModelAndView userAuthentication(@ModelAttribute("login")UserLogin userLogin, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		UserLoginValidation userLoginValidation = new UserLoginValidation();
		userLoginValidation.validate(userLogin, result);
		if(result.hasErrors()) {
			mav.addObject(result);
			mav.setViewName("login");
			return mav;
		}
		List<UserRegistration> userDetails = userServices.authenticateUser(userLogin.getUserId(), userLogin.getPassword());
		if(userDetails.size()>0) {
			mav.addObject("loggedUser", userDetails);
			mav.setViewName("login_success");
			return mav;
		}else {
			mav.addObject("status", "Invalid User Id/Password");
			mav.setViewName("login");
			return mav;
		}
	}
	
	@RequestMapping(value="/get_registered.htm", method=RequestMethod.GET)
	public ModelAndView getRegistered() {
		ModelAndView mav = new ModelAndView();
		List<UserRegistration> getAllRegisteredUsers = userServices.getAllRegistered();
		mav.addObject("registeredDetails",getAllRegisteredUsers);
		mav.setViewName("get_registered");
		return mav;
	}
	

}
