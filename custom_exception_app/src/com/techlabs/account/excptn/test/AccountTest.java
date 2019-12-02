package com.techlabs.account.excptn.test;

import com.techlabs.account.exceptn.InsufficientFundsException;
import com.techlabs.account.exceptn.Account;

public class AccountTest {

	public static void main(String[] args) {
		Account niranjan = new Account("Niranjan", 101, 800);
		niranjan.deposit(1200);
		try {
			niranjan.withdraw(1800);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		printInfo(niranjan);

		Account shaam = new Account("Shaam", 102);
		printInfo(shaam);

	}

	public static void printInfo(Account acc) {
		System.out.println("Account name: " + acc.getaccountName());
		System.out.println("Account number: " + acc.getaccountNumber());
		System.out.println("Balance is " + acc.getBalance());

	}
}