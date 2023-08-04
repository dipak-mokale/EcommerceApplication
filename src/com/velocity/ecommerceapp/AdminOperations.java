package com.velocity.ecommerceapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminOperations {

	Scanner scanner = new Scanner(System.in);
	JDBCConnect jdbcConnect = new JDBCConnect();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Operations operations = new Operations();

	public void addProduct() {
		
		System.out.println("Yoou Need Administrator Login !");
		System.out.println();
		connection = jdbcConnect.getConnection();
		boolean flag = false;
		System.out.println("Enter the Admin username >> ");
		String username = scanner.next();
		System.out.println("Enter the Admin password >> ");
		String password = scanner.next();

		String sqlQuery = "SELECT * FROM admin";
		try {
			ps = connection.prepareStatement(sqlQuery);
			rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getString(2).equals(username) && rs.getString(3).equals(password)) {
					System.out.println("Logged in to Admin system !");
					addProductAdmin();
					flag = true;
					break;
				}
			}
			if (flag != true) {
				System.out.println("Invalid Username & password !");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				this.ps.close();
				this.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

	private void addProductAdmin() {
		// TODO Auto-generated method stub
		System.out.println("Product Name >> ");
		String name = scanner.next();
		System.out.println("Product Description >> ");
		String description = scanner.next();
		System.out.println("Product Quantity >> ");
		int quantity = scanner.nextInt();
		System.out.println("Product Price >> ");
		Integer price = scanner.nextInt();

		String sqlQuery = "insert into products (Name,Description,AvailableQuantity,Price) values (?,?,?,?)";
		connection = jdbcConnect.getConnection();
		try {
			ps = connection.prepareStatement(sqlQuery);

			ps.setString(1, name);
			ps.setString(2, description);
			ps.setInt(3, quantity);
			ps.setInt(4, price);
			
			ps.executeUpdate();
			
			System.out.println("product added sucessfully !");
			System.out.println();
			System.out.println("1. Add more products \t 2. No !");
			int choice = scanner.nextInt();
			if(choice==1) {
				addProduct();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				this.ps.close();
				this.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

}
