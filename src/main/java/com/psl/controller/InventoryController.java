package com.psl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.psl.entity.Inventory;
import com.psl.service.InventoryService;


@RestController
public class InventoryController {
	
	@Autowired
	private InventoryService service;
	
	@PostMapping("/inventory")
	public void addProducts(@RequestBody Inventory i)
	{
		service.addProducts(i);
	}
	
	@PostMapping("/inventory/uploadFile")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file/*, Model model*/) {
		try {
			service.store(file);
			//model.addAttribute("message", "File uploaded successfully!");
		} catch (Exception e) {
			//model.addAttribute("message", "Fail! -> uploaded filename: " + file.getOriginalFilename());
		}
		
		return "file updated succesfully ";
        
    }
	
	@GetMapping("/inventory/{product_id}")
	public Inventory getProducts(@PathVariable int product_id)
	{
		return service.getProducts(product_id);
	}
}
