package com.utm.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.utm.model.Role;
import com.utm.model.User;
import com.utm.repository.RoleRepository;
import com.utm.repository.UserRepository;
	
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findByRole("EMPLOYEE");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		user.setAddress(user.getAddress());//trying to implement address in user save
		userRepository.save(user);
	}

	@Override
	public User findUserById(Integer id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User updateUserProfile(User user, Integer id) {
		User dbUser = findUserById(id);
		dbUser.setFirstname(user.getFirstname());
		dbUser.setLastname(user.getLastname());
		dbUser.setEmail(user.getEmail());
		dbUser.setAddress(user.getAddress());
		return userRepository.save(dbUser);
	}

	

}
