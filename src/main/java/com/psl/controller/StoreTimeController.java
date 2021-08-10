package com.psl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.psl.entity.StoreTime;
import com.psl.service.StoreTimeService;

@RestController
public class StoreTimeController {
	
	@Autowired
	private StoreTimeService service;

	@PostMapping("/storeTime")
	public void addStoreTime(@RequestBody StoreTime s) {
		service.addStoreTime(s);
	}
	
	
	@GetMapping("/storetime/{id}")
	public StoreTime getStoreTime(@PathVariable int id)
	{
		return service.getStoreTime(id);
	}

}
