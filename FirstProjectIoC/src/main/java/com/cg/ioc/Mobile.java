package com.cg.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {

	public static void main(String[] args) {
		ApplicationContext app= new ClassPathXmlApplicationContext("Beans.xml");
		
		Sim sim=app.getBean(Sim.class, "sim");
		sim.call();
		sim.data();

	}

}
