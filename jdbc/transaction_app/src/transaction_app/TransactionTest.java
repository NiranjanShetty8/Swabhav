package transaction_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionTest {

	public static void main(String[] args) {
		Connection con = null;
//		String sql;
		String sqlBal;
		int cId;
		String sqlId;
		String url;
		int id;
		int amount;
		Scanner sc = new Scanner(System.in);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://localhost:4040/swabhav";
			con = DriverManager.getConnection(url, "root", "root");
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			System.out.println("Connected");

//			Creation query :-
//			sql = "CREATE TABLE CUSTOMER(id int,name varchar(20),balance int);";
//			stmt.executeUpdate(sql);
//			System.out.println("Customer Table created");
//			sql = "CREATE TABLE MERCHANT(id int,name varchar(20),balance int);";
//			stmt.executeUpdate(sql);
//			System.out.println("Merchant Table created");
//			sql = "INSERT INTO CUSTOMER "+ "VALUES(101,'Niranjan',10000)";
//			stmt.executeUpdate(sql);
//			sql = "INSERT INTO MERCHANT "+ "VALUES(101,'DMART',100000);";
//			stmt.executeUpdate(sql);

			System.out.println("Enter the customer ID:");
			cId = sc.nextInt();
			System.out.println("Enter the amount of funds to be transferred");
			amount = sc.nextInt();

			sqlBal = "UPDATE CUSTOMER c SET c.balance = c.balance-" + amount + " where id=" + cId + ";";
			int result1 = stmt.executeUpdate(sqlBal);
			System.out.println("Enter the merchant ID from whom you wish to buy");
			id = sc.nextInt();
			
			sc.close();
			sqlId = "UPDATE MERCHANT m SET m.balance = m.balance+" + amount + " where id=" + id + ";";
			int result2 = stmt.executeUpdate(sqlId);

			if (result1 != 0 && result2 != 0) {
				con.commit();
				System.out.println("Committed");
			} else {
				con.rollback();
				System.out.println("rolled-back");
			}
//			System.out.println(result1);
//			System.out.println(result2);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
