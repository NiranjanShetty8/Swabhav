package com.techlabs.contact;

import java.io.Serializable;


public class Contact implements Serializable, Comparable<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6590646784348911952L;
	private String fName;
	private String lName;
	private long phoneNo;
	private String emailId;

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
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

	public Contact(String fName, String lName, long phoneNo, String emailID) {
		this.fName = fName;
		this.emailId = emailID;
		this.lName = lName;
		this.phoneNo = phoneNo;
	}

	@Override
	public int compareTo(Object o) {
		Contact val = (Contact) o;
		return this.getfName().compareToIgnoreCase(val.getfName());
	}

}