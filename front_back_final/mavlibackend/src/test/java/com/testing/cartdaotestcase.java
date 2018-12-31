package com.testing;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.cartdao;
import com.model.Cart;


public class cartdaotestcase {

	private static AnnotationConfigApplicationContext context;
	private static cartdao productcart1;
	
	@BeforeClass
	public static void ExecuteFirst()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		productcart1=(cartdao) context.getBean("productcart2");
	}
	
	@Ignore
	@Test
	public void addCartTest()
	{
		Cart cart=new Cart();
		//model.setCategoryid(1);
		
		cart.setProductid(1003);
		cart.setProductname("Vivo V9 pro");
		cart.setQuantity(1);
		cart.setUsername("Vivo");
		cart.setPrice(15990);
		cart.setStatus("N");
		//cart.setUsername("Vivo");
		assertTrue("problem in adding this category",productcart1.add(cart));
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Cart cart=productcart1.getCartItem(4);
		//model.setCategorydesc(categorydesc);
		//model.setCategoryname("FlowerPot");
		cart.setQuantity(3);
		assertTrue("problem in adding this category",productcart1.update(cart));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Cart cart=productcart1.getCartItem(4);
		assertTrue("problem in adding this category",productcart1.delete(cart));
	}
	
	//@Ignore
	@Test
	public void listCart()
	{
		List<Cart> ListCart=productcart1.listCartItems("vivo");
		assertTrue("problem in adding this category",ListCart.size()>0);
		
		for(Cart cart:ListCart)
		{
			System.out.println("Cart ID:" +cart.getCartid());
			System.out.println("Cart Price:" +cart.getPrice());
			System.out.println("Product Name:" +cart.getProductname());
		}

	}
}
