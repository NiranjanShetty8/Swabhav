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
    	String y = solution("Braille");
    	String x = "000001110000111010100000010100111000111000100010";
    	System.out.println(x.equals(y));
    	System.out.println(y);
    }
}

