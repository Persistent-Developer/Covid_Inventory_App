package com.psl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.psl.entity.User;
import com.psl.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	

	
//---------------------------------------------------------------------------	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id)
	{
		return service.getUser(id);
	}

	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return service.getAllUsers();
	}
	
	@GetMapping("/user/customers")
	public List<User> getAllCustomers()
	{   
		return service.getAllCustomers();
	}
	
//---------------------------------------------------------------------------	
	@PostMapping("/user/register")
	public void addUser(@RequestBody User user)
	{
		service.addUser(user);
	}

//---------------------------------------------------------------------------	

	@DeleteMapping("/users/{id}")
	public String deleteUserById(@PathVariable int id)
	{
		try {
		    return service.deleteUserById(id);
	    }
		
	    catch (Exception e) {
		    return "Deletion unsuccessful as user id "+ id + " is not found" ;
		}
		
	}
	
//---------------------------------------------------------------------------	

	@PatchMapping("/users/{id}")
	public String updateUserById(@RequestBody User user,@PathVariable int id)
	{ 
		try {
			return service.updateUserById(user,id);
		}
		
	    catch (Exception e) {
		  return "Updation unsuccessful as user id "+ id + " is not found" ;
	    }
	}
	
	
//---------------------------------------------------------------------------	

	
	@PostMapping("/user/uploadFile")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file) {
		try {
			service.store(file);
			System.out.println("fas");
			
		} catch (Exception e) {
			
		}
		
		return "file updated succesfully ";
		
	}
	
	@PostMapping("/user/change/emailid/{id}")
	public String changeEmail(@RequestBody ObjectNode objectNode,@PathVariable int id) 
	{	String str="";
		String oldEmail = objectNode.get("Old Email").asText();
		String newEmail = objectNode.get("New Email").asText();
		try {
		str =  service.changeEmailId(oldEmail,newEmail, id);
		}
		    catch (Exception e) {
			return "Password Updation unsuccessful as user id "+ id + " is not found";		
		}
		return str;
	}

	@PostMapping("/user/change/password/{id}")
	public String changePassword(@RequestBody ObjectNode objectNode,@PathVariable int id) 
	{
		String str="";
		String oldPassword = objectNode.get("Old Password").asText();
		String newPassword = objectNode.get("New Password").asText();
		try {
			 str = service.changePassword(oldPassword,newPassword, id);
		
		} catch (Exception e) {
		return "Password Updation unsuccessful as user id "+ id + " is not found";		
	  
	  }
	  return str;
	}
}

