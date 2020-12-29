package com.revature.dao;

import java.util.HashMap;
import java.util.Map;

import com.revature.models.User;

public class UserDAOImpl implements UserDAO {
	
	static Map<String, User> users = new HashMap<String, User>();
	
	static {
		users.put("user", new User(1, "user", "password"));
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		User u = null;
		if(users.containsKey(username)) {
			u = users.get(username);
		}
		return u;
	}

}
