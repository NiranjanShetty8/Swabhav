package com.techlabs.circle.test;

import com.techlabs.circle.*;

public class PrintInfoTest {
	public static void main(String[] args) {

		Circle c1 = new Circle();
		c1.setColor("Green");
		printInfo(c1);

		Circle c2 = new Circle();
		c2.setColor("Red");
		printInfo(c2);
	}

	public static void printInfo(Circle c) {
		System.out.println(c.getColor());
		System.out.println(c.hashCode());
	}
}
