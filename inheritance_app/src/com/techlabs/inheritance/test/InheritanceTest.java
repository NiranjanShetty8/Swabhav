package com.techlabs.inheritance.test;

import com.techlabs.inheritance.*;

public class InheritanceTest {

	public static void main(String[] args) {
		InheritanceTest inheritobj = new InheritanceTest();
		inheritobj.case1();
		inheritobj.case2();
		inheritobj.case3();
		inheritobj.case4();
		inheritobj.case5();

	}

	public void case1() {
		Man x;
		x = new Man();
		x.plays();
		x.reads();
	}

	public void case2() {
		Boy y;
		y = new Boy();
		y.plays();
		y.eats();
		y.reads();
	}

	public void case3() {
		Man x;
		x = new Boy();
		x.plays();
		x.reads();
	}

	public void case4() {
		atThePark(new Man());
		atThePark(new Boy());
		atThePark(new Kid());
		atThePark(new Infant());
	}

	public void case5() {
		Object x;
		x = 10;
		System.out.println(x.getClass());
		x = "Hello";
		System.out.println(x.getClass());
		x = new Man();
		System.out.println(x.getClass());
	}

	public void atThePark(Man x) {
		System.out.println("At the park");
		x.plays();
	}

}
