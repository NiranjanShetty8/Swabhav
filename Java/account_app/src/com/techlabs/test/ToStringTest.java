package com.techlabs.test;

import com.techlabs.account.Account;

public class ToStringTest {

	public static void main(String[] args) {
		Account acc1 = new Account("Niranjan", 102, 1000);
		System.out.println(acc1.toString());
		System.out.println(acc1);
	}
}
