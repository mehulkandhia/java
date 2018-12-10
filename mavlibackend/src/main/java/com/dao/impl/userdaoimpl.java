package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.userdao;
import com.model.UserDetails;

@Repository("userdao")
@Transactional
public class userdaoimpl implements userdao 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean add(UserDetails user) {
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean update(UserDetails user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean delete(UserDetails user) {
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<UserDetails> users() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User");
		List<UserDetails> users=query.list();
		session.close();
		return users;
	}

	@Override
	public UserDetails getuser(int userid) {
		Session session=sessionFactory.openSession();
		UserDetails user=session.get(UserDetails.class, userid);
		session.close();
		return user;
	}

}
