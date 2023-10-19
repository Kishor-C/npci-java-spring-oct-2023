package com.npci.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// import all the annotations from jakarta/javax.persistence package
@Entity
@Table(name = "employee")
public class Employee {
	/* @Column annotation is not required on any property
	 *  because property names are same as column names */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generates the id based on auto_increment
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "salary")
	private double salary;
	// 2 constructors, setters & getters
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
