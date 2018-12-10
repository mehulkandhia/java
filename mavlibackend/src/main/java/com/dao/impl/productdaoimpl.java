package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.productdao;
import com.model.product;
@Service
@Repository("production")
@Transactional
public class productdaoimpl implements productdao 
{

	@Autowired
	SessionFactory sessionFactory;
	
	public productdaoimpl(SessionFactory sf) {
		super();
		this.sessionFactory = sf;
	}
	
	@Override
	public boolean add(product prod) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(prod);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		//return false;
	}

	@Override
	public boolean update(product prod) {
		try
		{
			sessionFactory.getCurrentSession().update(prod);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean delete(product prod) {
		try
		{
			sessionFactory.getCurrentSession().delete(prod);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<product> ListProducts() {
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Product2");
	List<product> ListProducts=(List<product>) query.list(); 
	session.close();
	return ListProducts;
	}

	@Override
	public product getproduct(int productid) {
		Session session=sessionFactory.openSession();
		product prod=session.get(product.class, productid);
		session.close();
		return prod;
	}
}
