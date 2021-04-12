package com.utm.service;

import com.utm.model.User;

public interface UserService {
	
	public User findUserByEmail(String email);
	
	public User findUserById(Integer id);
	
	public void saveUser(User user);

	public User updateUserProfile(User user, Integer id);
	
	public User updateUserPassword(Integer id, String password);
	
}
