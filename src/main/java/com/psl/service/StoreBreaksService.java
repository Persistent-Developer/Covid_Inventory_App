package com.psl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.dao.IStoreBreaksDao;
import com.psl.entity.StoreBreaks;

@Service
public class StoreBreaksService {
	
	@Autowired
	private IStoreBreaksDao dao;
	
	public void addStoreBreak(StoreBreaks sb)
	{
		dao.save(sb);
	}
	
	public StoreBreaks getStoreBreaks(int id)
	{
		return dao.findById(id).get();
	}
	
}
