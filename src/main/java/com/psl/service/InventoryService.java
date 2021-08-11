package com.psl.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
	
	
	public void addProducts(Inventory i) throws Exception
	{
		dao.save(i);
	}
	
	public void updateProducts(Inventory i) throws Exception
	{
		int n1=i.getStock();
		System.out.println(n1);
		String code=i.getProduct_code();
		Inventory temp=dao.findByProduct_code(code);
		int n2=temp.getStock();
		System.out.println(n2);
		int n;
		n=n1+n2;
		i.setStock(n);
		dao.save(i);
	}
	
	
	public void store(MultipartFile file) {
		try {
			ExcelUtils util = new ExcelUtils();
			List<Inventory> lstInventorys = util.parseInventoryExcelFile(file.getInputStream());
			//System.out.println(lstInventorys);
    		// Save Customers to DataBase
    		dao.saveAll(lstInventorys);
        } catch (IOException e) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
	}
	

	public List<Inventory> getAllProducts() throws Exception
	{
		return dao.getAllProducts();
	}
	
	
	public Inventory getProducts(String code) throws Exception
	{
		return dao.findByProduct_code(code);
	}
	
	
	public Inventory getProductsById(int id) throws Exception
	{	
		return dao.findById(id).get();
	}
	
	
	public void removeProducts(int id) throws Exception
	{
		dao.deleteById(id);
	}
	
	public List<String> findAll(int id) throws Exception
	{
		return dao.findAllbyID(id);
	}
	
	public List<String> findAllGroups(int id) throws Exception
	{
		return dao.findAllGroups(id);
	}
	
	public List<Inventory> findByCategory(String name[]) throws Exception
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
	
	
	public List<Inventory> findByGroup(String name[]) throws Exception
	{
		List<Inventory> ilist=new ArrayList<>();
		
		for(String nam:name)
		{
			List<Inventory> list=dao.findByGroup(nam);
		
			for(Inventory i:list)
			{
				ilist.add(i);
			}
		}
		
		return ilist;	
	}
	
	public List<Inventory> findByMultipleValues1(String name,String category[],String group[],int id) throws Exception
	{
		List<Inventory> ilist=new ArrayList<>();
		
		for(String cat:category)
		{
			for(String grp:group)
			{
				List<Inventory> list=dao.findByMultipleValues1(name,cat,grp,id);
				
				for(Inventory i:list)
				{
					ilist.add(i);
				}
			}
		}
		return ilist;
	}
	
	
	public List<Inventory> findByMultipleValues2(String name,String group[],int id) throws Exception
	{
		List<Inventory> ilist=new ArrayList<>();
		
		for(String grp:group)
		{
			List<Inventory> list=dao.findByMultipleValues2(name,grp,id);
				
			for(Inventory i:list)
			{
				ilist.add(i);
			}
		}
		return ilist;
	}
	
	public List<Inventory> findByMultipleValues3(String name,String category[],int id) throws Exception
	{
		List<Inventory> ilist=new ArrayList<>();
		
		for(String cat:category)
		{
			List<Inventory> list=dao.findByMultipleValues3(name,cat,id);
				
			for(Inventory i:list)
			{
				ilist.add(i);
			}
		}
		return ilist;
	}
	
	public List<Inventory> findByMultipleValues4(String name,int id) throws Exception
	{
		return dao.findByMultipleValues4(name,id);
	}
	
	
}
