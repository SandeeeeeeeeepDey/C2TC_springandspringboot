package com.cg.collegemodule;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class College {
	
	//properties
	@Id
	private long id;
	private  String collegeadmin;
	private String collegename;
	private String location;
	
	//non parameterized constructor
	public College () {
	super();
	}
	
	//parameterized constructor
	public College(long id, String collegeadmin, String collegename, String location, String placement) {
		super();
		this.id = id;
		this.collegeadmin = collegeadmin;
		this.collegename = collegename;
		this.location = location;

	}
	
	//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCollegeadmin() {
		return collegeadmin;
	}

	public void setCollegeadmin(String collegeadmin) {
		this.collegeadmin = collegeadmin;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	//toString
	@Override
	public String toString() {
		return "College [id=" + id + ", collegeadmin=" + collegeadmin + ", collegename=" + collegename + ", location="
				+ location + ", getId()=" + getId() + ", getCollegeadmin()=" + getCollegeadmin() + ", getCollegename()="
				+ getCollegename() + ", getLocation()=" + getLocation() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}