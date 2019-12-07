package com.techlabs.person.test;

import com.techlabs.person.*;

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person("Niranjan", 25, "Male", 5.11f, 80.00f);
		//p1.workOut();
		p1.eat();
		printInfo(p1);
		Person p2 = new Person("Raja", 25);
		// p2.workOut();
		p2.eat();
		printInfo(p2);

	}

	public static void printInfo(Person p) {
		System.out.println("The name of the person is: " + p.getName());
		System.out.println("The age of the person is: " + p.getAge());
		System.out.println("The gender of the person is: " + p.getGender());
		System.out.println("The height of the person is: " + p.getHeight() + " foot");
		System.out.println("The weight of the person is: " + p.getWeight() + "kg");
	}
}
