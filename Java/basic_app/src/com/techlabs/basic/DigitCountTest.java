package com.techlabs.basic;

public class DigitCountTest {

	public static void main(String[] args) {
		int no = 123454321;
		int i = 0;
		int reverse = 0;
		int numb = no;

		while (numb > 0) {
			reverse = reverse*10 + numb % 10;
			numb = numb / 10;
			i++;
		}
		
		

		System.out.println("No of digits : " + i);
		System.out.println("reverse : " + reverse);

		if(no == reverse)
		{
			System.out.println("Palindrome");
		}
	}

}

