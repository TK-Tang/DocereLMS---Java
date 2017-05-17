package com.Docere.User;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.Docere.Authority.Authority;

public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(User user) {
		System.out.println("UserDAOImpl inserting user: " + user.getUsername() + " with password " + user.getPassword());
		this.sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void updateUser(User user) {
		System.out.println("UserDAOImpl updating user: " + user.getUsername());
		this.sessionFactory.getCurrentSession().update(user);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public void deleteUserByID(int userID) {
		System.out.println("Deleting user/auth by ID: " + userID);
		
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<User> userResultList = currentSession.createQuery("FROM Users WHERE userID = :userID").setParameter("userID", userID).getResultList();
		List<Authority> authResultList =  currentSession.createQuery("FROM Authorities authorityID = :authorityID").setParameter("authorityID", userID).getResultList();
		//NEEDS DELETE CASCADE FOR LOGBOOKS
		
		if (userResultList.size() > 1 || authResultList.size() > 1){
			System.out.println("SEVERE ERROR: More than one user found when a request to delete a single user was recieved!");
		}
		
		Authority auth = authResultList.get(0);
		User user = userResultList.get(0);
		
		System.out.println("Authority had username: " + auth.getUsername() + " and user had username: " + auth.getUsername());
		
		currentSession.delete(auth);
		currentSession.delete(user);
	}

	@Override
	public void deleteUserByName(String username) {
		System.out.println("Deleting user/auth by username: " + username);
		
		Session currentSession = this.sessionFactory.getCurrentSession();
		User user = (User) currentSession.createQuery("FROM Users WHERE username = :username").setParameter("username", username);
		Authority auth = (Authority) currentSession.createQuery("FROM Authorities WHERE username = :username").setParameter("username", username);
		//NEEDS DELETE CASCADE FOR LOGBOOKS
		
		System.out.println("Authority had username: " + auth.getUsername());
		
		currentSession.delete(user);
		currentSession.delete(auth);
		
	}

	@Override
	public User findUserByID(int userID) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		User user = (User) currentSession.createQuery("FROM Users WHERE userID = :userID").setParameter("userID", userID);
		
		return user;
	}

	@Override
	@SuppressWarnings("unchecked")
	public User findUserByUsername(String username) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<User> userResultList = currentSession.createQuery("FROM Users WHERE username = :username").setParameter("username", username).getResultList();
		
		if (userResultList.size() == 0){
			return null;
		}
		
		return userResultList.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> retrieveAllUsers() {
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<User> userResultList = currentSession.createQuery("FROM Users").getResultList();
		
		return userResultList;
	}
	

}
