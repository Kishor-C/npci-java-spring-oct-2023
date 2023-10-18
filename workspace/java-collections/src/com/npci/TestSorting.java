package com.npci;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
class Xyz implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return Double.compare(o1.getSalary(), o2.getSalary());
	}
	
	
}
public class TestSorting {
	public static void main(String[] args) {
		// TreeSet looks for Comparable type to sort
		// String, Integer, Double, LocalDate and so on implements Comparable.compareTo(T t)
		// TreeSet uses Comparable to compare by default
		Set<String> strings = new TreeSet<>( (x, y) -> y.compareTo(x) );
		strings.add("HELLO");
		strings.add("hello");
		strings.add("Hello");
		strings.add("Test"); // A - 65, a - 97
		System.out.println(strings);
		// TreeSet can also sort Employee or other complex types but there should be either
		// Comparable or Comparator for Employee
		System.out.println("_____________ Employee inside the TreeSet _____________");
		// Comparator to sort by LocalDate.compareTo
		// Sort the employee based on salary in descending order
		//Set<Employee> employees = new TreeSet<>( (x, y) -> x.getBirthday().compareTo(y.getBirthday()))
		Set<Employee> employees = new TreeSet<>( (x, y) -> Double.compare(y.getSalary(), x.getSalary())); // 
		employees.add(new Employee(666, "Zaheer", 80000, LocalDate.parse("1970-10-05")));
		employees.add(new Employee(555, "Sachin", 90000, LocalDate.parse("1978-11-25")));
		employees.add(new Employee(777, "Yuvraj", 70000, LocalDate.parse("1982-09-15")));
		employees.add(new Employee(222, "Sourav", 100000, LocalDate.parse("1972-10-15")));
		
		for(Employee employee : employees) {
			System.out.println(employee);
		}
	}
}
