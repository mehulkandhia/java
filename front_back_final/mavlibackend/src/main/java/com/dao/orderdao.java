package com.dao;

import java.util.List;

import com.model.OrderDetail;

public interface orderdao {

	public boolean PaymentProcess(OrderDetail order);
	public boolean UpdateCartItemStatus(String username);
	public OrderDetail getOrderDetail(int orderid);
	List<OrderDetail> OrderList();
}
