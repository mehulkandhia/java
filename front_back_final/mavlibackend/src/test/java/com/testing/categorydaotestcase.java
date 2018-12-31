package com.testing;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.catdao;
import com.model.Category;

public class categorydaotestcase {

	private static AnnotationConfigApplicationContext context;
	//private static UserDetailsDao userdao;
	//private Model model;
	
	private static catdao categories;
	@BeforeClass
	public static void executeFirst()
	{
		 context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		categories=(catdao) context.getBean("categories");
	}
	
	@Test
	
	public void addCategoryTest()
	{
		Category model=new Category();
		//model.setCategoryid(1);
		
		model.setCategoryname("SmartPhone");
		model.setCategorydesc("High Demand");
		assertTrue("problem in adding this category",categories.add(model));
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category model=categories.getmodel(65);
		//model.setCategorydesc(categorydesc);
		//model.setCategoryname("FlowerPot");
		model.setCategorydesc("Wash basin and front glasses");
		assertTrue("problem in adding this category",categories.update(model));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category model=categories.getmodel(65);
		assertTrue("problem in adding this category",categories.delete(model));
	}
	
	//@Ignore
	@Test
	public void listCategoriesTest()
	{
		List<Category> ListCategory=categories.ListCategories();
		assertTrue("problem in adding this category",ListCategory.size()>0);
		
		for(Category model:ListCategory)
		{
			System.out.println("Category id:" +model.getCategoryid());
			System.out.println("Category Name:" +model.getCategoryname());
			System.out.println("Category desc:" +model.getCategorydesc());
		}

	}
}
