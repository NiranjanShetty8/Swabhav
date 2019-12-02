package com.techlabs.model;

public class LineItem {
	private int id;
	private double unitPrice;
	private int quantity;
	private String name;

	public LineItem(int id, String name, double unitPrice, int quantity) {
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public int quantity() {
		return quantity;
	}

	public String getName() {
		return name;
	}

	public double calculateTotal() {
		double totalPrice = unitPrice * quantity;
		return totalPrice;
	}

}
