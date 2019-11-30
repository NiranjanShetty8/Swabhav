package com.techlabs.poly.test;

import com.techlabs.poly.*;

public class PolyTest {
	public static void main(String args[]) {
		Person teacher = new Teacher();
		teacher.does();
		
		Student student = new Student();
		student.does();
		
		Person parent;
		parent = new Parent();
		parent.does();

}
}