package com.techlabs.customer.test;

import com.techlabs.customer.Customer;

public class CustomerTest {

	public static void main(String[] args) {
		Customer niranjan = new Customer("Niranjan", "Shetty");
		Customer hardik = new Customer("Hardik", "Palav");
		Customer vijay = new Customer("Vijay", "Chavan");
		printInfo(vijay);
		printInfo(niranjan);
		printInfo(hardik);
		
	}
	public static void printInfo(Customer obj) {
		System.out.print(obj.getFirstName()+" ");
		System.out.print(obj.getLastName()+" ");
		System.out.print(obj.getId());
		System.out.println();
	}

}
