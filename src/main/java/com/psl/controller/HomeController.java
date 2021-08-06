package com.psl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping({"/home","/"})
	public String Hello()
	{
		return "Hello ... This is Home Page !!";
	}
	
}
