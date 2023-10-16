package com.npci.service;

import com.npci.User;
import com.npci.exceptions.UserNotFoundException;

public interface UserOperations {

	// store method
	int store(User user);

	// findAll method
	User[] findAll();

	/*
	 * Create a method that finds the user by name and returns the User 
	 * In Main method create case 3 to accept the name & find the user by name
	 */
	User findUserByName(String name) throws UserNotFoundException;

}