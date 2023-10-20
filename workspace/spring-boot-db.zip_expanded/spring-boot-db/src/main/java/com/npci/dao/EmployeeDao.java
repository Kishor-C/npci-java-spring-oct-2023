package com.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.beans.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
 /*
  * Inherits below methods
  * T save(T t) >> Employee save(Employee t)
  * Optional<T> findById(ID id) >> Optional<Employee> findById(Integer id)
  * List<T> findAll() >> List<Employee> findAll()
  * void deleteById(ID id) >> void deleteById(Integer id)
  */
}
