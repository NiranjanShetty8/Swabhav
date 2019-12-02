package com.techlabs.unchecked.exception.test;

import javax.management.RuntimeOperationsException;

import com.techlabs.checked.exception.test.CheckedExceptionTest;

public class UncheckedExceptionTest {

	public static void main(String[] args){
		CheckedExceptionTest cet = new CheckedExceptionTest();
			try {
				cet.m1();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		System.out.println("End of Program");
	}

	public void m1(){
		m2();
	}

	public void m2() {
		m3();
	}

	public void m3() throws RuntimeException{
		throw new RuntimeException("Something went wrong");

	}
}
