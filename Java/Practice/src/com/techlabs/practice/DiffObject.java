package com.techlabs.practice;

import java.lang.reflect.Constructor;
import java.util.Properties;

public class DiffObject {

	public static void main(String[] args) throws Exception {
		PotatoBiscuit obj1 = new PotatoBiscuit();
		obj1.display();
		
		Class<?> cls = Class.forName("com.techlabs.practice.PotatoBiscuit");
		PotatoBiscuit obj2 = (PotatoBiscuit) cls.newInstance();
		obj2.display();

		PotatoBiscuit obj3 = (PotatoBiscuit) obj1.clone();
		obj3.display();
		System.out.println(obj1.hashCode() + " " + obj3.hashCode());
		
		Constructor<PotatoBiscuit> construct = PotatoBiscuit.class.getDeclaredConstructor();
		PotatoBiscuit obj4 = construct.newInstance();
		obj4.display();
	}

}
