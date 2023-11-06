package com.properties.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "org.nit")
@Component("employee")
public class Employee 
{
	//simple properties
	private Integer eId;
	private String eName;
	private Double eSal;
	
	//arrays properties
	private String[] favFood;
	
	//collections
	private List<String> favPlaces;
	private Set<Long> phoneNo;
	
	//Map
	private Map<String,Object> idDetails;
	
	//Has-a properties
	private Company company;
	
}//class