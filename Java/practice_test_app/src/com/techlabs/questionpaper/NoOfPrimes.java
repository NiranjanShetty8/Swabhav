package com.techlabs.questionpaper;

import java.util.ArrayList;

public class NoOfPrimes {
	public static void main(String[] args) {
		int[] primeNumbers = new int[1000];
		for(int i =3,k = 0; i<82 && k<82;i++) {
			for(int j=2; j<=i;j++) {
				if(i==j) {
					continue;
				}
				else if(i%j==0) {
					break;
				}
				else if(i%j!=0 && j>i/2) {
					primeNumbers[k]=i;
					k++;
					break;
				}
			}
		}
		
		for(int q : primeNumbers) {
			if(q!=0)
			System.out.println(q);
		}
		
	}

}
