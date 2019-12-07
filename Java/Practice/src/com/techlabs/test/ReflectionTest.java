package com.techlabs.test;

import com.techlabs.practice.*;

public class ReflectionTest {

	public static void main(String[] args) {
		Class<?> c1 = Reflection.class;
		ReflectionTest reflectObj = new ReflectionTest();
		reflectObj.printInfo(String.class);
		reflectObj.printInfo(Integer.class);
		reflectObj.printInfo(c1);

	}

	public void printInfo(Class<?> c) {
		Reflection rf = new Reflection();
		rf.getInfo(c);

		System.out.println("Name of the class is: " + c.getName());
		System.out.println("Number of constructors is: " + rf.noOfConstrcutors);
		System.out.println("Number of methods is: " + rf.noOfMethods);
		System.out.println("Number of getters is: " + rf.noOfGetters);
		System.out.println("Number of setters is: " + rf.noOfSetters);
	}

}
