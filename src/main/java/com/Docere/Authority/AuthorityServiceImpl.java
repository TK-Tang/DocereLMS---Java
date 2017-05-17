package com.Docere.Authority;

import org.springframework.beans.factory.annotation.Autowired;

public class AuthorityServiceImpl implements AuthorityService{

	@Autowired
	private AuthorityDAO authorityDAOImpl;
	
//
//	public void setAuthorityDAOImpl(AuthorityDAOImpl authorityDAOImpl){
//		this.authorityDAOImpl = authorityDAOImpl;
//	}
	
	@Override
	public void saveAuthority(Authority au) {
		authorityDAOImpl.saveAuthority(au);
	}

	@Override
	public void updateAuthority(Authority au) {
		authorityDAOImpl.updateAuthority(au);
		
	}

}
