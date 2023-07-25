package com.cg.collegemodule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CollegeService {

	@Autowired
	private CollegeRepository repo;
	
	//retrieve
	
	public List<College> listAll() {
		return repo.findAll();
	}
	
	
	//retrieve by id
	
		public College get (Long id) {
			return repo.findById(id).get();
		}
		
		
		//create 
		
		public void save(College college) {
			repo.save(college );
		}
		
		
		//delete
		
		public void delete (Long id) {
			repo.deleteById(id);
			
		}
		
		
}
