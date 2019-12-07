package com.techlabs.checked.exception.test;

public class CheckedExceptionTest {

	public static void main(String[] args){
		CheckedExceptionTest cet = new CheckedExceptionTest();
		try {
			cet.m1();
		} catch (Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
		}
		System.out.println("End of Program");
	}

	public void m1() throws Exception {
		m2();
	}

	public void m2() throws Exception {
		m3();
	}

	public void m3() throws Exception {
		throw new Exception("Something went wrong");

	}
}
