package com.techlabs.srp.solution;

public class InvoiceConsolePrinter {
	
	public void print(Invoice obj) {
		System.out.println("Invoice no: " + obj.getNo());
		System.out.println("Invoice description: " + obj.getDescription());
		System.out.println("Cost :" + obj.getCost());
		System.out.println("Discount: " + obj.getDiscount());
		System.out.println("Discount is Rs: " + obj.calculateDiscount());
		System.out.println("Tax is: " + obj.calculateTax());
		System.out.println("Final cost is: " + obj.calculateFinalCost());

	}
}
