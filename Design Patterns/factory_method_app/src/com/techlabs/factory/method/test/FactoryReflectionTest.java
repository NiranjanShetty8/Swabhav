package com.techlabs.factory.method.test;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;
import com.techlabs.factory.method.*;

public class FactoryReflectionTest {

	public static void main(String[] args) {
		FactoryReflectionTest frt = new FactoryReflectionTest();
		IAutomobileFactory fact;
		try {
			fact = frt.reflectFactory();
			IAutomobile auto = fact.make();
			auto.start();
			auto.stop();
			System.out.println(fact.hashCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public IAutomobileFactory reflectFactory() throws Exception {
		String location = "D:\\Swabhav\\Swabhav\\OOAD\\factory_method_app\\fact.properties";
		InputStream is = new FileInputStream(location);
		Properties p1 = new Properties();
		p1.load(is);
		String className = p1.getProperty("factory");
		Class<?> c1 = Class.forName(className);
		
//		Method[] methods = c1.getDeclaredMethods();
//		Method method = null;
//		for(Method m : methods) {
//			if(m.getName()=="getInstance") {
//				method = m;
//			}
//		}
		
		Method method = c1.getDeclaredMethod("getInstance", null);
		IAutomobileFactory fact = (IAutomobileFactory) method.invoke(null, null);
		
		return fact;

	}

}
