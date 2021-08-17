package com.psl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.dao.IStoreDao;
import com.psl.dao.IStoreTimeDao;
import com.psl.entity.StoreTime;

@Service
public class StoreTimeService {

	@Autowired
	private IStoreTimeDao dao;
	
	@Autowired
	private IStoreDao sdao;
	
	public void addStoreTime(StoreTime st)
	{
		dao.save(st);
	}
	
	public StoreTime getStoreTime(int id)
	{
		return dao.findById(id).get();
	}
	
//	public void getAllStoreSlots(int id) {
//		
//		String start = dao.getStoreStartTime(id);
//		System.out.println("start = " + start);
//		String end = dao.getStoreEndTime(id);
//	
//		end = Float.toString(Float.parseFloat(end) + 12);
//		System.out.println("end = " + end);
//		int duration = sdao.getStoreSlotDuration(id);
//		System.out.println("duration = " + duration);
//		
//		List<String> timeSlots = new ArrayList<>();
//		String curr = start;
//		while(Float.parseFloat(curr)<=Float.parseFloat(end)) {
//			timeSlots.add(curr);
//			//System.out.println("--");
//			curr = Float.toString(Float.parseFloat(curr) + duration/60);
//		}
//		
//		System.out.println(timeSlots);
//	}
}
