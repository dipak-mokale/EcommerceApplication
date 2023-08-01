package com.velocity.ecommerceapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserOperations {
	Scanner scanner = new Scanner(System.in);
	Connection connection = null;
	PreparedStatement ps = null;
	
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
		int mobile = scanner.nextInt();
		
		JDBCConnect jdbcConnect = new JDBCConnect();
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
			ps.setInt(7, mobile);
			
			ps.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
