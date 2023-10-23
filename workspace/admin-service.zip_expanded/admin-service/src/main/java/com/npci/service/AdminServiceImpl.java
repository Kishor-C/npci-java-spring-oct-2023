package com.npci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminServiceImpl {

	@Autowired
	private RestTemplate rest;
	
	public String findingEmployee(int id) {
		String response = 
				rest.getForObject("http://EMPLOYEE-APP/api/employees/"+id, String.class);
		// here we need will get the response content, which can be changed to java types 
		// as rest.getForObjecdt(Url, Employee.class) - converts JSON to employee object
		return response;
	}
}
