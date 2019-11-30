package com.techlabs.crudable;

public class AddressDB implements ICurdable {
	public void create() {
		System.out.println("Address Created");
	}

	public void read() {
		System.out.println("Reading data from Address Database");
	}

	public void update() {
		System.out.println("Updated data to Address Database");
	}

	public void delete() {
		System.out.println("Deleted data in Address Databases");
	}

}
