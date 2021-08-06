package com.psl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.dao.IStoreDao;
import com.psl.dao.IStoreTimeDao;
import com.psl.entity.Store;
import com.psl.entity.StoreTime;

@Service
public class StoreTimeService {

	@Autowired
	private IStoreTimeDao dao;
	
	public void addStoreTime(StoreTime st)
	{
		dao.save(st);
	}
	
	public StoreTime getStoreTime(int id)
	{
		return dao.findById(id).get();
	}
}
