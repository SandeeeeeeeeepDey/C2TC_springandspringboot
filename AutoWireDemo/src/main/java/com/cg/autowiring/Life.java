package com.cg.autowiring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Life {

	public static void main(String[] args) {
		ApplicationContext con=new ClassPathXmlApplicationContext("Beans.xml");
		Body body=con.getBean("body",Body.class);
		body.work();

	}

}
