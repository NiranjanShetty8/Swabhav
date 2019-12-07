package com.techlabs.self.practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class AddContact {
	private String fName;
	private String lName;
	private int phoneNo;
	private String emailId;
	
	public AddContact(String fName, String lName, int phoneNo, String emailId) {
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
	
	public void addEntry() {
		
	}
	public void writeToFile(AddContact obj) throws IOException{
		FileOutputStream fs;
		fs = new FileOutputStream("D:\\Swabhav\\Swabhav\\Practice\\Practise.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fs);
		oos.writeObject(obj);
		oos.close();
		fs.close();
	}
}
