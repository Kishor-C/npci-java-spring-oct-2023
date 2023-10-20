package com.npci.service;

import java.util.List;

import com.npci.beans.Employee;
import com.npci.exceptions.EmployeeNotFoundException;

public interface EmployeeService {
	// stores multiple employee objects - remove @Transactional in DAO
	List<Integer> createEmployees(Employee employee1, Employee... employees);
	Employee createEmployee(Employee employee);
	Employee findEmployee(int id) throws EmployeeNotFoundException;
	List<Employee> findEmployees();
	List<Employee> findEmployeesByName(String name);
	void deleteEmployee(int id) throws EmployeeNotFoundException;
}
/*
 * Implement this interface and supply the EmployeeDao
 */
