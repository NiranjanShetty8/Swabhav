package com.techlabs.collect;

import java.util.*;

import com.techlabs.model.LineItem;

public class CollectionTest {
	public static void main(String[] args) {
		double checkout =0;
		ArrayList cart = new ArrayList();
		cart.add(new LineItem(101, "Apple", 30, 10));
		cart.add(new LineItem(105, "Banana", 15, 5));
		cart.add(new LineItem(199, "ToothPaste" , 85, 2));
		//cart.add("Hello World");
		
		for(Object element: cart) {
			LineItem lt = (LineItem) element;
			System.out.println("Name is: " +lt.getName());
			System.out.println("Quantity is: " +lt.getName());
			System.out.println("Total Cost is: " +lt.calculateTotal());
			checkout = checkout + lt.calculateTotal();

		}
		System.out.println("Checkout Price is: Rs " +checkout);

	}

}
