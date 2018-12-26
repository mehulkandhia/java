package com.testing;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.productdao;
import com.model.product;

public class productdaotestcase {
	
	private static productdao production;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		production=(productdao) context.getBean("production");
	}
	
	
	@Test
	public void addProductTest()
	{
		product prod=new product();
		//model.setCategoryid(1);
		
		prod.setProductname("Vivo V11");
		prod.setBrandname("Vivo");
		prod.setProductdesc("Nice Phone");
		prod.setSupplierid(1001);
		prod.setCategoryid(205);
		prod.setPrice(25990);
		prod.setStock(8);
		assertTrue("problem in adding this category",production.add(prod));
	}
	
	@Ignore
	@Test
	public void updateProductTest()
	{
		product prod=production.getproduct(69);
		prod.setProductdesc("Tidy Clothes");
		assertTrue("problem in adding this category",production.update(prod));
	}
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		product prod=production.getproduct(68);
		assertTrue("problem in adding this category",production.delete(prod));
	}
	
	@Test
	public void ListProductsTest()
	{
		List<product> ListProduct=production.ListProducts();
		assertTrue("problem in adding this category",ListProduct.size()>0);
		
		for(product prod:ListProduct)
		{
			System.out.println("Product id:" +prod.getProductid());
			System.out.println("Product Name:" +prod.getProductname());
			System.out.println("Brand Name:" +prod.getBrandname());
			System.out.println("Product desc:" +prod.getProductdesc());
			
			System.out.println("Supplier id:" +prod.getSupplierid());
			System.out.println("Category id:" +prod.getCategoryid());
			System.out.println("Price:" +prod.getPrice());
			System.out.println("Stock:" +prod.getStock());
		}
	}
}
