package com.techlabs.simple.factory.case2.test;

import com.techlabs.simple.factory.case2.*;

public class Case2 {

	public static void main(String[] args) {
		AutomobileFactory fact = AutomobileFactory.getInstance();
		IAutomobile auto = fact.make(AutoType.TESLA);
		auto.start();
		auto.stop();
	}

}
