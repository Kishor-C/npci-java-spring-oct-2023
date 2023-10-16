package com.npci.service;

import com.npci.User;
import com.npci.exceptions.UserNotFoundException;

// service layer class
public class UserService implements UserOperations {
	private static User[] users = new User[5]; // [user1, null, null, null, null]
	// we need a counter to track the index of the array to know how many objects are stored
	private static int index = 0;
	// store method
	@Override
	public int store(User user) {
		// return 1 if stored
		if(index >= 5) {
			return -1;
		}
		users[index++] = user;
		return 1;
	}
	// findAll method
	@Override
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
	@Override
	public User findUserByName(String name) throws UserNotFoundException {
		User[] array = findAll();
		for(User u : array) {
			if(u.getName().equalsIgnoreCase(name)) {
				return u;
			}
		}
		// throw exception or return null
		throw new UserNotFoundException("Sorry "+name+" not found");
	}
}
