package com.cg.studentmodule;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	//create
	@PostMapping("/student/add")
	public Student addStudent (@RequestBody Student student){
		
		service.addStudent(student);
		return student;
	}
	
	//Search By Id
	@GetMapping("/student/{id}")
   public ResponseEntity<Student> searchStudentById(@PathVariable long id) {
		
		try
		{
			Student student = service.searchStudentById(id);
			return new ResponseEntity<Student>(student,HttpStatus.OK);
		} 
		catch (NoSuchElementException e) {
			
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/student")
	public List<Student> list(){
		return service.listAll();
	}
    
	//Search By HallticketNo 
	@GetMapping("/student/hall/{hallTicketNo}")
     public  ResponseEntity<Student> searchStudentByhallTicket(@PathVariable long hallTicketNo) {
		
		try
		{
			Student student = service.searchStudentByhallTicket(hallTicketNo);
			return new ResponseEntity<Student>(student,HttpStatus.OK);
		} catch (NoSuchElementException e) {

			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Update 
	@PutMapping("/student/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody Student student,@PathVariable long id){
		try {
			Student exitsStudent = service.searchStudentById(id);
			service.addStudent(student);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {

			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Update certificate
	@PutMapping("/student/certificate/{id}")
	public ResponseEntity<Student> updateCertificate(@RequestBody Student student,@PathVariable long id){
		try {
			Student exitsStudent = service.searchStudentById(id);
			service.addStudent(student);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {

			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Delete
	@DeleteMapping("/student/{id}")
	public boolean deleteStudent(@PathVariable long id) {
		
		try {
			Student existtudent = service.searchStudentById(id);
			service.deleteStudent(id);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
}
