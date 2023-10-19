package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;


@Service
public class EmployeeService implements IEmployeeService
{
	@Autowired
	private IEmployeeDAO employeeDAO;

	@Override
	public List<Employee> fetchEMployeesByJob(String job1, String job2, String job3) throws Exception 
	{
		System.out.println("EmployeeService.fetchEMployeesByJob()");
		
		List<Employee> list = employeeDAO.getEmployeesByDesg(job1, job2, job3);
		
		return list;
	}//method

}//class
