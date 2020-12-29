package com.revature.dao;

import com.revature.models.User;

public interface UserDAO {
	
	public User getUserByUsername(String username);
	
}
