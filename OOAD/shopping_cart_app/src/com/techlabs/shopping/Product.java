package com.techlabs.shopping;

public class Product {

	private int id;
	private String name;
	private double cost;
	private float discount;
	
	public Product(int id, String name, double cost, float discount) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getCost() {
		return cost;
	}

	public float getDiscount() {
		return discount;
	}
	
	public double calculateFinalPrice() {
		double total = cost - (cost*discount/100);
		return total;
	}
	
	@Override
	public String toString() {
		String productDetails = "\nProduct Name: " +this.getName() +"\nProduct ID: "+ this.id 
				+"\nProduct Actual Cost is: " + this.getCost() +"\nProduct Discount is: " +this.getDiscount()
				+"\nProduct Final price: "+this.calculateFinalPrice();
		return productDetails;
	}
}
