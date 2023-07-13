package com.cg.usermodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsersService {
	
	@Autowired
	private UsersRepository userRepository;
	
	
	public void addUser(Users user) {
		userRepository.save(user);
	}
	
	public Users getUser(int id) {
		return userRepository.findById(id).get();
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	
	public Users getUserByName(String name) {
		return userRepository.findByName(name);
	}
	
	public Users getUserByPassword(String password) {
		return userRepository.findByPassword(password);
	}
	
}
