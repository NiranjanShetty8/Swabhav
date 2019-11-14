package com.techlabs.basic;

public class PassByValueTest {

	public static void main(String[] args) {

		int mark = 100;
		editMarksToZero(mark);
		System.out.println(mark);

		int[] grades = { 10, 20, 30, 40 };
		for (int i=0;i<grades.length;i++)
		{
			System.out.print("Previous " +grades[i] + " ");
		}
		editGradesToZero(grades);
		for (int g : grades) {
			System.out.println("new grades " +g);
		}
	}

	public static void editMarksToZero(int mark) {
		mark = 0;
		System.out.println("inside " +mark);
	}

	public static void editGradesToZero(int[] grade) {
		for (int i = 0; i < grade.length; i++) {
			grade[i] = 0;
		}
	}

}
