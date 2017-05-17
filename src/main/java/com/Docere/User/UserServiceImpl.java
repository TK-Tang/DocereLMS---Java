package com.Docere.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAOImpl;

	@Override
	@Transactional
	public void saveUser(User user) {
		userDAOImpl.saveUser(user);	
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userDAOImpl.updateUser(user);
		
	}
	
	@Override
	@Transactional
	public User findUserByID(int userID) {
		return userDAOImpl.findUserByID(userID);
	}

	@Override
	@Transactional
	public User findUserByUsername(String username) {
		return userDAOImpl.findUserByUsername(username);
	}
	
	@Override
	@Transactional
	public void deleteUserByID(int userID){
		userDAOImpl.deleteUserByID(userID);
	}

	@Override
	public void deleteUserByUsername(String username) {
		userDAOImpl.deleteUserByName(username);
	}
	
	public List<User> retrieveAllUsers(){
		return userDAOImpl.retrieveAllUsers();
	}
	
}
