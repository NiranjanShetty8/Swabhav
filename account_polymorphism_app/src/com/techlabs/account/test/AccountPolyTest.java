package com.techlabs.account.test;

import com.techlabs.account.*;

public class AccountPolyTest {

	public static void main(String[] args) {
		String error = "Cannot Process Transaction ";
		AccountPolyTest apt = new AccountPolyTest();
		Account niranjan;
		niranjan = new SavingsAccount(101, "Niranjan", 50000);
		try {
			niranjan.withdraw(49000);
		} catch (InsufficientFunds e) {
			System.out.println(error + e);
		}
		Account vivek = new CurrentAccount(102, "Vivek", 30000);
		try {
			vivek.withdraw(40001);
		} catch (InsufficientFunds e) {
			System.out.println(error + e);
		}
		vivek.deposit(10000);
		apt.printInfo(vivek);
		apt.printInfo(new CurrentAccount(103, "Ramesh", 10000));
		apt.printInfo(niranjan);
		System.out.println("Total number of Transactions: " + Account.getNoOfTransactions());
	}

	public void printInfo(Account acc) {
		System.out.println("Account number is: " + acc.getAccno());
		System.out.println("Account name is: " + acc.getName());
		System.out.println("Account balance is: " + acc.getBalance());

	}
}
