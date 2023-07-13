
package com.cg.autowiring;

public class Heart {
	String noOfHeart;
	String ownerName;
	public void property() {
		System.out.println("Heart is Beating ___il|li_ili___");	
	}
	
	public String getNoOfHeart() {
		return noOfHeart;
	}

	public void setNoOfHeart(String noOfHeart) {
		this.noOfHeart = noOfHeart;
	}

	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
}
