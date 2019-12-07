package com.techlabs.account;

public class CurrentAccount extends Account {
	public CurrentAccount(int accNo, String name, double balance) {
		super(accNo, name, balance);
	}

	public void withdraw(double amt) throws InsufficientFunds {
		if (super.balance - amt < -10000) {
			throw new InsufficientFunds("Insufficient Funds");
		}
		super.balance = super.balance - amt;
		Account.noOfTransactions++;
		
	}
}

