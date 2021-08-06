package com.psl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.psl.entity.StoreBreaks;
import com.psl.service.StoreBreaksService;

@RestController
public class StoreBreaksController {
	
	@Autowired
	private StoreBreaksService service;
	
	@PostMapping("/storebreak")
	public void addStoreBreaks(@RequestBody StoreBreaks sb)
	{
		service.addStoreBreak(sb);
	}
	
	@GetMapping("/storebreak/{id}")
	public StoreBreaks getStoreBreaks(@PathVariable int id)
	{
		return service.getStoreBreaks(id);
	}
}
