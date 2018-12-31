package com.dao.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dao.orderdao;
import com.model.OrderDetail;
import com.model.product;

@Service
@Repository("orders")
@Transactional
public class orderdaoimpl implements orderdao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public orderdaoimpl(SessionFactory sf) {
		super();
		this.sessionFactory = sf;
	}
	
	@Override
	public boolean PaymentProcess(OrderDetail order) {
		try
		{
			sessionFactory.getCurrentSession().save(order);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	@Override
	public boolean UpdateCartItemStatus(String username) {
		try
		{
			Query query=sessionFactory.getCurrentSession().createNativeQuery("update Cart1 set status='p' where username=:uname");
			query.setParameter("uname", username);
			int row_eff=query.executeUpdate();
			if(row_eff>0)
				return true;
				else
				return false;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
}

	@Override
	public OrderDetail getOrderDetail(int orderid) {
		Session session=sessionFactory.openSession();
		OrderDetail order=session.get(OrderDetail.class, orderid);
		session.close();
		return order;
	}
	
	@Override
	public List<OrderDetail> OrderList() {
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from order1");
	List<OrderDetail> ListOrder=(List<OrderDetail>) query.list(); 
	session.close();
	return ListOrder;
	}
}