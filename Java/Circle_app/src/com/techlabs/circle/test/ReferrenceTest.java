package com.techlabs.circle.test;

import com.techlabs.circle.*;

public class ReferrenceTest {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		c1.setRadius(2.5f);
		c1.setColor("red");

		Circle temp = c1;
		System.out.println(temp.getColor());
		System.out.println(c1.getColor());

		temp.setColor("green");
		System.out.println(temp.getColor());
		System.out.println(c1.getColor());

		// temp = null;
		System.out.println(c1.getColor());
		System.out.println(temp.getColor());

		Circle c2 = new Circle();
		c2.setRadius(1.5f);

		Circle c3 = new Circle();
		c3.setRadius(1.5f);

		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		System.out.println(c1.hashCode());
		System.out.println(temp.hashCode());

	}

}
