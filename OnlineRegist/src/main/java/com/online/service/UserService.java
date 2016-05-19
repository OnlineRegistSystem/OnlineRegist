package com.online.service;

import com.online.model.User;

public interface UserService {
	
	public User findUserByName(String username);
	public User findUserByEmail(String email);
	public void addUser(User user);
	public void updateUser(User user);
	public User findById(Integer userId);

}
