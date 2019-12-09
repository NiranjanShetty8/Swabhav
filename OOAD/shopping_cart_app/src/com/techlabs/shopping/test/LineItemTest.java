package com.techlabs.shopping.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.techlabs.shopping.LineItem;
import com.techlabs.shopping.Product;

class LineItemTest {
	Product apple = new Product(101, "Apple", 100, 20);
	LineItem lt = new LineItem(111, 5, apple);
	
	@Test
	void test_Line_item_constructor() {
		//Arrange
		int expectedId = 111;
		int expectedQuantity = 5;
		int expectedProductId = 101;
		//Act
		int actualId = lt.getId();
		int actualQuantity = lt.getQuantity();
		int actualProductId = lt.getProduct().getId();
		//Assert
		assertEquals(expectedId, actualId);
		assertEquals(expectedQuantity, actualQuantity);
		assertEquals(expectedProductId, actualProductId);
		
	}
	
	@Test
	void test_Line_Item_cost_method() {
		
		//Arrange
		double expectedCost = 400;
		//Act
		double actualCost = lt.itemCost();
		//Assert
		assertEquals(expectedCost, actualCost);
	}

}
