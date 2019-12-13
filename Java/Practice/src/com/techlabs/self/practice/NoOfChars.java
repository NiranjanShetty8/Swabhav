package com.techlabs.self.practice;

public class NoOfChars {

	public static void main(String[] args) {
		String name = "niranjan shetty";
		int[] count = new int[26];
		char[] nameArray = name.toCharArray();
		for (char a : nameArray) {
			if (a != ' ') {
				count[charValue(a)]++;
			}
		}
		for (int n = 0; n < count.length; n++) {
			if (count[n] != 0) {
				System.out.println(intValue(n) + " occurs " + count[n] + " times");
			}
		}
	}

	public static int charValue(char a) {
		int no = a - 97;
		return no;
	}

	public static char intValue(int i) {
		i = i + 97;
		char alpha = (char) i;
		return alpha;
	}
}
