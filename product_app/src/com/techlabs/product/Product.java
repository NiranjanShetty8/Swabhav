package com.techlabs.product;

public class Product {
	private int id;
	private String name;
	private double cost;
	private float discount;

	public Product(int newId, String newName, double newCost, float newDiscount)
	{
		id = newId;
		name = newName;
		cost = newCost;
		discount = newDiscount;
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

	public double finalCost() {
		double discountP = cost * discount / 100;
		double totalCost = cost - discountP;
		return totalCost;
	}

	
}
