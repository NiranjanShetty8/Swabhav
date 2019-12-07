package com.techlabs.crudable;

public class CustomerDB implements ICurdable {
	public void create() {
		System.out.println("Customer Created in Customer Database");
	}

	public void read() {
		System.out.println("Reading data from Customer Database");
	}

	public void update() {
		System.out.println("Updated data of Customer Database");
	}

	public void delete() {
		System.out.println("Deleted data of Customer Database");
	}

}
