package com.techlabs.constructor.case2.test;

import com.techlabs.constructor.case2.*;

public class Test {

	public static void main(String[] args) {
		Parent pobj = new Parent(100);
		System.out.println(pobj.getFoo());
		System.out.println(new Parent(120).getFoo());
		System.out.println(new Child().getFoo());
		System.out.println(new Child(50).getFoo());

	}

}
