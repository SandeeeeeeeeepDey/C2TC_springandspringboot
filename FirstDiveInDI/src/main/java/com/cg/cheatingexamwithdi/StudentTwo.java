package com.cg.cheatingexamwithdi;

public class StudentTwo {
	Cheat chit;
	public void cheating() {
		chit.initiate();
	}
	public Cheat getChit() {
		return chit;
	}
	public void setChit(Cheat chit) {
		this.chit = chit;
	}
}
