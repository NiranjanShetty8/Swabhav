package com.techlabs.circle.test;

import com.techlabs.circle.*;

public class CircleTest {
	public static void main(String args[]) {
		Circle small = new Circle();
		small.setRadius(1.5f);
		System.out.println("Radius of small cirlce is :" +small.getRadius());
		small.setColor("RED");
		System.out.println("Color is " + small.getColor());
		System.out.println("Area is : " +small.calcArea());

		Circle big = new Circle();
		big.setRadius(9.5f);
		
		System.out.println("Radius of small cirlce is :" +big.getRadius());
		big.setColor("BLuE");
		System.out.println("Color is " + big.getColor());
		System.out.println("Area is : " +big.calcArea());
	}

}
