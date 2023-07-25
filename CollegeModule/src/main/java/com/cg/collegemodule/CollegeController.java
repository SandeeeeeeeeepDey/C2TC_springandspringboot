package com.cg.collegemodule;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollegeController {
	
	@Autowired
	private CollegeService service;
	
	//retrieve all
	
	@GetMapping("/college")
	public List<College> list(){
		return service.listAll();
	}

	
	//retrieve by id
	@GetMapping("/college/{id}")
	public ResponseEntity<College> searchCollege(@PathVariable Long id){
	
		try {
		College college = service.get(id);
		return new ResponseEntity <College>(college,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
	}
	}
	
	
		//create 
		@PostMapping("/college")
		public void addCollege(@RequestBody College college) {
			service.save(college); 
		}
		
		//update
		@PutMapping("/college/{id}")
		public ResponseEntity<?> updateCollege (@RequestBody College college , @PathVariable Long id){
			try
			{
				College existcollege  = service.get(id);
			
			service.save(college);
			return new ResponseEntity<>(HttpStatus.OK);
			}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}
		
		
		
//		@PutMapping("/college/placement/{id}")
//		public ResponseEntity<College> shedulePlacement(@RequestBody College college,@PathVariable Long id){ 
//			try {
//				College existCollege = service.get(id);
//				service.save(college);
//				return new ResponseEntity<>(HttpStatus.OK);
//			} catch (Exception e) {
//				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}
//		}
	
		
		//Delete
		@DeleteMapping("college/{id}")
		public boolean deleteCollege(@PathVariable Long id) {
		try {
			//add this service.get in your code
			College existcollege  = service.get(id);
			service.delete(id);
			return true;
			
			
		}catch(NoSuchElementException e) {
			return false;
		}
		
		}
 }
