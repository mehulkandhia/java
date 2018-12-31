package com.dao;

import java.util.List;

import com.model.UserDetails;

public interface userdao {

	public boolean add(UserDetails user);
	public boolean update(UserDetails user);
	//public boolean delete(UserDetails user);
	public List<UserDetails> users();
	
	public UserDetails getuser(String username);
	//public UserDetails getuser(String username);
}
