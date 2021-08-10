package com.psl.service;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.psl.dao.IUserDAO;
import com.psl.entity.Role;
import com.psl.entity.User;


@Service("UserService")
public class UserService {

	@Autowired
	private IUserDAO dao;
	
	
	public void addUser(User user)
	{
		Role role = user.getRole();
		if(role.getRoleId()== 1) {
			role.setRoleName("Admin");
		}
		else if(role.getRoleId()== 2) {
			role.setRoleName("Aggregator");
		}
		else if(role.getRoleId()== 3) {
			role.setRoleName("Customer");
		}

		dao.save(user);
	}
	
	public User getUser(int id)
	{
		return dao.findById(id).get();
	}
	
//    public void save(MultipartFile file)
//    {
//	   
//      try {
//	      List<User> users = userExcel.excelToUsers(file.getInputStream());
//	      System.out.println("----------returning from userExcel -----");
//	      System.out.println(users);
//	      dao.saveAll(users);
//	    
//	    } catch (IOException e) {
//	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
//	    }
//	  }

}
