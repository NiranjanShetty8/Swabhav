package com.techlabs.practice;

public class StringCounter {
	public static void main(String args[]) {
		StringCounter scobj = new StringCounter();
		String name = "niranjan";
		int count = 1;
		int largest = 0;
		char[] arrName = name.toCharArray();
		arrName.hashCode();
		scobj.sortArray(arrName);
		for(char k:arrName) {
			System.out.println(k);
		}
		
		}

	public char[] sortArray(char[] toBeSorted) {
		char temp;
		for(int i=0;i<toBeSorted.length-1;i++)
		{
			if(toBeSorted[i]>toBeSorted[i+1])
			{
				temp = toBeSorted[i];
				toBeSorted[i] = toBeSorted[i+1];
				toBeSorted[i+1] = temp;
			}
		}
		return toBeSorted;
		
	}

}
