package com.techlabs.account;

public class SavingsAccount extends Account {
	public SavingsAccount(int accNo, String name, double balance) {
		super(accNo, name, balance);
	}

	public void withdraw(double amt) throws InsufficientFunds {
		if (super.balance - amt < super.LOWER_LIMIT) {
			throw new InsufficientFunds("Insufficient Funds");
		}
		super.balance = super.balance - amt;
		Account.noOfTransactions++;
	}

}
