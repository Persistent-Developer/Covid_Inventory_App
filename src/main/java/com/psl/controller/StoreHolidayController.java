package com.psl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.psl.entity.StoreHoliday;
import com.psl.entity.StoreTime;
import com.psl.service.StoreHolidayService;

@RestController
public class StoreHolidayController {
	
	@Autowired
	public StoreHolidayService service;
	
	@PostMapping("/storeHoliday")
	public void addStoreHoliday(@RequestBody StoreHoliday sh) {
		service.addStoreHoliday(sh);
	}
	
	
	@GetMapping("/storeHoliday/{id}")
	public StoreHoliday getStoreHoliday(@PathVariable int id)
	{
		return service.getStoreHoliday(id);
	}
	
	@GetMapping("/storeholiday/{id}")
	public List<String> getAllHoliday(@PathVariable int id)
	{
		return service.getAllholiday(id);
	}

}
