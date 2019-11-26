package com.techlabs.account;

public class EqualityTest {

	public static void main(String[] args) {
		Account acc1 = new Account("ABC", 101, 5000);
		Account acc2 = new Account("ABC", 101, 5000);
		System.out.println(acc1==acc2);
		System.out.println(acc1==acc1);
		System.out.println(acc1.equals(acc2));
		System.out.println(acc1.equals(acc2));

	}

	
}
