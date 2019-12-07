package com.techlabs.oddEven;

public class EvenOdd {

	public static void main(String[] args) {
		String [] color = {"Green", "Red","Red","Green", "Green"};
		//int[] evenOdds = { 10, 25, 30, 5, 7, 43, 64 };
		groupEvenOdd(color);
		for (String z : color) {
			System.out.println(z);
		}
	}

	public static void groupEvenOdd(String[] evenOdd) {
		String temp;
		int i = 0;
		int j = evenOdd.length - 1;
		while (i < j && j > i) {
			if (evenOdd[i] == "Green") {
				i++;
			}
			if (evenOdd[j] == "Red") {
				j--;
			}
			if (evenOdd[i] == "Red" && evenOdd[j] == "Green") {
				temp = evenOdd[i];
				evenOdd[i] = evenOdd[j];
				evenOdd[j] = temp;
				i++;
				j--;
			}
		}
	}

}






/*
 * public static int[] groupEvenOdd(int [] evenOdd) { int arrayEvenOdd[] = new
 * int[evenOdd.length]; int index = 0; int j = evenOdd.length - 1; for (int i =
 * 0; i < evenOdd.length; i++) {
 * 
 * if (evenOdd[i] % 2 == 0) { arrayEvenOdd[index] = evenOdd[i]; index++; } else
 * { arrayEvenOdd[j] = evenOdd[i]; j--; } } return arrayEvenOdd; }
 */

/*
 * int[] evenOdd = { 10, 25, 30, 5, 7 }; int temp; for (int i = 0;
 * i<evenOdd.length; i++) { for (int j = evenOdd.length-1; j>=0; j--) { if
 * (evenOdd[i]%2 != 0 && evenOdd[j]%2 ==0) { // temp = evenOdd[i]; evenOdd[j] =
 * evenOdd[i]; evenOdd[i] = evenOdd[j]; } if (evenOdd[i]%2 ==0 ) i++; if
 * (evenOdd[j]%2 !=0) j--; } } for (int k: evenOdd) { System.out.println(k); } }
 * 
 * public static int[] groupEvenOdd(int[] evenOddArray) { for (int i = 0; i <
 * evenOddArray.length; i++) if (evenOddArray[i] % 2 == 0) {
 * System.out.println("Even :" + i); } return evenOddArray; }
 */
