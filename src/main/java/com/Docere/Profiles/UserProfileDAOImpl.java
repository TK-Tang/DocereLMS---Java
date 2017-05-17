package com.Docere.Profiles;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserProfileDAOImpl implements UserProfileDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveUserProfile(UserProfile userProfile) {
		this.sessionFactory.getCurrentSession().save(userProfile);
		
	}

	@Override
	public void updateUserProfile(UserProfile userProfile) {
		this.sessionFactory.getCurrentSession().update(userProfile);
	}

	@Override
	public void deleteUserProfileByID(int id) {
		// Reset Profile
	}
	

	@Override
	public void deleteUserProfileByUsername(String username) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public UserProfile findUserProfileByID(int userProfileID) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<UserProfile> userProfileResultList = currentSession.createQuery("FROM UsersProfiles WHERE userProfileID: userProfileID").setParameter("userProfileID", userProfileID).getResultList();
		
		if (userProfileResultList.size() != 1){
			System.out.println("userProfileResultList.size() returned: " + userProfileResultList.size());
			return null;
		}
		return userProfileResultList.get(0);
	}

	@Override
	public UserProfile findUserProfileByNickname(String nickname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserProfile findUserProfileByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserProfile> retrieveAllUserProfiles() {
		// TODO Auto-generated method stub
		return null;
	}


}
