package com.techlabs.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void addOnlyPositiveNumbers_10_20_Result30() throws Exception  {
		//Arrange
		Calculator c1 = new Calculator();
		int expected = 30;
		//Act
		int actualResult = c1.add(10, 20);
		//Assert
		assertEquals(expected, actualResult);
	}
	@Test
	void ifNegativeNumberAreAddedThrowsException() {
		//Arrange
		Calculator c2 = new Calculator();
		//Act & Assert
		assertThrows(Exception.class, () -> c2.add(-2, -4));
	}
}
