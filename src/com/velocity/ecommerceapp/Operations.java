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
		System.out.println();
		System.out.println("Admin Operation");
		System.out.println("\t 5. Add Product Item");
		System.out.println("\t 6. Calculate Bill");
		System.out.println("\t 7. Display Amount to End User");
		System.out.println("\t 8. Check Quantity");
		System.out.println("\t 9. Check Registered User");
		System.out.println("\t 10. Check the Particular User History");
		System.out.println();
		System.out.println("Guest Operation");
		System.out.println("\t 11. View Product Item");
		System.out.println("\t 12. Not Purchased Item");
		System.out.println();

		System.out.print("Enter your choice - ");
		Integer userChoice = new Scanner(System.in).nextInt();
		if (userChoice >= 1 && userChoice <= 12) {
			executeOperation(userChoice);
		} else {
			System.out.println("Plese enter a valid choice !");
			getOperationList();
		}
	}

	private void executeOperation(Integer userChoice) {
		UserOperations userOperations = new UserOperations();
		AdminOperations adminOperations = new AdminOperations();
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
			userOperations.viewProducts();
			getOperationList();
			break;
		case 4:
			userOperations.buyProduct();
			getOperationList();
			break;
		case 5:
			adminOperations.addProduct();
			getOperationList();
			break;
		case 8:
			adminOperations.getQuantity();
			getOperationList();
			break;
		case 9:
			adminOperations.checkRegisteredUsers();
			getOperationList();
			break;
		case 11:
			adminOperations.geustViewProductItems();
			getOperationList();
			break;
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
