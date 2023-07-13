package com.cg.usermodule;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
	
	// Properties
	@Id
	private int id;
	private String name;
	private String type;
	private String password;
	
	// Constructors
	public Users() {
	}

	public Users(int id, String name, String type, String password) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.password = password;
	}

	// Getters Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// toString
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", type=" + type + ", password=" + password + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getType()=" + getType() + ", getPassword()=" + getPassword()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}
