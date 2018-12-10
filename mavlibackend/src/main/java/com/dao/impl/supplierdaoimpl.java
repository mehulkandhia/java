package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.supplierdao;
import com.model.supplier;

@Repository("supplying")
@Transactional
@Service
public class supplierdaoimpl implements supplierdao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean add(supplier sup) {
		try
		{
			sessionFactory.getCurrentSession().save(sup);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean update(supplier sup) {
		try
		{
			sessionFactory.getCurrentSession().update(sup);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean delete(supplier sup) {
		try
		{
			sessionFactory.getCurrentSession().delete(sup);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<supplier> supply() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier1");
		List<supplier> supply=query.list();
		session.close();
		return supply;
	}

	@Override
	public supplier getmodel(int supplierId) {
		Session session=sessionFactory.openSession();
		supplier supplying=session.get(supplier.class, supplierId);
		session.close();
		return supplying;
	}

}
