package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO
{
	List<Employee> getEmployeesByDesg(String job1,String job2,String job3) throws Exception;
}