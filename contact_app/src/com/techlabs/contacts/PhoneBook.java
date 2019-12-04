package com.techlabs.contacts;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PhoneBook implements ICrudable{

	private String fName;
	private String lName;
	private int phoneNo;
	private String emailId;
	
	public PhoneBook(String fName, String lName, int phoneNo, String emailId) {
		this.fName = fName;
		this.lName = lName;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
	}
	
	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}
	
	@Override
	public void addEntry(String fName, String lName, int phoneNo, String emailId) 
			throws Exception {
		new PhoneBook(fName,lName,phoneNo,emailId);	
		FileOutputStream fos; 
		fos = new FileOutputStream("D:\\Swabhav\\Swabhav\\Practice\\Phonebook.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
		
	}

//	@Override
//	public PhoneBook search(String fname, String lName) {
//		
//		
//	}

	@Override
	public void exit() {
		
	}

}
