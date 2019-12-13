package com.techlabs.srp.violation;

public class Invoice {
	
	private int no;
	private String description;
	private double cost;
	private double discount;
	private static final float gst = 12.5f;
	
	public Invoice(int no, String description, double cost, double discount) {
		this.no = no;
		this.description = description;
		this.cost = cost;
		this.discount = discount;
	}

	public int getNo() {
		return no;
	}

	public String getDescription() {
		return description;
	}

	public double getCost() {
		return cost;
	}

	public double getDiscount() {
		return discount;
	}

	public static float getGst() {
		return gst;
	}
	
	public double calculateDiscount() {
		double discountRs = cost*discount/100;
		return discountRs;
	}
	
	public double calculateTax() {
		double tax = (cost - this.calculateDiscount())*gst/100;
		return tax;
	}
	
	public double calculateFinalCost() {
		double finalCost = cost - this.calculateDiscount() +this.calculateTax();
		return finalCost;
	}
	
	public void print(Invoice obj) {
		System.out.println("Invoice no: " +this.getNo());
		System.out.println("invoice description: " +this.getDescription());
		System.out.println("Cost :" +this.getCost());
		System.out.println("Discount: " +this.getDiscount());
		System.out.println("Discount is Rs:"+this.calculateDiscount());
		System.out.println("Tax is: "+this.calculateTax() );
		System.out.println("Final cost is: " +this.calculateFinalCost());
		
	}

}
