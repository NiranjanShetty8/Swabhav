package com.techlabs.testpapers;

public class SubLex {
	public static void main(String args[]) {
		if (isSubString("beat", "bat")) {
			System.out.println("Substring");
			return;
		}
		System.out.println("Not a Substring");
		
		System.out.println(compare("geeksb", "geeksa"));
	}

	public static boolean isSubString(String string, String subString) {
		char[] stringArray = string.toCharArray();
		char[] subStringArray = subString.toCharArray();
		int subStringCounter = 0;
		int storedCounter = 0;
		int stringLength = string.length();
		int subStringLength = subString.length();
		if (subStringLength > stringLength) {
			return false;
		}
		for (int counter = 0; counter < stringLength; counter++) {
			if (stringArray[counter] == subStringArray[subStringCounter]) {
				if (subStringCounter == subStringLength - 1) {
					return true;
				}
				subStringCounter++;
				continue;
			}
			subStringCounter = 0;
			counter = storedCounter;
			storedCounter++;
		}
		return false;
	}

	public static int compare(String string1, String string2) {
		
		char[] string1Array = string1.toCharArray();
		char[] string2Array = string2.toCharArray();
		int string1Length = string1.length();
		int string2length = string2.length();
		int limit = string1Length;
		int i = 0;
		if (string1Length > string2length) {
			limit = string2length;
			i = 1;
		} else if (string2length > string1Length) {
			limit = string1Length;
			i = -1;
		} 

		for (int counter = 0; counter < limit; counter++) {
			if (string1Array[counter] * 1 == string2Array[counter] * 1) {
				if (counter == limit - 1) {
					return i;
				}
				continue;
			} else if (string1Array[counter] * 1 > string2Array[counter] * 1) {
				return 1;
			}
		}
		return -1;

	}
}
