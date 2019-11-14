package com.techlab.Rectangle;

public class Rectangle {
	private double height;
	private double width;
	
	public void small()
	{
		height = 2;
		width = 7;
		System.out.println("Length of small rectangle " +height);
		System.out.println("Breadth of small rectangle " +width);
		calculate();
}
	public void big()
	{
		height = 10;
		width = 12;
		System.out.println("Length of big rectangle " +height);
		System.out.println("Breadth of big rectangle " +width);
		calculate();
}
	public void calculate()
	{
		double area = height* width;
		System.out.println("Area of the rectangle is " +area);
	}
}
