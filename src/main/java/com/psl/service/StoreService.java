package com.psl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.psl.dao.IStoreDao;
import com.psl.entity.Store;

@Service
public class StoreService {
	
	@Autowired
	private IStoreDao dao;
	
	public void addStore(Store s)
	{
		dao.save(s);
	}
	
	public Store getStore(int id)
	{
		return dao.findById(id).get();
	}
}
