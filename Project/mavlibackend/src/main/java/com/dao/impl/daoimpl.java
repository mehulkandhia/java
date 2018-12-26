package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.catdao;
import com.model.Category;
@Service
@Repository("categories")
@Transactional
public class daoimpl implements catdao {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*@Autowired
	//@Bean(name = "categorydao1") */
	public daoimpl(SessionFactory sf) {
		super();
		this.sessionFactory = sf;
	}
	
	@Override
	public boolean add(Category model) {
		try
		{
			sessionFactory.getCurrentSession().save(model);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean update(Category model) {
		try
		{
			sessionFactory.getCurrentSession().update(model);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean delete(Category model) {
		try
		{
			sessionFactory.getCurrentSession().delete(model);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Category> ListCategories() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category2");
		List<Category> ListCategories=(List<Category>) query.list();
		session.close();
		return ListCategories;
	}

	@Override
	public Category getmodel(int categoryid) {
		
		for(Category m : ListCategories())
		{
			if(m.getCategoryid() == categoryid)
				return m;
		}
		Session session=sessionFactory.openSession();
		Category model=session.get(Category.class, categoryid);
		session.close();
		return model;
	}

}
