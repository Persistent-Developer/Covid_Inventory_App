package com.psl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.psl.entity.TimeSlots;
import com.psl.service.TimeSlotsService;

@Controller
public class TimeSlotsController {

	@Autowired
	private TimeSlotsService service;
	
	@PostMapping("/timeslots")
	public void addTimeSlots(@RequestBody TimeSlots ts)
	{
		service.addTimeSlot(ts);
	}
	
	@GetMapping("/timeslots/{id}")
	public TimeSlots getTimeSlots(@PathVariable int id)
	{
		return service.getTimeSlots(id);
	}
	
}
