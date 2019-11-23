package com.techlabs.person.test;

import com.techlabs.person.*;

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person("Niranjan", 25, GenderOptions.MALE, 5.11f, 80f);

		// p1.workOut();
		p1.eat();
		printInfo(p1);

		Person p2 = new Person("Raja", 25);
		// p2.workOut();
		p2.eat();

		// printInfo(p2);

	}

	public static void healthStatus(Person p) {
		double bmis = p.getBmi();
		if (bmis < 18.5) {
			System.out.println("UnderWeight");
		} else if (bmis >= 18.5 && bmis < 25.00) {
			System.out.println("Normal");
		} else if (bmis >= 25.00 && bmis < 30.00) {
			System.out.println("OverWeight");
		} else if (bmis >= 30.00 && bmis < 35.00) {
			System.out.println("Obese");
		} else {
			System.out.println("Extremely Obese");
		}
	}

	public static void printInfo(Person p) {
		System.out.println("The name of the person is: " + p.getName());
		System.out.println("The age of the person is: " + p.getAge());
		System.out.println("The gender of the person is: " + p.getGender());
		System.out.println("The height of the person is: " + p.getHeight() + " foot");
		System.out.println("The weight of the person is: " + p.getWeight() + "kg");
		System.out.println("The BMI is: " + p.getBmi());
		healthStatus(p);
	}
}
