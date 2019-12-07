package com.techlabs.practice;

import java.io.IOException;

public class TryTest {

	public static void main(String[] args) {
		TryTest tt = new TryTest();
		try {
			tt.test(0);
		} catch (MyException e) {
			System.out.println("inside catch2 " +e);
		}
		int i = 9;
		try {
			if (i < 10) {
				throw new IOException("error1");
			}
				System.out.println("Hello");
		} catch (IOException e) {
			System.out.println("inside catch1 " +e);
		} finally {
			System.out.println("bye");
		}
	}

	public void test(int number) throws MyException {
		System.out.println("Inside Test");
		if(number==0)
		throw new MyException("error2");
		return;
	}
}
