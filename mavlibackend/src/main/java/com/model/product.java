package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Product2")
@Table(name="Product2")
public class product {

@Id
@GeneratedValue
private int productid;
private String productname;
private String brandname;
private String productdesc;

int quantity;
int supplierid;
int categoryid;
int price;
int stock;

public int getProductid() 
{
	return productid;
}
public void setProductid(int productid) 
{
	this.productid = productid;
}
public String getProductname() 
{
	return productname;
}
public void setProductname(String productname) 
{
	this.productname = productname;
}
public String getBrandname() 
{
	return brandname;
}
public void setBrandname(String brandname) 
{
	this.brandname = brandname;
}
public String getProductdesc() 
{
	return productdesc;
}
public void setProductdesc(String productdesc) 
{
	this.productdesc = productdesc;
}
public int getQuantity() 
{
	return quantity;
}
public void setQuantity(int quantity) 
{
	this.quantity = quantity;
}
public int getSupplierid() 
{
	return supplierid;
}
public void setSupplierid(int supplierid) 
{
	this.supplierid = supplierid;
}
public int getCategoryid() 
{
	return categoryid;
}
public void setCategoryid(int categoryid) 
{
	this.categoryid = categoryid;
}
public int getPrice() 
{
	return price;
}
public void setPrice(int price) 
{
	this.price = price;
}
public int getStock() 
{
	return stock;
}
public void setStock(int stock) 
{
	this.stock = stock;
}
}
