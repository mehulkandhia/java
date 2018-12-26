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
	
	
	@Test
	public void addUserTest()
	{
		UserDetails user=new UserDetails();
		user.setUsername("Lobe");
		user.setPassword("Robe");
		user.setEnabled(true);
		user.setRole("Role_User");
		user.setCustomerName("Java");
		user.setMobileno("9769241612");
		user.setEmailid("abc.m@yahoo.com");
		user.setAddress("Mumbai");
		assertTrue("problem in adding this category",usdao.add(user));
	}
	
	@Ignore
	@Test
	public void updateUserTest()
	{
		UserDetails user=usdao.getuser("mehul");
		user.setCustomerName("ashwin kandhia");
		assertTrue("problem in adding this category",usdao.update(user));
	}
	
	/*//@Ignore
	@Test
	public void deleteUserTest()
	{
		UserDetails user=usdao.getuser("");
		assertTrue("problem in adding this category",usdao.delete(user));
	}*/
	
	@Test
	public void ListUsersTest()
	{
		List<UserDetails> user=usdao.users();
		assertTrue("problem in adding this category",user.size()>0);
		
		for(UserDetails users:user)
		{
			
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
