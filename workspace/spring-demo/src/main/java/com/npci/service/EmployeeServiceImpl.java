package com.npci.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import com.npci.beans.Employee;
import com.npci.dao.EmployeeDao;
import com.npci.exceptions.EmployeeNotFoundException;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao dao; // setter method to supply the object

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}
	
	@Override
	@Transactional
	public List<Integer> createEmployees(Employee employee1, Employee... employees) {
		List<Integer> idList = new ArrayList<>();
		Employee e = dao.save(employee1);
		idList.add(e.getId());
		for(Employee emp : employees) {
			Employee e2 = dao.save(emp);
			idList.add(e2.getId());
		}
		return idList;
	}

	@Override
	@Transactional
	public Employee createEmployee(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public Employee findEmployee(int id) throws EmployeeNotFoundException {
		Employee employee = dao.findById(id);
		if(employee != null)
			return employee;
		throw new EmployeeNotFoundException("Id "+id+" not found");
	}

	@Override
	public List<Employee> findEmployees() {
		return dao.findAll();
	}

	@Override
	public List<Employee> findEmployeesByName(String name) {
		List<Employee> employees = findEmployees();
		// all employees are filtered by name and collected to a new list
		List<Employee> names = employees.stream()
				.filter(item -> item.getName().equals(name))
				.collect(Collectors.toList());
		return names;
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		Employee employee = findEmployee(id);
		dao.delete(employee.getId());
	}

	

}
