package com.velocity.ecommerceapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
	PreparedStatement ps = null;
	Connection connection = null;

	public void insertUserData(String desc, String name, Integer price, Integer quantity) {
		JDBCConnect jdbcConnect = new JDBCConnect();
		connection = jdbcConnect.getConnection();
		String query = "insert into products (Description,Name,Price,Quantity) values (?,?,?,?)";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, desc);
			ps.setString(2, name);
			ps.setInt(3, price);
			ps.setInt(4, quantity);

			Integer integer = ps.executeUpdate();
			System.out.println(integer + " rows added !");

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
