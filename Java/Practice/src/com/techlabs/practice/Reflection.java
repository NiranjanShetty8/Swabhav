package com.techlabs.practice;

import java.lang.reflect.*;

public class Reflection {
	public int noOfMethods;
	public int noOfConstrcutors;
	public int noOfGetters;
	public int noOfSetters;

	public void getInfo(Class c) {
		Constructor[] construct = c.getConstructors();
		noOfConstrcutors = construct.length;

		Method[] methods = c.getMethods();
		noOfMethods = methods.length;

		for (Method local : methods) {
			String methodName = local.getName();
			if (methodName.startsWith("get")) {
				noOfGetters++;
			}
			if (methodName.startsWith("set")) {
				noOfSetters++;
			}
		}

	}
}
