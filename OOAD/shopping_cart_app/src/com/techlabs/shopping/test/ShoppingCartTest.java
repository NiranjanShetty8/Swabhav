package com.techlabs.shopping.test;

import java.io.*;

import com.techlabs.shopping.*;

public class ShoppingCartTest {

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
		try {
			shopping.writeToFile(niranjan);
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void printInfo(Customer name) {
		System.out.println(name.toString());
		System.out.println("\nYour Order Details are as follows: ");
		for (Order order : name.getOrders()) {
			System.out.println(order.toString());
			for (LineItem lineitems : order.getLineItemList()) {
				System.out.println(lineitems.toString());
				System.out.println(lineitems.getProduct().toString());
			}
		}
	}

	public void writeToFile(Customer name) throws Exception {
		FileOutputStream fos;
		fos = new FileOutputStream("D:\\Swabhav\\Swabhav\\OOAD\\shopping_cart_app\\" 
				+ name.getId() +".txt");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeChars(name.toString());
		for (Order order : name.getOrders()) {
			dos.writeChars(order.toString());
			for (LineItem lineitems : order.getLineItemList()) {
				dos.writeChars(lineitems.toString());
				dos.writeChars(lineitems.getProduct().toString());

			}
		}
		System.out.println("File written");
		dos.close();
	}
}

