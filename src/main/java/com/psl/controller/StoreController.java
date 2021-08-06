package com.psl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.psl.entity.Orders;
import com.psl.entity.Store;
import com.psl.service.StoreService;

@RestController
public class StoreController {
	
	@Autowired
	private StoreService service;

	@PostMapping("/store")
	public void addStore(@RequestBody Store s) {
		service.addStore(s);
	}
	
	
	@GetMapping("/store/{id}")
	public Store getStore(@PathVariable int id)
	{
		return service.getStore(id);
	}
}
