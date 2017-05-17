package com.Docere.Authority;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class AuthorityDAOImpl implements AuthorityDAO{
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	@Transactional
	public void saveAuthority(Authority au){
		this.sessionFactory.getCurrentSession().save(au);
	}
	
	
	//You must create a new Authority object before this method can be invoked
	@Override
	@Transactional
	public void updateAuthority(Authority au){
		this.sessionFactory.getCurrentSession().update(au);
	}
}
