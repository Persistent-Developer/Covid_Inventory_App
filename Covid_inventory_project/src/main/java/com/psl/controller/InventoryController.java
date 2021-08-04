package com.psl.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}
