package com.techlabs.annotations.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import com.techlabs.annotations.*;

public class FooTest {

	public static void main(String[] args) {

		int i = 0;
		Foo obj = new Foo();
//		Class<? extends Foo> cls = obj.getClass();
//		Method[] totalMethods = cls.getMethods();
		Method[] totalMethods = obj.getClass().getMethods();
		Method[] annoMethods = new Method[totalMethods.length];
		for (Method method : totalMethods) {
			if (method.getAnnotation(RequireRefactor.class) != null) {
				annoMethods[i] = method;
//				System.out.println(method.getName());
				i++;

			}
		}
		System.out.println("Number of annoted methods :" + i);
		for (Method met : annoMethods) {
			if (met != null)
				System.out.println(met.getName());
		}
	}

}

//	Annotation anno = methody.getAnnotation(RequireRefactor.class);
//RequireRefactor rf = (RequireRefactor)anno;
//if(rf.key() == 10);
//{
//	System.out.println(methody.getName());
//}