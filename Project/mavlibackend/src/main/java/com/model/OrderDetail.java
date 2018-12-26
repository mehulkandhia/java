package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="order1")
@Table(name="order1")
public class OrderDetail 
{
	@Id
	@GeneratedValue
	int orderid;
	String username;
	Date orderDate;
	int totalShippingAmount;
	String pmode;
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotalShippingAmount() {
		return totalShippingAmount;
	}
	public void setTotalShippingAmount(int totalShippingAmount) {
		this.totalShippingAmount = totalShippingAmount;
	}
	public String getPmode() {
		return pmode;
	}
	public void setPmode(String pmode) {
		this.pmode = pmode;
	}
	
}
