package com.cg.sprintproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowedHeaders="*", origins="http://localhost:4200")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/registerStudent")
	public Student registerStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}
	
	@GetMapping("/listStudents")
	public List<Student> listStudent(){
		return service.listStudents();
	}
	
	@DeleteMapping("/removeStudent")
	public void removeStudent(@RequestParam String roll) {
		service.removeStudent(roll);
	}
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}
	

}
