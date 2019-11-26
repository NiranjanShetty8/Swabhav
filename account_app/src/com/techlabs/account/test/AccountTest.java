package com.techlabs.account.test;

import com.techlabs.account.Account;

public class AccountTest {

	public static void main(String[] args) {
		Account niranjan = new Account("Niranjan", 101, 800);
		niranjan.deposit(1200);
		niranjan.withdraw(1600);
		printInfo(niranjan);

		Account shaam = new Account("Shaam", 102);
		printInfo(shaam);

	}

	public static void printInfo(Account acc) {
		System.out.println("Account name: " + acc.getaccountName());
		System.out.println("Account number: " + acc.getaccountNumber());
		if (acc.result == false) {
			System.out.println("Minimum balance should be more than 500");
			System.out.println("Balance is " + acc.getBalance());
			return;

		}
		System.out.println("Balance is " + acc.getBalance());
	}
}
