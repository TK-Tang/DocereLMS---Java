package com.Docere.Profiles;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.Docere.User.User;

@Entity(name = "UserProfiles")
@Table(name = "UserProfiles")
public class UserProfile implements Serializable {

	private static final long serialVersionUID = -9002837413668096502L;
	
	public UserProfile(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userProfileID")
	private int userProfileID;
	
	
	
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	@GenericGenerator(name = "generator", strategy = "foreign",
		parameters = @Parameter(name = "property", value = "user")
	)
    private int userID;
    
    private User user;
    
    @Column(name = "nickname")
    private String nickname;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "description")
    private String description;
    
    private byte[] avatarImage;
    
    
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public User getUser(){
    	return this.user;
    }

	public int getUserProfileID() {
		return userProfileID;
	}

	public int getUserID() {
		return userID;
	}

	public String getNickname() {
		return nickname;
	}

	public String getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}

	public String getDescription() {
		return description;
	}
	
	public byte[] getAvatarImage(){
		return avatarImage;
	}

	public void setUserProfileID(int userProfileID) {
		this.userProfileID = userProfileID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setAvatarImage(byte[] avatarImage){
		this.avatarImage = avatarImage;
	}
}
