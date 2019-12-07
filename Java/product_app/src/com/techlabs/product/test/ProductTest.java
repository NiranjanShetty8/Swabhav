package com.techlabs.product.test;
import com.techlabs.product.*;

public class ProductTest {

	public static void main(String[] args) {
		Product p1;
		p1 = new Product(101,"book",500.00,20f);
		printInfo(p1);
		printInfo(new Product(102, "mobile", 100.00,10f));
		
	}
	private static void printInfo(Product p1) {
		System.out.println("Product ID is : " + p1.getId());
		System.out.println("Product name is : " + p1.getName());
		System.out.println("Actual product cost is : " + p1.getCost());
		System.out.println("Product discount is : " + p1.getDiscount());
		System.out.println("Total buying cost is : " +p1.finalCost());
	}
}
