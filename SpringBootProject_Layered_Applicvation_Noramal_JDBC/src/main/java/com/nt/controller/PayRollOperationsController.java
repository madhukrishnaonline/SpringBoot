package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

@Controller("payroll")
public class PayRollOperationsController 
{
	@Autowired
	private IEmployeeService iEmployeeService;
	
	public List<Employee> displayEmployeesByJob(String job1,String job2,String job3) throws Exception
	{
		System.out.println("PayRollOperationsController.displayEmployeesByJob()");
		
		List<Employee> list = iEmployeeService.fetchEMployeesByJob(job1, job2, job3);
		return list;
	}//method
}//class
