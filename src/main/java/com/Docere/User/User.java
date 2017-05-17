package com.Docere.User;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.Docere.Profiles.UserProfile;


@Entity(name="Users")
@Table(name="Users")
public class User implements Serializable{

	private static final long serialVersionUID = 5729727545813781294L;
	
	public User(){
		
	}

	public User(String username, String password, String authority){
		this.username = username;
		this.password = password;
		this.authority = authority;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userID", unique = true)
	private int userID;
	
	@NotNull
	@Size(min = 1, max = 64)
	@Column(name = "username", unique = true)	
	private String username;
	
	private UserProfile userProfile;
	
	@NotNull
	@Column(name = "authority")
	private String authority;
	
	@NotNull
	@Size(min = 8, max = 64)
	@Column(name="password")
	private String password;
	
	@NotNull
	@Column(name="enabled")
	private int enabled;


	public int getUserID() {
		return userID;
	}

	public String getUsername() {
		return username;
	}
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public String getAuthority() {
		return authority;
	}

	public String getPassword() {
		return password;
	}
	
	public int getEnabled(){
		return enabled;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEnabled(int enabled){
		this.enabled = enabled;
	}
}
