package com.techlabs.engineering;

import java.util.Date;

public class Person {
	private int id;
	private String address;
	private String dateOfBirth;

	public Person(int id, String address, String dateOfBirth) {
		this.id = id;
		this.address = address;
		this.dateOfBirth = dateOfBirth;

	}

	public int getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public String getDateOFBirth() {
		return dateOfBirth;
	}
}
