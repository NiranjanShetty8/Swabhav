package com.techlabs.testpapers;

public class Solution {
	    private static final String arrString[] = { "100000", "110000", "100100", "100110", "100010", "110100", "110110", "110010",
				"010100", "010110", "101000", "111000", "101100", "101110", "101010", "111100", "111110" , "111010" , "011100" ,
				"011110", "101001" , "111001" , "010111" , "101101" , "101111" , "101011" };
	    
	    public static String solution(String str) {
	    	char[] chArray = str.toCharArray();
			String finalString = "";
			for (char current : chArray) {
				finalString += brailleToString(current);
			}
			return finalString;
	    }
	    
	    private static String brailleToString(char letter) {
			if (Character.isUpperCase(letter)) {
				letter = Character.toLowerCase(letter);
				return "000001" + arrString[letter - 97];
			} else if (letter == ' ') {
				return "000000";
			}
			return arrString[letter*1 - 97];
	}
 
    public static void main(String[] args) {
    	long startTime = System.nanoTime();
    	String y = solution("Braille");
    	String x = "000001110000111010100000010100111000111000100010";
    	System.out.println(x.equals(y));
    	System.out.println(y);
    	String xx = "000001011110110010100010000000111110101001010100100100101000000000110000111010101"
				+ "010010111101110000000110100101010101101000000010110101001101100111100011100000000101"
				+ "010111001100010111010000000011110110010100010000000111000100000101011101111000000100"
				+ "110101010110110";
		String yy = solution("The quick brown fox jumps over the lazy dog");
		System.out.println(xx.equals(yy));
    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime) + " ns"); 
    }
}

