package com.techlabs.practice;

public class NumberCounter {
	public static void main(String[] args) {
		int[] num = { 10, 10, 20, 20, 20, 30, 30, 30,40,50,50,60 };
		int count = 1;
		for(int i =0;i < num.length;i++) {
			if (i<num.length-1 && num[i] == num[i + 1] ) {
				count++;
			} else {
				System.out.println("The number " + num[i] + " occurs: " + count +"times");
				count = 1;
			}
		}
	}
}
