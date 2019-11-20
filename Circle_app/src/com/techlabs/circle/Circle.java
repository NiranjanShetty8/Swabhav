package com.techlabs.circle;

public class Circle {
	private float radius;
	final float UPPER_LIMIT = 10;
	final float LOWER_LIMIT = 1;
	private String color;

//	public Circle(float newRadius) {
//		setRadius(newRadius);
//		printInfo();
//
//	}
	public void setRadius(float newRadius) {
		if (newRadius < LOWER_LIMIT) {
			radius = 1f;
		} else if (newRadius > UPPER_LIMIT) {
			radius = 10f;
		} else {
			radius = newRadius;
		}
	}

	public float getRadius() {
		return radius;
	}

	public void setColor(String newColor) {
		if (newColor.equalsIgnoreCase("Green") || newColor.equalsIgnoreCase("Red")
				|| newColor.equalsIgnoreCase("Blue")) {
			color = newColor;
		} else {
			color = "Green";

		}

	}

	public String getColor() {
		return color;
	}

	public double calcArea() {
		double area = radius * 3.142 * 3.142;
		return area;
	}

//	public void printInfo() {
//		System.out.println("Radius is : " + radius);
//		System.out.println("Area is : " + calcArea());
//	}

}
