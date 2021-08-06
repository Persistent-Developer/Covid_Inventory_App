package com.psl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.dao.ITimeSlots;
import com.psl.entity.TimeSlots;

@Service
public class TimeSlotsService {

	@Autowired
	private ITimeSlots dao;
	
	public void addTimeSlot(TimeSlots ts)
	{
		dao.save(ts);
	}
	
	public TimeSlots getTimeSlots(int id)
	{
		return dao.findById(id).get();
	}
}
