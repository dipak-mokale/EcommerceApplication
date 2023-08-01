package com.velocity.ecommerceapp;

import java.util.Scanner;

public class Operations {
	Scanner scanner = new Scanner(System.in);

	@SuppressWarnings("resource")

	public void displayOperations() {
		System.out.println("Welcome to E-Commerce based Application");
		System.out.println();
		System.out.println("User Operation");
		System.out.println("\t 1. User Registration");
		System.out.println("\t 2. User Login");
		System.out.println("\t 3. User View Product item as Sorted Order");
		System.out.println("\t 4. Buy Product");
		System.out.println("\t 5. View Cart");
		System.out.println("\t 6. Purchase the item");
		System.out.println();
		System.out.println("Admin Operation");
		System.out.println("\t 7. Add Product Item");
		System.out.println("\t 8. Calculate Bill");
		System.out.println("\t 9. Display Amount to End User");
		System.out.println("\t 10. Check Quantity");
		System.out.println("\t 11. Check Registered User");
		System.out.println("\t 12. Check the Particular User History");
		System.out.println();
		System.out.println("Guest Operation");
		System.out.println("\t 13. View Product Item");
		System.out.println("\t 14. Not Purchased Item");
		System.out.println();

		System.out.print("Enter your choice - ");
		Integer userChoice = new Scanner(System.in).nextInt();
		if (userChoice >= 1 && userChoice <= 14) {
			opertaionToExecute(userChoice);
		} else {
			System.out.println("Plese enter a valid choice !");
			getOperationList();
		}
	}

	private void opertaionToExecute(Integer userChoice) {
		UserOperations userOperations = new UserOperations();
		switch (userChoice) {
		case 1:
			userOperations.userRegistration();
			getOperationList();
			break;
		case 2:
			userOperations.userLogin();
			getOperationList();
			break;
		case 3:

		}

	}

	private void getOperationList() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Want to continue ?");
		System.out.println("1. Operations Menu \t 2. Exit");
		int userChoice = scanner.nextInt();
		switch (userChoice) {
		case 1:
			displayOperations();
			break;
		case 2:
			break;
		}

	}
}
