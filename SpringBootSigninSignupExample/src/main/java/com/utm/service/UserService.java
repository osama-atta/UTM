package com.utm.service;

import com.utm.model.User;

public interface UserService {
	
	public User findUserByEmail(String email);
	
	public void saveUser(User user);
	
}
