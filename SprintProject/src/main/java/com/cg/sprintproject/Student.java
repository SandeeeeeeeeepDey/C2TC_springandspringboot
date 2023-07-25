package com.cg.sprintproject;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	private String roll;
	private String name;
	private String city;
	private String percentage;
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	
	public Student() {
		super();
	}
	public Student(String roll, String name, String city, String percentage) {
		super();
		this.roll = roll;
		this.name = name;
		this.city = city;
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", city=" + city + ", percentage=" + percentage
				+ ", getRoll()=" + getRoll() + ", getName()=" + getName() + ", getCity()=" + getCity()
				+ ", getPercentage()=" + getPercentage() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
