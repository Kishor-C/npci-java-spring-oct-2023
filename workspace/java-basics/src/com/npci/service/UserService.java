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
		return users;
	}
}
