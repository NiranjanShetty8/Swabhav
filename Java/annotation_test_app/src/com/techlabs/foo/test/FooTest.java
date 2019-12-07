package com.techlabs.foo.test;

import java.lang.reflect.*;

import co.techlabs.foo.*;

public class FooTest {
	static int passing = 0;
	static int failing = 0;
	static int noOfTests = 0;

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

//		int i = 0;
		Foo obj = new Foo();
		Class<? extends Foo> cls = obj.getClass();
		Method[] methods = cls.getMethods();
//		Method[] annoMethods = new Method[methods.length];
		
		for (Method m : methods) {
				if (m.isAnnotationPresent(TestCase.class)) {
//					if(m.invoke(obj, null))
					if((boolean) m.invoke(obj, null)) {
//					annoMethods[i] = m;
					passing++;
					noOfTests++;
//					i++;
				} else if (!(boolean) m.invoke(obj, null)) {
//					annoMethods[i] = m;
					failing++;
					noOfTests++;
//					i++;
				}
			}
		}
//		System.out.println("Annoted Methods: ");
//		for(Method m : annoMethods) {
//			if(m != null) {
//				System.out.println(m.getName());
//			}
//		}
		
		System.out.println("No of test cases: " + noOfTests);
		System.out.println("Passing cases: " + passing);
		System.out.println("Failing cases: " + failing);

	}

}
