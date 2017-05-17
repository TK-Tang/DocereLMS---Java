package com.Docere.Dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Docere.User.UserService;
import com.Docere.User.UserServiceImpl;

@Controller
public class DashboardController {
	
	@Autowired
	UserService userServiceImpl = new UserServiceImpl();
	
	@RequestMapping(value={"/dashboard","/index","/home"}, method=RequestMethod.GET)
	public String home(Model model){
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		
		int randomNumber = (int) Math.round(Math.random() * 100);
		
		model.addAttribute("username", username);
		model.addAttribute("password", userServiceImpl.findUserByUsername(username).getPassword());
		model.addAttribute("randomNumber", randomNumber);
		return "/dashboard";
	}
	
}
