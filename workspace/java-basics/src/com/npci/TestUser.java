package com.npci;

import java.time.LocalDate;
import java.util.Scanner;

import com.npci.service.UserService;

public class TestUser {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		UserService service = new UserService(); // to call store() & findAll() 
		int option = 0; // user option to store or findAll or exit
		do {
			System.out.println("1: Store 2: Find All 3: Exit");
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
			}
		} while(option != 3);
		
	}
}
