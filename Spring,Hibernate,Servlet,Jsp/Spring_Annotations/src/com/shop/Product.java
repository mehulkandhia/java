package com.shop;

public class Product 
{
	private String ProductId;
	private String ProductName;
	private int Price;
	
	public String getProductId() 
	{
		return ProductId;
	}
	
	public void setProductId(String productId) 
	{
		ProductId = productId;
	}
	
	public String getProductName() 
	{
		return ProductName;
	}
	
	public void setProductName(String productName) 
	{
		ProductName = productName;
	}
	
	public int getPrice() 
	{
		return Price;
	}
	
	public void setPrice(int price) 
	{
		Price = price;
	}
}
