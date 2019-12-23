package com.techlabs.factory.method.test;

import com.techlabs.factory.method.*;

public class FactoryMethodTest {
	
	public static void main(String [] args) {
	IAutomobileFactory fact = BmwFactory.getInstance();
	IAutomobileFactory fact1 = BmwFactory.getInstance();
	

	IAutomobile auto1 = fact1.make();
	IAutomobile auto = fact.make();
	
	auto.start();
	auto.stop();
	auto1.start();
	System.out.println(fact1.hashCode() +" "+ fact.hashCode());
	
	}
}
