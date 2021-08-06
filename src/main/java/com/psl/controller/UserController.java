package com.psl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.psl.entity.Role;
import com.psl.entity.User;
import com.psl.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id)
	{
		return service.getUser(id);
	}
	
	@PostMapping("/user")
	public void addUser(@RequestBody User user)
	{
		service.addUser(user);
	}
}

