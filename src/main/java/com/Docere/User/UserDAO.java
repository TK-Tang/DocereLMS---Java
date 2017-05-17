package com.Docere.User;

import java.util.List;

public interface UserDAO {
	
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUserByID(int id);
	
	public void deleteUserByName(String username);
	
	public User findUserByID(int id);
	
	public User findUserByUsername(String username);
	
	public List<User> retrieveAllUsers();

}
