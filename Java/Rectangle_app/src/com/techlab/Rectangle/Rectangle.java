package com.techlab.Rectangle;

public class Rectangle {
	private double height;
	private double width;
	private final double LOWER_LIMIT = 1;
	private final double UPPER_LIMIT = 100;
	
	/*
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
	*/
	public void setHeight(double h)
	{
		
		if(h<LOWER_LIMIT) {
			h=1;
		}
		if(h>UPPER_LIMIT)
		{
			h =100;
		}
		height = h;
	}
	
	public double getHeight()
	{
		return height;
		
	}
	
	public void setWidth(double w)
	{
		
		if(w<LOWER_LIMIT) {
			w=1;
		}
		if(w>UPPER_LIMIT)
		{
			w =100;
		}
		width = w;
	}
	public double getWidth()
	{
		return width;
	}
	public double calculate()
	{
		double area = height* width;
		return area;
	}
}
