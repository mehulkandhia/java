package com.dao;

import java.util.List;

import com.model.Cart;

public interface cartdao {

	public boolean add(Cart cart);
	public boolean update(Cart cart);
	public boolean delete(Cart cart);
	public Cart getCartItem(int cartid);
	public List<Cart> listCartItems(String username);
}
