package com.techlabs.shopping.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.techlabs.shopping.Product;

class ProductTest {
	Product p1 = new Product(101, "Apple", 100, 20);
	
	@Test
	void testing_the_product_class_constructor() {
		//Arrange
		int expectedId = 101;
		String expectedName = "Apple";
		double expectedCost = 100;
		float expectedDiscount = 20f;
		//Act
		int actualId = p1.getId();
		String actualName = p1.getName();
		double actualCost = p1.getCost();
		float actualDiscount = p1.getDiscount();
		//Assert
		assertEquals(expectedId, actualId);
		assertEquals(expectedName, actualName);
		assertEquals(expectedCost, actualCost);
		assertEquals(expectedDiscount, actualDiscount);
		
	}
	@Test
	void testing_the_total_cost_method_of_Product() {
		//Arrange
		double expectedTotal = 80.0;
		//Act
		double actualTotal = p1.calculateFinalPrice();
		//Assert
		assertEquals(expectedTotal, actualTotal);
	}

}
