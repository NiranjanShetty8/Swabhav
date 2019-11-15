package com.techlab.Rectangle;

public class Rectangle {
	private double height;
	private double width;
	
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
		
		if(h<1) {
			h=1;
		}
		if(h>100)
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
		
		if(w<1) {
			w=1;
		}
		if(w>100)
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
