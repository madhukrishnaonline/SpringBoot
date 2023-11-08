package com.nt.model;

import java.util.Date;

import lombok.Data;

@Data
public class Employee
{
	private Integer empNo;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hireDate;
	private Double sal;
	private Double comm;
	private Integer deptno;
}
