package com.techlabs.account.test;

import com.techlabs.account.*;

public class AccountPolyTest {

	public static void main(String[] args) {
		AccountPolyTest apt = new AccountPolyTest();
		Account niranjan;
		niranjan = new SavingsAccount(101,"Niranjan",50000); 
		niranjan.withdraw(49000);
		apt.printInfo(niranjan);
		Account vivek = new CurrentAccount(102,"Vivek",30000);
		vivek.withdraw(4000);
		apt.printInfo(vivek);
	}

	public void printInfo(Account acc) {
		System.out.println("Account number is: " +acc.getAccno());
		System.out.println("Account name is: " +acc.getName());
		System.out.println("Account balance is: " +acc.getBalance());
	}
}
