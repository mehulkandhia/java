package com.dao;

import java.util.List;

import com.model.Category;

public interface catdao {

	public boolean add(Category model);
	public boolean update(Category model);
	public boolean delete(Category model);
	List<Category> ListCategories();
	
	public Category getmodel(int categoryid);
	
}
