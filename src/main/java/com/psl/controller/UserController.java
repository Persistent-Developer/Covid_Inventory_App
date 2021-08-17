package com.psl.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
		return service.deleteUserById(id);
	}

//---------------------------------------------------------------------------

	@PutMapping("/users/{id}")
	public String updateUserById(@RequestBody User user,@PathVariable int id)
	{
		return service.updateUserById(user,id);
	}


//---------------------------------------------------------------------------


	@PostMapping("/user/uploadFile")
    public List<User> uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file) {
		try {
			service.store(file);

		} catch (Exception e) {

		}
		List<User> uList = service.getAllUser();

		//return "file updated succesfully";
		//return service.getAllUser();
		return uList;
	}

	@PostMapping("/user/change/emailid/{id}")
	public String changeEmail(@RequestBody ObjectNode objectNode,@PathVariable int id)
	{
		String oldEmail = objectNode.get("Old Email").asText();
		String newEmail = objectNode.get("New Email").asText();
		return service.changeEmailId(oldEmail,newEmail, id);
	}

}
