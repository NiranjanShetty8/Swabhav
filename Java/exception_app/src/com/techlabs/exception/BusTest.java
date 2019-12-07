package com.techlabs.exception;

public class BusTest {

	public static void main(String[] args) {

		try {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);

		int c;
		
			c = a / b;
			System.out.println(c);
		}catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Only numbers are allowed for this operation");
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("illegal to divide by zero");
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Out of bounds");
		} catch (Exception e) {
			System.out.println("Errorr");
		}
		
		
		System.out.println("End of program");
	
	}

}
