package com.techlabs.customer;

public class Customer {
	private static int idGenerator=1000;
	private String firstName;
	private String lastName;
	private int custId;
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.custId = idGenerator+1;
		idGenerator++;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getId() {
		return custId;
	}

}

