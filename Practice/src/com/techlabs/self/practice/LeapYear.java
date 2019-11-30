package com.techlabs.self.practice;

public class LeapYear {

	public static void main(String args[]) {
		LeapYear lp = new LeapYear();
		lp.isLeapYear(1);

	}

	public boolean isLeapYear(int year) {
		//for (int check = 0; check < 3000; check = check + 4) {
			if (year % 4 ==0) {					//if 1,5,9.. was a leap year year -1
				System.out.println(year +" is a leap year");
				return true;
			}
			

		//}
		System.out.println(year + "is not a leap year");
		return false;
	}
}
