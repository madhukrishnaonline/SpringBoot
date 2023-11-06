package com.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.properties.sbeans.Employee;

@SpringBootApplication
public class SpringBootProjectCollectionsConfigurationPropertiesApplication {

	public static void main(String[] args) 
	{
		//get IOC Container
		ApplicationContext context = SpringApplication.run(SpringBootProjectCollectionsConfigurationPropertiesApplication.class, args);
		
		Employee emp = context.getBean("employee",Employee.class);
		System.out.println(emp);
	}//main
}//class