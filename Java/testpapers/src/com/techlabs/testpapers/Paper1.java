package com.techlabs.testpapers;

public class Paper1 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		String x = "000001011110110010100010000000111110101001010100100100101000000000110000111010101"
				+ "010010111101110000000110100101010101101000000010110101001101100111100011100000000101"
				+ "010111001100010111010000000011110110010100010000000111000100000101011101111000000100"
				+ "110101010110110";
		String y = solution("The quick brown fox jumps over the lazy dog");
		System.out.println(x.equals(y));
	    String i = "000001110000111010100000010100111000111000100010";
	    String j = solution("Braille");
	    System.out.println(i.equals(j));

    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime) + " ns"); 
	}

	public static String solution(String str) {
		char[] chArray = str.toCharArray();
		StringBuilder finalString = new StringBuilder();
		for (char a : chArray) {
			finalString.append(charToString(a));
		}
		return  finalString.toString();
	}

	public static String charToString(char c) {

		if (Character.isUpperCase(c)) {
			c = Character.toLowerCase(c);
			return "000001" + charToString(c);
		} else if (c == ' ') {
			return "000000";
		}
		switch (c) {

		case 'a':
			return "100000";
		case 'b':
			return "110000";
		case 'c':
			return "100100";
		case 'd':
			return "100110";
		case 'e':
			return "100010";
		case 'f':
			return "110100";
		case 'g':
			return "110110";
		case 'h':
			return "110010";
		case 'i':
			return "010100";
		case 'j':
			return "010110";
		case 'k':
			return "101000";
		case 'l':
			return "111000";
		case 'm':
			return "101100";
		case 'n':
			return "101110";
		case 'o':
			return "101010";
		case 'p':
			return "111100";
		case 'q':
			return "111110";
		case 'r':
			return "111010";
		case 's':
			return "011100";
		case 't':
			return "011110";
		case 'u':
			return "101001";
		case 'v':
			return "111001";
		case 'w':
			return "010111";
		case 'x':
			return "101101";
		case 'y':
			return "101111";
		default:
			return "101011";
		}
	}

}
