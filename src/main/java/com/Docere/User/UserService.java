package com.Docere.User;

import java.util.List;

public interface UserService {
	
	public void saveUser(User user);
	
	public User findUserByID(int id);
	
	public User findUserByUsername(String username);
	
	public void updateUser(User user);
	
	public void deleteUserByUsername(String username);
	
	public void deleteUserByID(int id);
	
	public List<User> retrieveAllUsers();
}
