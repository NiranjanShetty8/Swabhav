package com.techlabs.shopping.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.techlabs.shopping.Customer;
import com.techlabs.shopping.LineItem;
import com.techlabs.shopping.Order;
import com.techlabs.shopping.Product;

class CustomerTest {
	Customer niranjan = new Customer(100101, "Niranjan");
	Order order1 = new Order(8102, "11-12-2019");
	Order order2 = new Order(8101, "10-12-2019");
	Product apple = new Product(101, "Apple", 100, 20);
	Product banana = new Product(102, "Banana", 1000, 50);
	LineItem lt1 = new LineItem(2101, 5, apple);
	LineItem lt2 = new LineItem(2102, 5, banana);
	LineItem lt3 = new LineItem(2102, 3, banana);

	@Test
	void test_Customer_constructor() {
		//Arrange
		int expectedId = 100101;
		String expectedName = "Niranjan";
		//Act
		int actualId = niranjan.getId();
		String actualName = niranjan.getName();
		//Assert
		assertEquals(expectedId, actualId);
		assertEquals(expectedName, actualName);
		
	}
	
	@Test
	void test_Customer_add_order_method() {
		//Arrange
		niranjan.addOrder(order1);
		niranjan.addOrder(order2);
		int expectedSizeOfOrderList = 2;
		//Act
		int actualSizeOfOrderList = niranjan.getOrders().size();
		//Assert
		assertEquals(expectedSizeOfOrderList, actualSizeOfOrderList);
		
	}

}
