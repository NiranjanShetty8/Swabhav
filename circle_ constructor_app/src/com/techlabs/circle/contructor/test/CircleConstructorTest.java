package com.techlabs.circle.contructor.test;

import com.techlabs.circle.constrcutor.*;

public class CircleConstructorTest {

	public static void main(String[] args) {

		Circle[] circleArray = { new Circle(3.5f, "Green"), new Circle(4.5f, "Red"),

				new Circle(7.5f, "Blue") };
		printInfo(circleArray);
	}

	public static void printInfo(Circle c1) {
		System.out.println("Radius is : " + c1.getRadius());
		System.out.println("Color is : " + c1.getColor());
		System.out.println("Area is : " + c1.calcArea());
	}

	public static void printInfo(Circle[] cArray) {
		for (Circle ptr : cArray) // READ
		{
			printInfo(ptr);
		}
	}
}
