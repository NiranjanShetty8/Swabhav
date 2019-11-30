package com.techlabs.practice;

public class StringCounter {

	public static void main(String args[]) {

		char[] alphabets = { 'z', 'c', 'b', 'a', 'd','b' };
		char[] sort = new char[26];
		for (int i = 0; i < alphabets.length; i++) {
			char c = alphabets[i];
			if (c >= 97 && c <= 122) {
				sort[alphabets[i] - 97] = alphabets[i];
			}
		}
		for (char d : sort) {
			if (d == 0) {
				continue;
			}
			System.out.println(d);
		}

	}

}
