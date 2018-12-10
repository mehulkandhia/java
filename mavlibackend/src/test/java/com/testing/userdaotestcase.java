package com.testing;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.userdao;
import com.model.UserDetails;

public class userdaotestcase {

	public static userdao usdao;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		usdao=(userdao) context.getBean("userdao");
	}
	
	@Ignore
	@Test
	public void addUserTest()
	{
		UserDetails user=new UserDetails();
		user.setUsername("undefined");
		user.setPassword("Luck");
		user.setEnabled(false);
		user.setRole("slave");
		user.setCustomerName("PQR");
		user.setMobileno("981926718");
		user.setEmailid("lmn.m@gmail.com");
		user.setAddress("Mumbai");
		assertTrue("problem in adding this category",usdao.add(user));
	}
	
	@Ignore
	@Test
	public void updateUserTest()
	{
		UserDetails user=usdao.getuser(72);
		user.setUsername("Dear");
		assertTrue("problem in adding this category",usdao.update(user));
	}
	
	@Ignore
	@Test
	public void deleteUserTest()
	{
		UserDetails user=usdao.getuser(74);
		assertTrue("problem in adding this category",usdao.delete(user));
	}
	
	@Test
	public void ListUsersTest()
	{
		List<UserDetails> user=usdao.users();
		assertTrue("problem in adding this category",user.size()>0);
		
		for(UserDetails users:user)
		{
			System.out.println("User Id:" +users.getUserid());
			System.out.println("User Name:" +users.getUsername());
			System.out.println("Password:" +users.getPassword());
			System.out.println("Enabled:" +users.isEnabled());
			System.out.println("Role:" +users.getRole());
			System.out.println("Customer Name:" +users.getCustomerName());
			System.out.println("MobileNo:" +users.getMobileno());
			System.out.println("Email id:" +users.getEmailid());
			System.out.println("Address:" +users.getAddress());
		}
	}
}
