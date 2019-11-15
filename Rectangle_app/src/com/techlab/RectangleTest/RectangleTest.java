package com.techlab.RectangleTest;
import com.techlab.Rectangle.*;

public class RectangleTest {

	public static void main(String[] args) {

		Rectangle small = new Rectangle();
		small.setHeight(-2);
		System.out.println("The height of small rectangle is :" +small.getHeight());		
		small.setWidth(7);
		System.out.println("The width of small rectangle is :" +small.getWidth());
		
		System.out.println("Area of the small rectangle is " +small.calculate());
		
		Rectangle big = new Rectangle();
		big.setHeight(9000);
		System.out.println("The height of big rectangle is :" +big.getHeight());		
		big.setWidth(12);
		System.out.println("The width of big rectangle is :" +big.getWidth());
		
		System.out.println("Area of the big rectangle is " +big.calculate());
		
	}

}
