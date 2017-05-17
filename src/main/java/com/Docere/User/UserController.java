package com.Docere.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@Autowired
	UserService userServiceImpl = new UserServiceImpl();
	
	@RequestMapping(value = {"user/getCurrentUser"}, method = RequestMethod.GET )
	public @ResponseBody com.Docere.User.User getCurrentUser() {
		
		org.springframework.security.core.userdetails.User springFrameworkUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = springFrameworkUser.getUsername();
		
		return userServiceImpl.findUserByUsername(username);
	}
	
	@RequestMapping(value = {"user/getCurrentUsername"}, method = RequestMethod.GET )
	public @ResponseBody String getCurrentUsername() {
		
		org.springframework.security.core.userdetails.User springFrameworkUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return springFrameworkUser.getUsername();
	}
	
	@RequestMapping(value = {"user/getAllUsers"}, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers(){
		return userServiceImpl.retrieveAllUsers();
	}

}
