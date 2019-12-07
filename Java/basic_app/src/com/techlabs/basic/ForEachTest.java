package com.techlabs.basic;

public class ForEachTest {

	public static void main(String[] args) {

		String[] names = {"a","b","c","d"};
		int[] numbers = {1,2,3,4,5};
		
		for (String name:names)
		{
			System.out.print(name);
		
		}
		System.out.println();
		for (int number:numbers)
		{
			
			System.out.print(number);
		}
		
		System.out.println(numbers[3]);
	}

}
