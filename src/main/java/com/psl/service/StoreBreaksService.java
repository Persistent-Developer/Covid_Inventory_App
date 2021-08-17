package com.psl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.dao.IStoreBreaksDao;
import com.psl.entity.Inventory;
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
	
	public List<String> getAllStartBreaks(int id)
	{
		return dao.getAllStartBreaks(id);
	}
	
	public List<String> getAllEndBreaks(int id)
	{
		return dao.getAllEndBreaks(id);
	}
	
}
