package com.velocity.ecommerceapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.metal.OceanTheme;

public class UserOperations {
	Scanner scanner = new Scanner(System.in);
	JDBCConnect jdbcConnect = new JDBCConnect();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<Cart> cart = new ArrayList<>();
	int totalBill = 0;

	public void userRegistration() {

		System.out.print("Enter the first name >> ");
		String firstName = scanner.next();
		System.out.print("Enter the last name >> ");
		String lastName = scanner.next();
		System.out.print("Enter the username >> ");
		String userName = scanner.next();
		System.out.print("Enter the password >> ");
		String password = scanner.next();
		System.out.print("Enter the city >> ");
		String city = scanner.next();
		System.out.print("Enter the mail id >> ");
		String mail = scanner.next();
		System.out.print("Enter the mobile number >> ");
		long mobile = scanner.nextLong();

		connection = jdbcConnect.getConnection();

		String sqlQuery = "insert into users (FirstName, LastName, UserName, Password, City , MainID, Mobile) "
				+ "values (?,?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sqlQuery);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, userName);
			ps.setString(4, password);
			ps.setString(5, city);
			ps.setString(6, mail);
			ps.setLong(7, mobile);

			ps.execute();
			System.out.println();
			System.out.println("User Registration Done Sucessfully ! ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void userLogin() {
		// TODO Auto-generated method stub
		connection = jdbcConnect.getConnection();
		boolean flag = false;
		int count = 0;

		System.out.println("Enter the username >> ");
		String username = scanner.next();
		System.out.println("Enter the password >> ");
		String password = scanner.next();

		String sqlQuery = "SELECT * FROM users";
		try {
			ps = connection.prepareStatement(sqlQuery);
			rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getString(3).equals(username) && rs.getString(4).equals(password)) {
					System.out.println("Logged in !");
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

	public void viewProducts() {
		// TODO Auto-generated method stub
		connection = jdbcConnect.getConnection();

		String sqlQuery = "select * from products order by Name asc";
		try {
			ps = connection.prepareStatement(sqlQuery);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("ID >> " + rs.getString(1));
				System.out.println("Name >> " + rs.getString(2));
				System.out.println("Description >> " + rs.getString(3));
				System.out.println("Available Quantity >> " + rs.getString(4));
				System.out.println("Price >> " + rs.getString(5));
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

	public void buyProduct() {
		// TODO Auto-generated method stub
		System.out.println("Enter the product id to buy >> ");
		int productid = scanner.nextInt();
		System.out.println("Enter the product qunatity >> ");
		int productQuantity = scanner.nextInt();

		try {
			String sql = "select * from products";
			connection = jdbcConnect.getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == productid && rs.getInt(4) > productQuantity) {
					cart.add(new Cart(rs.getInt(1), rs.getString(2), productQuantity, rs.getInt(5)));
					totalBill = totalBill + productQuantity * rs.getInt(5);
				}
			}
			System.out.println("1. Buy more ? \t 2. View Cart");
			int choice = scanner.nextInt();
			if (choice == 1) {
				buyProduct();
			} else {
				System.out.println(cart);
				System.out.println("Total Bill >> " + totalBill);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
