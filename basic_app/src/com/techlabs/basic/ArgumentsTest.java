package com.techlabs.basic;

public class ArgumentsTest {

	public static void main(String[] args) {

		System.out.println(args.length);
		if (args.length == 0) {
			System.out.println("Please enter an argument");

		}

		for (int i = 0; i < args.length; i++) {
			System.out.println("hello" + " " + args[i]);

		}

	}

}
