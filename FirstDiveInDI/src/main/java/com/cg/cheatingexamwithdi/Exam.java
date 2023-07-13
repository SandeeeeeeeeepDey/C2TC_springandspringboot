package com.cg.cheatingexamwithdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		StudentOne sOne=context.getBean("sOne", StudentOne.class);
		sOne.cheating();
		StudentTwo sTwo=context.getBean("sTwo", StudentTwo.class);
		sTwo.cheating();

	}

}
