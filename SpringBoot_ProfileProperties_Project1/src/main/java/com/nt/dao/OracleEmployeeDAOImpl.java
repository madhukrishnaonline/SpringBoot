package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("oraEmpDAO")
@Profile({"uat","prod"})
public class OracleEmployeeDAOImpl implements IEmployeeDAO 
{

	private static final String QUERY = "SELECT*FROM EMP WHERE JOB IN(?,?,?) ORDER BY DEPTNO";
	
	@Autowired
	private DataSource dataSource;
	
	
	@Override
	public List<Employee> getEmployeesByDesg(String job1, String job2, String job3) throws Exception 
	{
		System.out.println("EmployeeDAOImpl.getEmployeesByDesg()--DataSource Class Name:: "+dataSource.getClass());
		
		List<Employee> list = null;
		//get pooled jdbc connection
		try(Connection con = dataSource.getConnection();
				//create preparedStatement object
			PreparedStatement stmt = con.prepareStatement(QUERY))
		{
			//set values to the query params
			stmt.setString(1, job1);
			stmt.setString(2, job2);
			stmt.setString(3, job3);
			//execute query
			try(ResultSet rs = stmt.executeQuery())
			{
				//copy record of ResultSet object to list of employee obj
				list = new ArrayList<Employee>();
				while(rs.next())
				{
					Employee employee = new Employee();
					employee.setEmpNo(rs.getInt(1));
					employee.setEname(rs.getString(2));
					employee.setJob(rs.getString(3));
					employee.setMgr(rs.getInt(4));
					employee.setHireDate(rs.getDate(5));
					employee.setSal(rs.getDouble(6));
					employee.setComm(rs.getDouble(7));
					employee.setDeptno(rs.getInt(8));
					
					//adding to list obj
					list.add(employee);
				}//while
			}//try2-with-resource
		}//try1-with-resource
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;     //Exception Propagation
		}//catch
		return list;
	}//method
}//class
