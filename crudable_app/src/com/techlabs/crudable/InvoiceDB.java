package com.techlabs.crudable;

public class InvoiceDB implements ICurdable {
	public void create() {
		System.out.println("Created Invoice");
	}

	public void read() {
		System.out.println("Reading data from Invoice");
	}

	public void update() {
		System.out.println("Updated data to Invoice");
	}

	public void delete() {
		System.out.println("Deleted data from Invoice Database");
	}

}
