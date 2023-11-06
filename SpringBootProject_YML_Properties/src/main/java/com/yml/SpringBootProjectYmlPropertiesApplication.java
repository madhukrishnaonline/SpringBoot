package com.yml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.yml.sbeans.Employee;

@SpringBootApplication
public class SpringBootProjectYmlPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootProjectYmlPropertiesApplication.class, args);
	   Employee employee = context.getBean("emp",Employee.class);
	   System.out.println(employee);
	}

}
