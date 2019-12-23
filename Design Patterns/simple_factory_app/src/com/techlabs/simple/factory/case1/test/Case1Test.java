package com.techlabs.simple.factory.case1.test;

import com.techlabs.simple.factory.case1.*;

public class Case1Test {

	public static void main(String[] args) {
		AutomobileFactory fact = new AutomobileFactory();
		IAutomobile auto = fact.make(AutoType.TESLA);
		System.out.println(auto.getClass());
		auto.start();
		auto.stop();

	}

}
