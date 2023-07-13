package com.cg.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Body {
	Heart heart;
	
//	public Body(Heart heart) {
//		this.heart = heart;
//	}

	public void work() {
		heart.property();
		System.out.println("Number of hearts: "+heart.noOfHeart);
		System.out.println("Owner of heart: "+heart.ownerName);
	}

	public Heart getHeart() {
		return heart;
	}

	@Autowired
	@Qualifier("heartDavyJones")
	public void setHeart(Heart heart) {
		this.heart = heart;
	}
	
}
