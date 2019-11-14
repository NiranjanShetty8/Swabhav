package com.techlabs.basic;

public class OverloadingTest {
	public static void main(String args[]) {
		System.out.println(10);
		System.out.println(10.5);
		System.out.println(10.5f);
		System.out.println('#');
		System.out.println(true);

		printInfo("Niranjan");
		printInfo(10);
		printInfo(10.5);
		printInfo(11.5f);
		printInfo('#');
		printInfo(false);
	}

	public static void printInfo(String text) {
		System.out.println(text);
	}

	public static void printInfo(int x) {
		System.out.println(x);
	}

	public static void printInfo(double d) {
		System.out.println("double" +d);
	}

	public static void printInfo(float f) {
		System.out.println(f);

	}

	public static void printInfo(boolean b)
	{
		System.out.println(b);
	}
	public static void printInfo(char x)
	{
		System.out.println(x);
	}

}
