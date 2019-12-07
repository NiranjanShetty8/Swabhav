package com.techlabs.calculator;

public class Calculator {

	public int add(int no1, int no2) {
		if(no1<0 || no2 <0) {
			throw new RuntimeException();
		}
		int result = no1 + no2;
		return result;
	}
}
