package org.hibernate.fraction.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.userdao;
import com.model.UserDetails;

@Controller
public class UserController {

	@Autowired
	userdao udao;
	
	boolean flag=true;
	
	@RequestMapping(value="/login_success")
	public String loginSuccess(HttpSession session,Model m)
	{
		String test="";
		boolean loggedin=false;
		SecurityContext s=SecurityContextHolder.getContext();
		Authentication a=s.getAuthentication();
		
		String username=a.getName();
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)a.getAuthorities();
		//PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	//	String encoded = new BCryptPasswordEncoder();
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			if(role.getAuthority().equals("Role_Admin"))
			{
				loggedin=true;
				test="AdminHome";
				session.setAttribute("loggedin", loggedin);
				session.setAttribute("username", username);
				//session.setAttribute("password", encoder.encode("Admin"));
			}
			else
			{
				loggedin=true;
				test="UserHome";
				session.setAttribute("loggedin", loggedin);
				session.setAttribute("username", username);
				//session.setAttribute("password", encoder.encode("Namrata4#"));
			}
		}
		return test;
	}
	
	
	@RequestMapping(value="/login")
	public String showLoginPage(Model m)
	{
		UserDetails user=new UserDetails();
		m.addAttribute("user",user);
		m.addAttribute("userClickPerformLogin", true);
		return "login1";
	}
}
