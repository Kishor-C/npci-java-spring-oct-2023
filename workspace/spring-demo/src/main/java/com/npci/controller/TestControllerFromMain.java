package com.npci.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.npci.beans.Employee;
import com.npci.dao.EmployeeDao;
import com.npci.service.EmployeeService;

public class TestControllerFromMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-orm-beans.xml");
		// controller depends on service
		EmployeeService service = (EmployeeService)context.getBean("service");
		// call all the methods of service
		// 1. createEmployees, 2. createEmployee, 3. findEmployees
		// 4. findEmployee, 5. findEmployeesByname, 6. deleteEmployee
		
		// call createEmployees
		List<Integer> ids = service.createEmployees(
				new Employee(0, "X", 3200), 
				new Employee(0, "Y", 4000));
		System.out.println(ids);
		// call other methods 
	}
}
