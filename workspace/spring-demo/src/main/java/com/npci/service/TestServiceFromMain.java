package com.npci.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.npci.beans.Employee;
import com.npci.dao.EmployeeDao;

public class TestServiceFromMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-orm-beans.xml");
		EmployeeDao employeeDao = (EmployeeDao)context.getBean("dao");
		// save two/three employee objects
		System.out.println("____ saving objects ____");
		employeeDao.save(new Employee(0, "A", 53000));
		employeeDao.save(new Employee(0, "B", 54000));
		employeeDao.save(new Employee(0, "C", 55000));
		System.out.println("____ finding an object by id ____");
		Employee employee = employeeDao.findById(2);
		if(employee != null) {
			System.out.println("Id = "+employee.getId()+
					", Name = "+employee.getName()+", Salary = "+employee.getSalary());
		}
		System.out.println("_______ finding all the entities _________");
		List<Employee> employees = employeeDao.findAll();
		employees.forEach(item -> System.out.println("Id = "+item.getId()));
	}
}
