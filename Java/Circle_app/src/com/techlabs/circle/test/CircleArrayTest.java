package com.techlabs.circle.test;

import com.techlabs.circle.*;

public class CircleArrayTest {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		c1.setRadius(1.5f);
		Circle c2 = new Circle();
		c2.setRadius(7.5f);
		Circle c3 = new Circle();
		c3.setRadius(9.5f);
		Circle[] circleArray = { c1, c2, c3};

		printInfo(circleArray);
		System.out.println("Total Area is : " + sumOfArea(circleArray));

		System.out.println("Largest Circle is :" + largestCircle(circleArray));
		System.out.println("Largest radius : " + largestCircle(circleArray).getRadius());
		System.out.println("Largest area : " + largestCircle(circleArray).calcArea());

	}

	public static double sumOfArea(Circle[] c) {
		double area = 0;
		for (int j = 0; j < c.length; j++) {
			area = area + c[j].calcArea();

		}
		return area;
	}

	public static Circle largestCircle(Circle[] c) {
		int j = 1;
		Circle largest = c[0];                     //points to first circle
		while (j < c.length) {
			if (c[j].getRadius() > largest.getRadius()) {
				largest = c[j];
			} else
				j++;
		}
		return largest;
	}

	public static void printInfo(Circle[] c) {
		for (Circle i : c) {
			System.out.println(i.getRadius());
			System.out.println(i.calcArea());
		}
	}
}

/*
 * public static void largestCircle(Circle[] c) { int j = 0; float largest = 0;
 * while (j < c.length - 1) { if (c[j].getRadius() > c[j + 1].getRadius()) {
 * largest = c[j].getRadius(); } else { largest = c[j + 1].getRadius(); } j++; }
 * if (largest == c[j].getRadius()) {
 * System.out.println("Largest Circle is with  Radius : " + c[j].getRadius());
 * System.out.println("It's area is : " + c[j].calcArea()); } else {
 * System.out.println("Largest Circle is with radius : " + c[j +
 * 1].getRadius()); System.out.println(c[j + 1].calcArea()); } }
 */