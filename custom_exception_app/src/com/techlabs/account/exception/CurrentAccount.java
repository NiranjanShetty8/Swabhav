package com.techlabs.account.exception;

public class CurrentAccount extends Account {
	public CurrentAccount(int accNo, String name, double balance) {
		super(accNo, name, balance);
	}

	public void withdraw(double amt) {
		if (super.balance - amt < -10000) {
			throw new InsufficientFundsException(this.getName() + " due to ");
		}
		super.balance = super.balance - amt;
		Account.noOfTransactions++;
		
	}
}


