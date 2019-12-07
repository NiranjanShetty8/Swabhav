package com.techlabs.oddEven;

public class EvenTest {

	public static void main(String[] args) {
		printEven(20);
		int[] nos = getEven(20);
		for (int z : nos) {
			System.out.println("Even numbers in the array : " + z);
		}
	}

	public static void printEven(int k) {
		for (int i = 0; i <= k; i++) {
			if (i % 2 == 0)
				System.out.println("Even number : " + i);
		}
	}

	public static int[] getEven(int range) {
		int[] evens = new int[range / 2 + 1];
		int d = 0;
		for (int i = 0; i <= range; i++) {
			if (i % 2 == 0) {
				evens[d] = i;
				d++;
			}

		}
		return evens;
	}
}
