package com.cg.sprintproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {
@Autowired
private StudentRepository studentRepository;

public Student addStudent(Student student) {
	return studentRepository.save(student);
}

public List<Student> listStudents(){
	return studentRepository.findAll();
}

public void removeStudent(String roll) {
	studentRepository.deleteById(roll);
}

public Student updateStudent(Student student) {
	String roll=student.getRoll();
	Student newStudent=studentRepository.findById(roll).get();
	newStudent.setName(student.getName());
	newStudent.setCity(student.getCity());
	newStudent.setPercentage(student.getPercentage());
	return studentRepository.save(newStudent);
}
}
