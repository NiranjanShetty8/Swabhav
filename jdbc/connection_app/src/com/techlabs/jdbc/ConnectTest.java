package com.techlabs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectTest {

	public static void main(String[] args) {
		{
			String url;
			Connection con = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				url = "jdbc:mysql://localhost:3306/swabhav?user=root&password=root";
				con = DriverManager.getConnection(url);
				System.out.println(con.getClass());
				System.out.println("Connection created");
				con.close();
				System.out.println("Connection closed");
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}

	}
}
