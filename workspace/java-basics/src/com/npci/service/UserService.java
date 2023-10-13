package com.npci.service;

import com.npci.User;

// service layer class
public class UserService {
	private static User[] users = new User[5]; // [user1, null, null, null, null]
	// we need a counter to track the index of the array to know how many objects are stored
	private static int index = 0;
	// store method
	public int store(User user) {
		// return 1 if stored
		if(index >= 5) {
			return -1;
		}
		users[index++] = user;
		return 1;
	}
	// findAll method
	public User[] findAll() {
		// copy the array users to another array that can store only initialized block
		User[] copy = new User[index];
		for(int i = 0; i < index; i++) {
			copy[i] = users[i];
		}
		return copy;
	}
	/*
	 * Create a method that finds the user by name and returns the User 
	 * In Main method create case 3 to accept the name & find the user by name
	 */
	public User findUserByName(String name) {
		User[] array = findAll();
		for(User u : array) {
			if(u.getName().equals(name)) {
				return u;
			}
		}
		// throw exception or return null
		return null;
	}
}
