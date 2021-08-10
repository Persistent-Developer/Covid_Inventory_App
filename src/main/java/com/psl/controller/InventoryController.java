package com.psl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.psl.entity.Inventory;
import com.psl.service.InventoryService;

import io.swagger.annotations.ApiOperation;


@RestController
public class InventoryController {
	
	@Autowired
	private InventoryService service;
	
	//Post single product into the inventory
	@PostMapping("/inventory")
	public ResponseEntity<Void> addProducts(@RequestBody Inventory i)
	{
		try {
			service.addProducts(i);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	//post productts using excel file
	@PostMapping("/inventory/uploadFile")
    public ResponseEntity<String> uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file/*, Model model*/) {
		try {
			service.store(file);
			return ResponseEntity.of(Optional.of("File uploaded successfully"));
			//model.addAttribute("message", "File uploaded successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			//model.addAttribute("message", "Fail! -> uploaded filename: " + file.getOriginalFilename());
		}    
    }
	
	
	//Update product in inventory
	@PutMapping("/inventory")
	public ResponseEntity<Void> updateProducts(@RequestBody Inventory i)
	{
		try {
			service.addProducts(i);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//Get all products
	@GetMapping("/inventory")
	public ResponseEntity<List<Inventory>> getAllProducts()
	{
		List<Inventory> list=service.getAllProducts();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(list));
	}

	
	//Get products based on their product id
	@GetMapping("/inventory/id")
	public ResponseEntity<Inventory> getProducts(@PathVariable(name="Prdouct_id") int id)
	{
		Inventory int1=null;
		
		try {
			int1=service.getProductsById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(int1==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(int1));
	}
	
	
	//Get products based on their product code
	@GetMapping("/inventory/product")
	public ResponseEntity<Inventory> getProducts(@RequestParam String product_code)
	{
		Inventory int1=null;
		
		try {
			int1=service.getProducts(product_code);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(int1==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(int1));	
	}
	
	
	//Get all categories based on store id
	@GetMapping("/inventory/categories")
	public ResponseEntity<List<String>> findAllbyID(@RequestParam int store_id)
	{
		List<String> list=service.findAll(store_id);
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	
	//Get all Groups based on store id
	@GetMapping("/inventory/groups")
	public ResponseEntity<List<String>> findAllGroups(@RequestParam int store_id)
	{
		List<String> list=service.findAllGroups(store_id);
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	
	//Get products based on categories
	@GetMapping("/inventory/category")
	public ResponseEntity<List<Inventory>> findAllbyproductid(@RequestParam(name="category_name") String name[])
	{
		List<Inventory> list=null;
		
		try {
		 list=service.findByCategory(name);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(list)); 
	}
	
	
	//To retrive products based on multiple values
	@GetMapping("/inventory/search")
	public ResponseEntity<List<Inventory>> findByMultipleValues(@RequestParam("product_name") String name,@RequestParam(name="category",required=false)String category[],@RequestParam(name="product_group",required=false)String group[],@RequestParam("store_id") int id)
	{
		List<Inventory> list= null;
		try {
			if(category!= null && group!=null)
			{
				list = service.findByMultipleValues1(name,category,group,id);		
			}
			else if(category==null && group!=null)
			{
				list = service.findByMultipleValues2(name,group,id);
			}
			else if(group==null && category!=null)
			{
				list = service.findByMultipleValues3(name,category,id);
			}
			else 
			{
				list = service.findByMultipleValues4(name,id);
			}		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(list));
	}
	
	
	//Remove particular product based on the product_id
	@DeleteMapping("/inventory/{id}")
	public ResponseEntity<Void> removeProducts(@PathVariable int id)
	{
		try{
			service.removeProducts(id);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	
}
