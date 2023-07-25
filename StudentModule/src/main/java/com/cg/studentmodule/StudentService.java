package com.cg.studentmodule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	//Create
	public Student addStudent(Student student) {
		
		return studentRepository.save(student);
		
	}
	
	
	//Get By Id
    public Student searchStudentById(long id) {
		
		return studentRepository.findById(id).get();
		
	}
    
    //Get By HallTicket
    public Student searchStudentByhallTicket(long hallTicketNo) {
		
		return studentRepository.searchStudentByhallTicketNo(hallTicketNo);
		
	}
    
    //Delete By Id
    public void deleteStudent(long id) {
		
		studentRepository.deleteById(id);
	}
    
    public List<Student> listAll(){
    	return studentRepository.findAll();
    }
}
