package com.npci.service;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npci.beans.Employee;
import com.npci.dao.EmployeeDao;
import com.npci.exceptions.EmployeeNotFoundException;

@Service("service") // id = service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao dao; // setter method to supply the object
	// in old EmployeeDao we had created our own methods which won't work
	@Override
	
	public List<Integer> createEmployees(Employee employee1, Employee... employees) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Employee createEmployee(Employee employee) {
		// save() method of JpaRepository
		return dao.save(employee);
	}

	@Override
	public Employee findEmployee(int id) throws EmployeeNotFoundException {
		// findById() method of JpaRepository
		// import java.util.Optional
		Optional<Employee> op = dao.findById(id);
		// below code either returns employee or throws EmployeeNotFoundException
		return op.orElseThrow(() -> new EmployeeNotFoundException("id "+id+" not found"));
	}

	@Override
	public List<Employee> findEmployees() {
		return dao.findAll();
	}

	@Override
	public List<Employee> findEmployeesByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		
	}

	
	
}
