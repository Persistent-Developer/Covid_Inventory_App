package com.psl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.dao.UserDAO;
import com.psl.entity.User;

@Service("UserService")
public class UserService {

	@Autowired
	private UserDAO dao;
	
	public void addUser(User user)
	{
		dao.save(user);
	}
	
	public User getUser(int id)
	{
		return dao.findById(id).get();
	}
	
}
