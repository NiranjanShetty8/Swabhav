package com.techlabs.self.practice;

public class StringCounter {

	public static void main(String[] args) {
		char[] alphabets = { 'g', 'r', 'b', 'r', 'g', 'b', 'r' };
		for (int i = 0,k=0, j = alphabets.length-1; i < alphabets.length
				&& j>0 && k<alphabets.length; i++) {
			if (alphabets[i]=='r') {
				alphabets[k] = 'r';
				k++;
				continue;
			} else if (alphabets[i]=='b') {
				alphabets[j] = 'b';
				j--;
				continue;
			}
		}

		for (char a : alphabets) {
			System.out.println(a);
		}

	}
}
