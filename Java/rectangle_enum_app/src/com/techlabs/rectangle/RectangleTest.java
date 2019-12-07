package com.techlabs.rectangle;

public class RectangleTest {

	public static void main(String[] args) {
		Rectangle rect = new Rectangle(10, 20, BorderStyleOptions.SOLID);
		printInfo(rect);
	}

	public static void printInfo(Rectangle newRect) {
		System.out.println("The height is: " + newRect.getHeight());
		System.out.println("The width is: " + newRect.getWidth());
		System.out.println("The border-style is: " + newRect.getBorderStyle());
		System.out.println("The area is: " + newRect.calcArea());
	}

}
