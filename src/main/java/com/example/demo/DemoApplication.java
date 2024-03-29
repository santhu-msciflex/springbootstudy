package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	public ComponentDemo componentDemo;
	
	private void testMethod() {
		componentDemo.print();
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		context.getBean(DemoApplication.class).testMethod();
		System.out.println("...finished...");
	}

}
