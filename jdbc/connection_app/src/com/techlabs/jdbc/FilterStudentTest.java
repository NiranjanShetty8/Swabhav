package com.techlabs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FilterStudentTest {
	

	public static void main(String[] args) {
		String url;
		String sql;
		Connection conn = null;
		Scanner sc = new Scanner(System.in);
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://localhost:3306/swabhav";
			conn = DriverManager.getConnection(url,"root","root");
			System.out.println("Connection created");
			Statement stmt = conn.createStatement();
			System.out.println("Enter the query: ");
			sql = sc.nextLine();
			ResultSet result = stmt.executeQuery(sql);
			
			while(result.next()) {
				System.out.println(result.getString("ENAME"));
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
