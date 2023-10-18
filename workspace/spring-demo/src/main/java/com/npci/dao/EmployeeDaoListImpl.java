package com.npci.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.npci.beans.Employee;

public class EmployeeDaoListImpl implements EmployeeDao {
	
	private List<Employee> inMemory;
	public EmployeeDaoListImpl() {
		inMemory = new ArrayList<>(); 
	}
	// auto-generate the id using the size of the List
	public Employee save(Employee employee) {
		employee.setId(inMemory.size() + 1); // set the id based on the size
		inMemory.add(employee);
		return employee;
	}
	// using id search employee in the List
	public Employee findById(int id) {
		//return inMemory.stream().filter(item -> item.getId() == id).findAny().get();
		for(Employee employee: inMemory) {
			if(employee.getId() == id) {
				return employee;
			}
		}
		return null;
	}
	@Override
	public List<Employee> findAll() {
		return inMemory;
	}
	@Override
	public void delete(int id) {
		Iterator<Employee> iterator = inMemory.iterator();
		while(iterator.hasNext()) {
			Employee emp = iterator.next();
			if(emp.getId() == id) {
				iterator.remove();
				break;
			}
		}
	}
	
}
