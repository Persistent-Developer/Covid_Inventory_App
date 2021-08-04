package com.psl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.psl.entity.Inventory;
import com.psl.service.InventoryService;

@RestController
public class InventoryController {
	
	@Autowired
	private InventoryService service;
	
	@PostMapping("/inventory")
	public void addProducts(@RequestBody Inventory i)
	{
		service.addProducts(i);
	}
	
	@GetMapping("/inventory/{product_id}")
	public Inventory getProducts(@PathVariable int product_id)
	{
		return service.getProducts(product_id);
	}
}
