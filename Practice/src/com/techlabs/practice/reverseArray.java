package com.techlabs.practice;

import java.util.Arrays;

public class reverseArray {

	public static void main(String[] args) {
		char temp;
		int[] numbers = { 10, 30, 20, 50, 60, 18,10,99};
		char[] alphabets = {'d','b','c','a','m','e'};
		int[] store = new int[100];
		
		//Arrays.sort(alphabets);
		for(int i =0;i<alphabets.length; i++) {
			for(int j=i+1; j<alphabets.length;j++) {
				if(alphabets[i]>alphabets[j]) {
					temp = alphabets[i];
					alphabets[i] = alphabets[j];
					alphabets[j] = temp;
				}
			}
		}
		for (int show = alphabets.length - 1; show >= 0; show--) {
			System.out.println(alphabets[show]);
		}
		
		
//		for(int i =0;i<numbers.length ; i++) {
//			if(store[numbers[i]]!=0) {
//				store[numbers[i]+1]= numbers[i];
//				
//			}
//				store[numbers[i]]= numbers[i];
//		}
		
		
		//System.out.println(alphabets[0]);
		
		for(int j=0;j< store.length; j++) {
				if(store[j]!=0) {
				System.out.println(store[j]);
			}
		}
//		
//		 Arrays.sort(numbers);
		for(int i =0 ; i<numbers.length; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				if(numbers[i]>numbers[j]) {
					numbers[i] = numbers[j]+numbers[i];
					numbers[j] = numbers[i]-numbers[j];
					numbers[i] = numbers[i]- numbers[j];
				}
			}
		}

		
		for (int show = numbers.length - 1; show >= 0; show--) {
			System.out.println(numbers[show]);
		}
	}
}
