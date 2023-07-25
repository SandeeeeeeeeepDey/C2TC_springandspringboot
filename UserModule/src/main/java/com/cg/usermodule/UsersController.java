package com.cg.usermodule;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
public class UsersController {

	@Autowired
	private UsersService service;
	
	@PostMapping("/user/add")
	public ResponseEntity<Users> addUsers(@RequestBody Users user) {
		try{
			service.addUser(user);
			return new ResponseEntity<Users>(user, HttpStatus.OK);
		}
		catch (DataIntegrityViolationException e){
			return new ResponseEntity<Users>(HttpStatus.CONFLICT);
		}
}
	
	@PutMapping("/user/update/{id}")
	public ResponseEntity<Users> updateUser(@RequestBody Users user, @PathVariable int id) {
		try {
			Users existuser=service.getUser(id);
			service.addUser(user);
			return new ResponseEntity<Users>(user,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/user/login/{name}/{password}")
	public ResponseEntity<Users> login(@PathVariable String name, @PathVariable String password) {
		try {
			Users existuserbyname=service.getUserByName(name);
			Users existuserbypassword=service.getUserByPassword(password);
			if(existuserbyname != null && existuserbypassword != null &&existuserbyname.equals(existuserbypassword)) return new ResponseEntity<Users>(existuserbypassword,HttpStatus.OK);
			else throw new NoSuchElementException();
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/user")
	public List<Users> list(){
		return service.listAll();
	}
	
	@PostMapping("user/logout")
	public ResponseEntity<?> logOut() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
