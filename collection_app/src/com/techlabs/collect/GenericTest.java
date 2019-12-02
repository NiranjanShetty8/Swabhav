package com.techlabs.collect;

import java.util.ArrayList;

import com.techlabs.model.LineItem;

public class GenericTest {
	public static void main(String[] args) {
		double checkout = 0;
		
		ArrayList<LineItem> cart = new ArrayList<LineItem>();
		cart.add(new LineItem(101, "Apple", 30, 10));
		cart.add(new LineItem(105, "Banana", 15, 5));
		cart.add(new LineItem(199, "ToothPaste" , 85, 2));
		//cart.add("Hello World");
		
		for(LineItem element: cart) {
			System.out.println("Name is: " +element.getName());
			System.out.println("Quantity is: " +element.getName());
			System.out.println("Total Cost is: " +element.calculateTotal());
			checkout = checkout + element.calculateTotal();
		}
		System.out.println("Checkout Price is: Rs " +checkout);

	}
}
