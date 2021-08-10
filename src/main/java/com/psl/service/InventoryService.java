package com.psl.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.psl.dao.IInventoryDao;
import com.psl.entity.Inventory;
import com.psl.util.ExcelUtils;

@Service("service")
public class InventoryService {

	@Autowired
	private IInventoryDao dao;
	
	public void addProducts(Inventory i)
	{
		dao.save(i);
	}
	
	public void store(MultipartFile file) {
		try {
			List<Inventory> lstInventorys = ExcelUtils.parseInventoryExcelFile(file.getInputStream());
			//System.out.println(lstInventorys);
    		// Save Customers to DataBase
    		dao.saveAll(lstInventorys);
        } catch (IOException e) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
	}
	
	public Inventory getProducts(String product_code)
	{
		return dao.findByProduct_code(product_code);
	}
	
	public void removeProducts(int id)
	{
		dao.deleteById(id);
	}
	
	public List<String> findAll(int id)
	{
		return dao.findAllbyID(id);
	}
	
	public List<Inventory> findByCategory(String name[])
	{
		List<Inventory> ilist=new ArrayList<>();
		
		for(String nam:name)
		{
			List<Inventory> list=dao.findByCategory(nam);
		
			for(Inventory i:list)
			{
				ilist.add(i);
			}
		}
		
		return ilist;
		
	}
}
