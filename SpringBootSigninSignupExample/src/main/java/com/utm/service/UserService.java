package com.utm.service;

import com.utm.model.User;

public interface UserService {
	
	public User findUserByEmail(String email);
	
	public User findUserById(Long id);
	
	public void saveUser(User user);

	
	
}
