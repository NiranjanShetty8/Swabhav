package com.techlabs.rule6;

public class Test2 {
	static String fullname = "Niranjan Prasad Shetty";
	static int number = 20;
	static int second_number = 34;
	static float third_number = 27f;
	static double sum;

	public static void main(String[] args) {
		doSum();
		System.out.println(sum);
		System.out.println(fullname);

	}

	public static void doSum() {
		sum = number + second_number + third_number;
	}

}
