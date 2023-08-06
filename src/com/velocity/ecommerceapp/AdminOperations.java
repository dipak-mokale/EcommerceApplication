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
			if (choice == 1) {
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

	private boolean validateAdmin() {
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
					flag = true;
					return true;
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
		return false;
	}

	public void checkRegisteredUsers() {
		// TODO Auto-generated method stub
		if (validateAdmin()) {
			connection = jdbcConnect.getConnection();

			String sqlQuery = "select * from users";
			try {
				ps = connection.prepareStatement(sqlQuery);
				rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println("First Name >> " + rs.getString(1));
					System.out.println("Last Name >> " + rs.getString(2));
					System.out.println("Username >> " + rs.getString(3));
					System.out.println("Password >> " + rs.getString(4));
					System.out.println("City >> " + rs.getString(5));
					System.out.println("MailID >> " + rs.getString(6));
					System.out.println("Mobile >> " + rs.getLong(7));
					System.out.println("-------------------------------------");
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

	public void getQuantity() {
		// TODO Auto-generated method stub
		if (validateAdmin()) {

			System.out.println("Enter the product ID >> ");
			Integer productID = scanner.nextInt();
			connection = jdbcConnect.getConnection();

			String sqlQuery = "select AvailableQuantity from products where ID=?";
			try {
				ps = connection.prepareStatement(sqlQuery);
				ps.setInt(1, productID);
				ps.execute();
				rs = ps.executeQuery();
				while (rs.next()) {

					System.out.println("Available Quantity >> " + rs.getInt(1));
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

}
