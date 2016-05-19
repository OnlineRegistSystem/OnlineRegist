package com.online.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.online.dao.UserMapper;
import com.online.model.User;
import com.online.service.UserService;

@Service
public class UserServiceImp implements UserService{
	@Resource
	private UserMapper userDao;

	public User findUserByName(String username) {
		// TODO Auto-generated method stub
	
		return userDao.selectByName(username);
	}

	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.selectByEmail(email);
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		 userDao.insert(user);
	}

	public void updateUser(User user) {
		userDao.updateByPrimaryKey(user);
		// TODO Auto-generated method stub
		
	}

	public User findById(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKey(userId);
	}

}
