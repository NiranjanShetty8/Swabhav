package com.techlabs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class StudentTest {

	public static void main(String[] args) throws Exception, ClassNotFoundException {
		String url;
		Connection con = null;
		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://localhost:4040/swabhav";
			con = DriverManager.getConnection(url,"root","root");
			System.out.println(con.getClass());
			System.out.println("Connection created");
			Statement stmt = con.createStatement();
			String sql = "select * from emp";
			ResultSet result = stmt.executeQuery(sql);
			
			while (result.next()) {
				String name = result.getString("ename");
//			    long age  = result.getLong  ("sal");
				System.out.println(name);
			}
			result.close();
			con.close();
			

//			PreparedStatement preparedStatement =(PreparedStatement) con.prepareStatement(sql);
			
			
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
		
	}

}
