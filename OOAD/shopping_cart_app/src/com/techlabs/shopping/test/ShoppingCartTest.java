package com.techlabs.shopping.test;

import com.techlabs.shopping.*;

public class ShoppingCartTest {
	String customerName;


	public static void main(String[] args) {
		Customer niranjan = new Customer(100101, "Niranjan");
		Order order1 = new Order(8102, "11-12-2019");
		Order order2 = new Order(8101, "11-11-2019");
		niranjan.addOrder(order1);
		niranjan.addOrder(order2);
		
		Product apple = new Product(101, "Apple", 100, 20);
		Product banana = new Product(102, "Banana", 1000, 50);
		LineItem lt1 = new LineItem(2101, 5, apple);
		LineItem lt2 = new LineItem(2102, 5, banana);
		LineItem lt3 = new LineItem(2102, 3, banana);
		order1.addItem(lt1);
		order1.addItem(lt2);
		order2.addItem(lt3);
		ShoppingCartTest shopping = new ShoppingCartTest();
		shopping.printInfo(niranjan);

	}

	public void printInfo(Customer name) {
		System.out.println("Your name: " +name.getName());
		System.out.println("Your ID: " +name.getId());
		System.out.println("Your Order Details are as follows: ");
		for(Order order : name.getOrders()) {
			System.out.println("Order ID : " +order.getId());
			System.out.println("Order Date: " +order.getDate());
			System.out.println("Checkout Price: " +order.checkOutPrice());
			for(LineItem lineitems : order.getLineItemList()) {
				System.out.println("Line Item ID is: " +lineitems.getId());
				System.out.println("Quantity: " +lineitems.getQuantity());
				System.out.println("Line Item Cost: " + lineitems.itemCost());
				System.out.println("Product ID: " +lineitems.getProduct().getId());
				System.out.println("Product Name: " +lineitems.getProduct().getName());	
				System.out.println("Product Actual Cost: " +lineitems.getProduct().getCost());
				System.out.println("Discount Percentage: " +lineitems.getProduct().getDiscount());
				System.out.println("Product Final cost: " +lineitems.getProduct().calculateFinalPrice());
				}
			}
		}
}
