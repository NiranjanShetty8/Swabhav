package com.techlabs.code.magnets;

import com.techlabs.practice.Inheritance;

public class InheritanceTest extends Inheritance {
	
	@Override
	public void showName() {
		System.out.println("Niranjan");
	}
	public static void main(String[] args) {
		InheritanceTest obj1 = new InheritanceTest();
		Inheritance obj = new Inheritance();
		obj1.showName();
		obj.display();
	}

}