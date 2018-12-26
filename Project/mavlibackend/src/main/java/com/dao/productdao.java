package com.dao;

import java.util.List;

import com.model.product;

public interface productdao {

	public boolean add(product prod);
	public boolean update(product prod);
	public boolean delete(product prod);
	List<product> ListProducts();
	
	public product getproduct(int productid);
}
