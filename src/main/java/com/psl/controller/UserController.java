package com.psl.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.psl.entity.User;
import com.psl.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	

	
//---------------------------------------------------------------------------	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id)
	{
		return service.getUser(id);
	}

	
//---------------------------------------------------------------------------	
	@PostMapping("/user")
	public void addUser(@RequestBody User user)
	{
		service.addUser(user);
	}
	
//---------------------------------------------------------------------------	
		
//	@PostMapping("/user/upload")
//	  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
//	  {
//	    String message = "";
//	
//	    if (userExcel.hasExcelFormat(file)) {
//	      try {
//	        System.out.println("--------------going inside -------");
//	        service.save(file);
//	
//	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
//	        return ResponseEntity.status(HttpStatus.OK).body(message);
//	        
//	      } catch (Exception e) {
//	        
//	    	message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
//	      
//	      }
//	    
//	  }
//	
//	    message = "Please upload an excel file!";
//	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
//	  }

//---------------------------------------------------------------------------	
	
	@PostMapping("/user/uploadFile")
    public List<User> uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file) {
		try {
			service.store(file);
			
		} catch (Exception e) {
			
		}
		List<User> uList = service.getAllUser();
		
		//return "file updated succesfully";
		//return service.getAllUser();
		return uList;
	}

}

