package com.techlabs.shopping;

public class LineItem {

	private int id;
	private int quantity;
	private Product product;
	
	public LineItem(int id, int quantity, Product product) {
		this.id = id;
		this.quantity = quantity;
		this.product = product;
		
	}

	public int getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}
	
	public double itemCost() {
		double itemCost = product.calculateFinalPrice() * quantity;
		return itemCost;
	}
	
	@Override
	public String toString() {
		String itemDetails = "\nItem ID: " +this.getId() + "\nItem Quantity: " +this.getQuantity() 
		+"\nItem cost: " +this.itemCost();
		return itemDetails;
	}
}
