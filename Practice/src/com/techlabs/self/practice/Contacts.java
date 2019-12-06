package com.techlabs.self.practice;

import java.io.Serializable;

public class Contacts  implements Serializable, Comparable{

	private String fName;
	private String lName;
	private long phoneNo;
	private String emailId;
	
	public String getfName() {
		return fName;
	}
	public String getlName() {
		return lName;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	
	public Contacts(String fName, String lName, long phoneNo, String emailID) {
		this.fName = fName;
		this.emailId = emailID;
		this.lName = lName;
		this.phoneNo = phoneNo;
	}
	@Override
	public int compareTo(Object o) {
		Contacts val = (Contacts) o;
		return this.fName.compareTo(val.getfName());
	}
}
