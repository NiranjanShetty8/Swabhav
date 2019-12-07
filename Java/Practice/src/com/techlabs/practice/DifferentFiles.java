package com.techlabs.practice;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class DifferentFiles {
	public static void main(String [] args) throws Exception {

		String loc = "D:\\Swabhav\\Swabhav\\Practice\\File.properties";
		Constructor<Properties> construct = Properties.class.getDeclaredConstructor();
		Properties p1 = construct.newInstance();
		OutputStream os = new FileOutputStream(loc);
		p1.setProperty("Name", "Niranjan");
		p1.setProperty("Location", "Kurla");
		p1.setProperty("Mobile", "Poco");
		
		p1.store(os, "Personal Details");
		System.out.println("Done.");
		
		InputStream is = new FileInputStream(loc);
		p1.load(is);
		System.out.println(p1.getProperty("Name"));
		p1.list(System.out);
		
		
}
}
