package com.techlabs.rectangle;

enum BorderStyleOptions {
	SOLID, SINGLE, DOUBLE
}

public class Rectangle {
	private int width;
	private int height;
	private BorderStyleOptions borderStyle;

	public Rectangle(int newWidth, int newHeight, BorderStyleOptions options) {
		width = newWidth;
		height = newHeight;
		borderStyle = options;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public BorderStyleOptions getBorderStyle() {
		return borderStyle;
	}

	public double calcArea() {
		double area = height * width;
		return area;
	}
}
