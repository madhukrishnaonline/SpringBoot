package com.nt;

import java.beans.PropertyVetoException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayRollOperationsController;
import com.nt.model.Employee;

//@EnableConfigurationProperties(ExternalConfig.class)
@SpringBootApplication
public class SpringBootProfilesPropertiesProjectApplication {

	@Autowired
	Environment environment;

	@Bean("c3p0")
	@Profile("test")
	ComboPooledDataSource pooledDataSource() throws PropertyVetoException 
	{
		System.out.println("SpringBootProjectLayeredApplicvationNoramalJdbcApplication.pooledDataSource()");

		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(environment.getRequiredProperty("spring.datasource.driver-class-name"));
		dataSource.setJdbcUrl(environment.getRequiredProperty("spring.datasource.url"));
		dataSource.setUser(environment.getRequiredProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
		dataSource.setInitialPoolSize(Integer.parseInt(environment.getRequiredProperty("c3p0.minsize")));
		dataSource.setMaxPoolSize(Integer.parseInt(environment.getRequiredProperty("c3p0.maxsize")));

		return dataSource;
	}// ComboPooledDataSource

	public static void main(String[] args) {

		// get IOC Container
		ApplicationContext context = SpringApplication
				.run(SpringBootProfilesPropertiesProjectApplication.class, args);
		// get Controller Object
		PayRollOperationsController controller = context.getBean("payroll", PayRollOperationsController.class);
		// invoke b.Method
		try {
			List<Employee> employee = controller.displayEmployeesByJob("CLERK", "ANALYST", "MANAGER");

			employee.forEach(emp -> System.out.println(emp));
		} // try
		catch (Exception e) {
			e.printStackTrace();
			System.err.print("Internal Problem  --try Again :: " + e.getMessage());
		} // catch
			// Close IOC Container
		((ConfigurableApplicationContext) context).close();
	}// main

}// class
