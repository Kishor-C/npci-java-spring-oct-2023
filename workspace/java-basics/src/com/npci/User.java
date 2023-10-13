package com.npci;

import java.time.LocalDate;

// Encapsulation
public class User {
	// private properties can't be accessed outside the class
	private String name;
	private long phone;
	private LocalDate birthday;
	
	public User(String name, long phone, LocalDate birthday) {
		super();
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
	}
	public User(String name, long phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		if(birthday == null) {
			return "Name = "+name+", Phone = "+phone+", Birthday = NA";
		}
		return "Name = "+name+", Phone = "+phone+", Birthday = "+birthday;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	
	
}
