package com.npci;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class TestUnique {
	public static void main(String[] args) {
		// storing complex type in the Set
		Set<Employee> employees = new HashSet<>();
		employees.add(new Employee(100, "Alex", 45200.0, LocalDate.parse("2001-12-25")));
		employees.add(new Employee(100, "Alex", 45200.0, LocalDate.parse("2001-12-25")));
		employees.add(new Employee(100, "Alex", 45200.0, LocalDate.parse("2001-12-25")));
		employees.add(new Employee(200, "Bruce", 75200.0, LocalDate.parse("2002-10-25")));	
		System.out.println("Size: "+employees.size());
		for(Employee e : employees) {
			System.out.println(e);
		}
		// storing simple type of value in the Set
		// int - Integer, double - Double, char - Character, boolean - Boolean
		Set<Integer> integers = new HashSet<>();
		integers.add(7);
		integers.add(22);
		integers.add(13);
		integers.add(19);
		integers.add(7);
		integers.add(11);
		System.out.println("Size: "+integers.size());
		for(int value : integers) {
			System.out.println(value);
		}
	}
}
