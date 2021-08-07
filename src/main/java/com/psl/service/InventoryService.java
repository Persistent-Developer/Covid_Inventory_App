package com.psl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.dao.IInventoryDao;
import com.psl.entity.Inventory;

@Service("service")
public class InventoryService {

	@Autowired
	private IInventoryDao dao;
	
	public void addProducts(Inventory i)
	{
		dao.save(i);
	}
	
	public Inventory getProducts(int id)
	{
		return dao.findById(id).get();
	}
	
	public void removeProducts(int id)
	{
		dao.deleteById(id);
	}
	
	public void updateProducts(Inventory i)
	{
		dao.save(i);
	}
}
