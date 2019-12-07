package com.techlabs.rule6;

public class Test1 {
	static String fname = "Niranjan Prasad Shetty";
	static int no = 20;
	static int s_no = 34;
	static float b = 27f;
	static double sum;

	public static void main(String[] args) {
		a();
		System.out.println(sum);
		System.out.println(fname);

	}

	public static void a() {
		sum = no + s_no + b;
	}

}
