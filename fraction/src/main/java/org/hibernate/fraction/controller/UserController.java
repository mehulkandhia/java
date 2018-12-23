package org.hibernate.fraction.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.userdao;
import com.model.UserDetails;

@Controller
public class UserController {

	@Autowired
	userdao udao;
	
	/*@Autowired
	private BCryptPasswordEncoder passwordEncoder;*/
	
	boolean flag=true;
	
	@RequestMapping(value="/login_success")
	public String loginSuccess(HttpSession session,Model m)
	{
		String page="";
		
		boolean loggedIn=false;
		
		SecurityContext securityContext=SecurityContextHolder.getContext();
		Authentication authentication=securityContext.getAuthentication();
		
		String username=authentication.getName();
		
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			
			if(role.getAuthority().equals("Role_Admin"))
			{
				loggedIn=true;
				page="AdminHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				loggedIn=true;
				page="UserHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			
		}
		
		return page;
	}
	
	@RequestMapping(value="/login1")
	public String showLoginPage()
	{
		return "login1";
	}
	
	@RequestMapping(value="/AddUser1")
	public String showUser(Model m)
	{
		System.out.println("JAva Code");
		/*List<Category> ListCategories=categories.ListCategories();
		//binding the listCategories and sending to jsp page
		m.addAttribute("ListCategories", ListCategories);*/ 
		return "signup";
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUserDetail(@RequestParam("username")String username,@RequestParam("password")String password,
			@RequestParam("customerName")String customerName,@RequestParam("mobileno")String mobileno,
			@RequestParam("emailid")String emailid,@RequestParam("address")String address,
			@RequestParam("role")String role,Model m)
	{
	UserDetails dat=new UserDetails();
	dat.setUsername(username);
	dat.setPassword(password);
	//dat.setPassword(passwordEncoder.encode(dat.getPassword()));
	dat.setCustomerName(customerName);
	dat.setMobileno(mobileno);
	dat.setEmailid(emailid);
	dat.setAddress(address);
	dat.setRole(role);
	
	udao.add(dat);
	/*List<Category> ListCategories=categories.ListCategories();
	//binding the listCategories and sending to jsp page
	m.addAttribute("ListCategories", ListCategories);*/
	//categories.add(cat);
	return "register_success";
	}
	
	/*@RequestMapping(value="/login")
	public String showLoginPage(Model m)
	{
		UserDetails user=new UserDetails();
		m.addAttribute("user",user);
		m.addAttribute("userClickPerformLogin", true);
		return "login1";
	}*/
}
