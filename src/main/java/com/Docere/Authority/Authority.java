package com.Docere.Authority;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "Authorities")
@Table(name = "Authorities")
public class Authority implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1018764172517811264L;

	public Authority(){
		
	}

	public Authority (String username, String authority){
		this.username = username;
		this.authority = authority;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "authorityID")
	private int authorityID;
	
	@NotNull
	@Column(name="authority")
	private String authority;
	
	@NotNull
	@Column(name="username")
	private String username;
	

	public int getAuthorityID() {
		return authorityID;
	}

	public String getAuthority() {
		return authority;
	}

	public String getUsername() {
		return username;
	}

	public void setAuthorityID(int authorityID) {
		this.authorityID = authorityID;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
