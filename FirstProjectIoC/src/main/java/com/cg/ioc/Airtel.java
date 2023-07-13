package com.cg.ioc;

public class Airtel implements Sim {

	@Override
	public void call() {
		System.out.println("Airtel");
		
	}

	@Override
	public void data() {
		System.out.println("Data Airtel");
		
	}

}
