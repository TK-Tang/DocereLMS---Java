package com.Docere.LoginManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Docere.Authority.Authority;
import com.Docere.Authority.AuthorityService;
import com.Docere.Profiles.UserProfile;
import com.Docere.User.User;
import com.Docere.User.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthorityService authorityService;
	
	@RequestMapping(value={"/register","/newaccount"}, method=RequestMethod.GET)
	public String showRegister(Model model){
		model.addAttribute( "User", new User(null, null, null));
		
		return "/register";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLogin(){
		return "/login";
	}
	
	@RequestMapping(value="/createaccount", method=RequestMethod.POST)
	public String createAccount(User user, BindingResult result){
		
		if (result.hasErrors()){
			return "/register";
		}
		
		if(userService.findUserByUsername(user.getUsername()) != null){
			return "/register";
		}
		
		user.setAuthority("user");
		user.setEnabled(1);
		
		UserProfile userProfile = new UserProfile();
		userProfile.setDescription("GENERIC");
		
		user.setUserProfile(userProfile);
		
		try{
			Authority auth = new Authority(user.getUsername(), user.getAuthority());
			authorityService.saveAuthority(auth);
			userService.saveUser(user);
			
			if(user.getUserID() == auth.getAuthorityID()){
				System.out.println("User and authority ID matches.");
			} else {
				System.out.println("User and authority ID do not match. Their could be errors with deleting shit by ID.");
			}
			
		} catch (DuplicateKeyException e){
			result.rejectValue("username", "DuplicateKey.user.username", "This name already exists.");
			
			return "/register";
		}
		
		return "/login";
	}
}
