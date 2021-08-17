package com.psl.controller;

import java.util.List;

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
	
	@GetMapping("/storebreak/start/{id}")
	public List<String> getStoreStartBreaks(@PathVariable int id) {
		
		return service.getAllStartBreaks(id);
	}
	
	@GetMapping("/storebreak/end/{id}")
	public List<String> getStoreEndBreaks(@PathVariable int id) {
		
		return service.getAllEndBreaks(id);
	}
}
