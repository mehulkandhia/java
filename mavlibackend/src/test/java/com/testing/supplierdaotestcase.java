package com.testing;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.supplierdao;
import com.model.supplier;

public class supplierdaotestcase {

	private static supplierdao supdao;
	@BeforeClass
	public static void executeFirst()
	{
		 AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		supdao=(supplierdao) context.getBean("supplying");
	}
	
	@Test
	@Ignore
	public void addSupplierTest()
	{
		supplier supply=new supplier();
		//model.setCategoryid(1);
		
		supply.setSupplierName("Flowervase");
		supply.setSupplierAddr("Andy flower");
		assertTrue("problem in adding this category",supdao.add(supply));
	}
	
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		supplier supply=supdao.getmodel(65);
		//model.setCategorydesc(categorydesc);
		//model.setCategoryname("FlowerPot");
		supply.setSupplierAddr("Wash basin and front glasses");
		assertTrue("problem in adding this category",supdao.update(supply));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		supplier supply=supdao.getmodel(65);
		assertTrue("problem in adding this category",supdao.delete(supply));
	}
	
	//@Ignore
	@Test
	public void listCategoriesTest()
	{
		List<supplier> ListCategory=supdao.supply();
		assertTrue("problem in adding this category",ListCategory.size()>0);
		
		for(supplier supply:ListCategory)
		{
			System.out.println("Category id:" +supply.getSupplierId());
			System.out.println("Category Name:" +supply.getSupplierName());
			System.out.println("Category desc:" +supply.getSupplierAddr());
		}

	}
}
