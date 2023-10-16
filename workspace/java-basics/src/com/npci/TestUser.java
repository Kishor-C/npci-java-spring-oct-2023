package com.npci;

import java.time.LocalDate;
import java.util.Scanner;

import com.npci.exceptions.UserNotFoundException;
import com.npci.service.UserOperations;
import com.npci.service.UserService;
import com.npci.utility.UserOperationsFactory;

public class TestUser {
	
	private static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		UserOperations service = UserOperationsFactory.getInstance(); // to call store() & findAll() 
		int option = 0; // user option to store or findAll or exit
		do {
			System.out.println("1: Store 2: Find All 3: Find By Name -1: Exit");
			option = scan.nextInt();
			
			switch(option) {
			case 1: 
				// ask for name, dob, phone & initialize the user object and pass to the service.store()
				System.out.println("Enter name");
				String name = scan.next();
				System.out.println("Enter phone");
				long phone = scan.nextLong();
				System.out.println("Enter birthday in yyyy-MM-dd format only");
				LocalDate birthday = LocalDate.parse(scan.next());
				User user = new User(name, phone, birthday);
				int status = service.store(user);
				if(status == 1) {
					System.out.println("User stored..");
				} else {
					System.err.println("User failed to store...");
				}
				break;
			case 2: 
				// call the findAll() and iterate to print user
				User[] users = service.findAll();
				for(User item : users) {
					System.out.println(item);
					System.out.println("________________________");
				}
				break;
			case 3:
				System.out.println("Enter name");
				// name is already declared in the case 1
				name = scan.next();
				try {
					user = service.findUserByName(name);
					System.out.println("Hello "+user.getName()+" your birthday = "+user.getBirthday());
				} catch (UserNotFoundException e) {
					// View / Controller will get a different response code for exception 
					System.err.println(e.getMessage());
				}
				
				break;
			}
		} while(option != -1);
		// https://github.com/Kishor-C/npci-java-spring-oct-2023.git
	}
}
