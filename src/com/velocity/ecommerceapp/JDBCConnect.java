package com.velocity.ecommerceapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnect {
	Connection connection = null;

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercedatabase", "root",
					"Root@123");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
}
