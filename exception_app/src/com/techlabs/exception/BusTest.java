package com.techlabs.exception;

public class BusTest {

	public static void main(String[] args) {

		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);

		int c = a / b;
		System.out.println(c);
		System.out.println("End of program");
		main(args);
	}

}
