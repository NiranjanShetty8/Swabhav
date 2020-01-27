package com.techlabs.testpapers;

public class Pegs {

	public static void main(String[] args) {
		int[] send = { 4, 17, 20, 33, 50 };
		int[] returnArr = getRadius(send);
		for (int no : returnArr) {
			System.out.println(no);
		}

	}

	public static int[] getRadius(int[] arr) {
		int arrSize = arr.length;
		int[] notPossible = { -1, -1 };
		int[] possible = new int[2];
		if (arrSize < 2) {
			return notPossible;
		}
		int countOfOthers = arrSize - 2;
		int firstIndex = arr[0];
		int lastIndex = arr[arrSize - 1];
		if (arrSize == 2) {
			int diff = arr[1] - arr[0];
			for (int i = 2; i < diff; i = i + 2) {
				if (i + i / 2 == diff) {
					possible[0] = i;
					possible[1] = 1;
					return possible;
				}
			}
		}
		for (int lengthFirst = 12; lengthFirst < 99; lengthFirst = lengthFirst + 2) {
			
			int lengthLast = lengthFirst / 2;
			int displacementFirst = firstIndex + lengthFirst;
			int displacementSecond = lastIndex - lengthLast;
			int gap = displacementSecond - displacementFirst;
			if (countOfOthers == 1) {
				if (gap % 2 == 0 && (displacementSecond - gap / 2) == arr[1]) {
					possible[0] = lengthFirst;
					possible[1] = 1;
					return possible;
				}
			}
		}
		int j = 0;
		while (j < arr.length) {
			int temp= j;
			for (int k = j; k < countOfOthers; k++) {
				int lengthOfLast = arr[temp] + j;
				int reqNo = arr[k + 1] - lengthOfLast;
				System.out.println(reqNo);
				temp+=1;

			}
			j+=1;
		}
		return notPossible;
	}

}
