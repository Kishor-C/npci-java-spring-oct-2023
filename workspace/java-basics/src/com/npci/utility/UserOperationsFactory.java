package com.npci.utility;

import com.npci.service.UserOperations;
import com.npci.service.UserService;

/*
 * A class which can create Object of UserService
 */
public class UserOperationsFactory {
	public static UserOperations getInstance() { 
		UserOperations operation = new UserService();
		return operation;
	}
}
