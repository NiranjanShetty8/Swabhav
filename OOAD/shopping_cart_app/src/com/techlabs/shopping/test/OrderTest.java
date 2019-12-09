package com.techlabs.shopping.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.techlabs.shopping.LineItem;
import com.techlabs.shopping.Order;
import com.techlabs.shopping.Product;

class OrderTest {

	Order order = new Order(8101, "10-12-2019");
	Product apple = new Product(101, "Apple", 100, 20);
	Product banana = new Product(102, "Banana", 1000, 50);
	LineItem lt1 = new LineItem(2101, 5, apple);
	LineItem lt2 = new LineItem(2102, 5, banana);
	LineItem lt3 = new LineItem(2102, 3, banana);
	

	@Test
	void test_Constructor_of_Order() {
		// Arrange
		int expectedId = 8101;
		String expectedDate = "10-12-2019";
		// Act
		int actualId = order.getId();
		String actualDate = order.getDate();
		// Assert
		assertEquals(expectedId, actualId);
		assertEquals(expectedDate, actualDate);
	}

	
	@Test
	void test_add_item_method_of_Order_Class() {
		order.addItem(lt1);
		order.addItem(lt2);
		order.addItem(lt3);
		// Arrange
		int expectedSizeOfList = 2;
		// Act
		int actualSizeOfList = order.getLineItemList().size();
        // Assert
		assertEquals(expectedSizeOfList, actualSizeOfList);

	}

	
	@Test
	void test_check_out_price_method_of_order() {
		order.addItem(lt1);
		order.addItem(lt2);
		order.addItem(lt3);
		//Arrange
		double actualCheckoutPrice = 1900;
		//Act
		double expectedCheckOutPrice = order.checkOutPrice();
		//Assert
		assertEquals(expectedCheckOutPrice, actualCheckoutPrice);
	}

}
