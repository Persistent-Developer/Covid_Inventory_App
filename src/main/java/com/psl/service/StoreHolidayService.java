package com.psl.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.psl.dao.IStoreHolidayDao;
import com.psl.entity.StoreHoliday;

@Service
public class StoreHolidayService {

	@Autowired
	private IStoreHolidayDao dao;
	
	
	public void addStoreHoliday(StoreHoliday sh)
	{
		dao.save(sh);
	}
	

	public StoreHoliday getStoreHoliday(int id)
	{
		return dao.findById(id).get();
	}
}
