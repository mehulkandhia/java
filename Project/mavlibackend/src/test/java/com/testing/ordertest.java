package com.testing;


import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.orderdao;
import com.model.Cart;
import com.model.OrderDetail;
public class ordertest 
{
	private static orderdao order;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		order=(orderdao)context.getBean("orders");
	}
	
	@Ignore
	@Test
	public void paymentProcessTest()
	{
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setUsername("vivo");
		orderDetail.setOrderDate(new Date());
		orderDetail.setPmode("CC");
		orderDetail.setTotalShippingAmount(8000);
		assertTrue("Problem in entering payment:",order.PaymentProcess(orderDetail));
	}
	
	
	@Test
	public void updateCartTest()
	{
		assertTrue("Problem in updating status:",order.UpdateCartItemStatus("vivo"));
	}
}
