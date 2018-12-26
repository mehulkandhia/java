package com.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dao.cartdao;
import com.model.Cart;

@Service
@Repository("productcart2")
@Transactional
public class cartdaoimpl implements cartdao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public cartdaoimpl(SessionFactory sf) {
		super();
		this.sessionFactory = sf;
	}
	
	@Override
	public boolean add(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().save(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean update(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean delete(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Cart getCartItem(int cartid) {
		Session session=sessionFactory.openSession();
		Cart cart=session.get(Cart.class, cartid);
		session.close();
		return cart;
	}

	@Override
	public List<Cart> listCartItems(String username) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart1 where username=:uname and status='N'");
		query.setParameter("uname",username);
		List<Cart> ListCart=(List<Cart>) query.list(); 
		session.close();
		return ListCart;
	}

}
