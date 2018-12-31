package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="User2")
@Table(name="User2")
public class UserDetails {

@Id
String username;
String password;
String confirmpassword;
private boolean enabled=true;
String role;

String customerName;
String mobileno;
String emailid;
String address;

public String getUsername() 
{
	return username;
}

public void setUsername(String username) 
{
	this.username = username;
}

public String getPassword() 
{
	return password;
}

public void setPassword(String password) 
{
	this.password = password;
}

public String getConfirmPassword() 
{
	return confirmpassword;
}

public void setConfirmPassword(String confirmpassword) 
{
	this.confirmpassword = confirmpassword;
}

public boolean isEnabled() 
{
	return enabled;
}

public void setEnabled(boolean enabled) 
{
	this.enabled = enabled;
}

public String getRole() 
{
	return role;
}

public void setRole(String role) 
{
	this.role = role;
}

public String getCustomerName() 
{
	return customerName;
}

public void setCustomerName(String customerName) 
{
	this.customerName = customerName;
}

public String getMobileno() 
{
	return mobileno;
}

public void setMobileno(String mobileno) 
{
	this.mobileno = mobileno;
}

public String getEmailid() 
{
	return emailid;
}

public void setEmailid(String emailid) 
{
	this.emailid = emailid;
}

public String getAddress() 
{
	return address;
}

public void setAddress(String address) 
{
	this.address = address;
}
}
