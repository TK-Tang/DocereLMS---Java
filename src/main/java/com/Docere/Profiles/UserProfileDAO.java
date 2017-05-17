package com.Docere.Profiles;

import java.util.List;

public interface UserProfileDAO {
	
	public void saveUserProfile(UserProfile userProfile);
	
	public void updateUserProfile(UserProfile userProfile);
	
	public void deleteUserProfileByID(int id);
	
	public void deleteUserProfileByUsername(String username);
	
	public UserProfile findUserProfileByID(int id);
	
	public UserProfile findUserProfileByNickname(String nickname);
	
	public UserProfile findUserProfileByUsername(String username);
	
	public List<UserProfile> retrieveAllUserProfiles();
}
