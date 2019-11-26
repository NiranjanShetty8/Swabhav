package com.techlabs.practice;

public class Wrappers {

	public static void main(String[] args) {
		int i =5;
		Integer ii = new Integer(i);			//boxing
		int value = ii;							//unboxing
		System.out.println(value);
		
		int j = 10;
		Integer auto = j;						//autoboxing
		int k = auto;							//autounboxing
		System.out.println(k);
	}

}
