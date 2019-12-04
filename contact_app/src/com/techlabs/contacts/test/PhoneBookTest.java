package com.techlabs.contacts.test;

import java.io.IOException;
import java.util.Scanner;

import com.techlabs.contacts.*;

public class PhoneBookTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PhoneBook pb = null;
		System.out.print("1. Add Entry\n2. Display\n3. Search\n4. Exit\n");
		System.out.println("Enter your choice: ");
		switch(sc.nextInt()) {
		case 1: 
			System.out.println("Enter First Name :" );
			String fName = sc.next();
			System.out.println("Enter Last Name: ");
			String lName = sc.next();
			System.out.println("Enter Phone Number: ");
			int phoneNo = sc.nextInt();
			System.out.println("Enter email ID: ");
			String emailId = sc.next();
			try {
			pb.addEntry(fName, lName, phoneNo, emailId);
			}catch (IOException e) {
				
			}catch (Exception e) {				
			}
			break;
		case 2:
			System.out.println("Display");
			break;
		default:
			System.out.println("exit");
		}
		
	}

}
