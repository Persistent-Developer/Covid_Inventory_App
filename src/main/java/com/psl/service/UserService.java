package com.psl.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.psl.dao.UserDAO;
import com.psl.entity.Role;
import com.psl.entity.User;
import com.psl.excelhelper.UserExcel;

@Service("UserService")
public class UserService {

	@Autowired
	private UserDAO dao;
	
	UserExcel userExcel = new UserExcel();

//---------------------------------------------------------------------------	
	
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

//---------------------------------------------------------------------------	
	public User getUser(int id)
	{
		return dao.findById(id).get();
	}
    
	public List<User> getAllUsers()
	{
		List<User> users = new ArrayList<User>();
		
		for(User user : dao.findAll())
			users.add(user);
		
		return users;
	}
	
	public List<User> getAllCustomers()
	{
		List<User> users = new ArrayList<User>();
		
		for(User user : dao.findAll()) {
			
			if((user.getRole()).getRoleId() == 3)
					users.add(user);
		}
		
		return users;
	}
//---------------------------------------------------------------------------	
	
	public String deleteUserById(int id)
	{
		try {
		User user = dao.findById(id).get();
		
		if(user.getUserId() == id)
			dao.deleteById(id);
		
        return "Deletion Successful";
		
		}
		catch (Exception e) {
			System.out.println("User with id "+ id + " is not found");
			
		return "Deletion unsuccessful as user id "+ id + " is not found" ;
		}
	}

//---------------------------------------------------------------------------	

	
    public void save(MultipartFile file)
    {
	   
      try {
	      List<User> users = userExcel.excelToUsers(file.getInputStream());
	      System.out.println("----------returning from userExcel -----");
	      System.out.println(users);
	      dao.saveAll(users);
	    
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }
//---------------------------------------------------------------------------	

	public String updateUserById(User user, int id) {
		try {
			User user1 = dao.findById(id).get();
			
			if(user1.getUserId() == id)
				dao.save(user);
			
	        return "updation Successful";
			
			}
			catch (Exception e) {
				System.out.println("User with id "+ id + " is not found");
				
			return "Updation unsuccessful as user id "+ id + " is not found" ;
			}
		
	}
	
	
	
}
