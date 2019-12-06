package com.techlabs.contacts.test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

import com.techlabs.contact.Contact;
import com.techlabs.contact.ContactManager;

public class MainMenu {
	Scanner sc = new Scanner(System.in);
	ContactManager fileObj = new ContactManager();


	public static void main(String[] args) {
		MainMenu mm = new MainMenu();
		try {
			mm.openMenu();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}

	}

	public void openMenu() throws Exception {
		System.out.println("1. Add Contact.\n2. Display Contacts."
				+ "\n3. Search Contact.\n4. Modify phone number.\n5. Exit.");
		try {
			System.out.println("Total Number of contacts: " 
					+fileObj.readFromFile().size());
		} catch (Exception e) {
			System.out.println("Total Number of contacts: 0");
		}
		System.out.println("Enter your choice(1-5): ");
		int choice = sc.nextInt();
		switch(choice) {
		case 1 : 
			System.out.println("Enter First Name: ");
			String fName = sc.next();
			System.out.println("Enter Last Name: ");
			String lName = sc.next();
			System.out.println("Enter mobile number: ");
			long phoneNo = sc.nextLong();
			System.out.println("Enter e-mail ID: ");
			String emailId = sc.next();
			fileObj.addContact(fName, lName, phoneNo, emailId);
			System.out.println("Contact Added");
			openMenu();
		case 2 :
			MainMenu mm = new MainMenu();
			mm.displayFile();
			openMenu();
		case 3 :
			System.out.println("Enter First Name: ");
			String fname = sc.next();
			System.out.println("Enter Last Name: ");
			String lname = sc.next();
			Contact cont = fileObj.search(fname, lname);
			if(cont == null) {
				System.out.println("This contact does not exist.");
				openMenu();
			}
			System.out.println(cont.getfName() + " " + cont.getlName() 
			+ " " + cont.getPhoneNo() + " " + cont.getEmailId());
			openMenu();
		case 4 :
			System.out.println("Enter First Name of the contact: ");
			String firstname = sc.next();
			System.out.println("Enter Last Name of the contact: ");
			String lastname = sc.next();
			System.out.println("Enter new phone number: ");
			long newPhoneNo = sc.nextLong();
			boolean s = fileObj.modifyPhoneNo(firstname, lastname, newPhoneNo);
			if(s) {
				System.out.println("Contact modified");
				openMenu();
			}
			System.out.println("Contact not found.");
			openMenu();
		case 5 :
			System.out.println("Thank You");
			System.exit(0);
		default :
			System.out.println("Invalid Choice.\nPlease enter choices from Integer 1-5");
		}
		
	}
	
	public void displayFile() throws Exception {
		FileInputStream fis = new FileInputStream(ContactManager.location);
		ObjectInputStream ois = new ObjectInputStream(fis);
		@SuppressWarnings("unchecked")
		TreeSet<Contact> deserialize = (TreeSet<Contact>)ois.readObject();
		Iterator<Contact> iter = deserialize.iterator();
		while(iter.hasNext()) {
			Contact next = iter.next();
			System.out.println(next.getfName() + " " +
			next.getlName() + " " +
			next.getEmailId() + " " +
			next.getPhoneNo());
		}
		ois.close();
	}
		
}
