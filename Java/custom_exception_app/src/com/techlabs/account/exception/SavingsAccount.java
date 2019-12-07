package com.techlabs.account.exception;

public class SavingsAccount extends Account {
	public SavingsAccount(int accNo, String name, double balance) {
		super(accNo, name, balance);
	}

	public void withdraw(double amt) {
		if (super.balance - amt < super.LOWER_LIMIT) {
			throw new InsufficientFundsException(this.getName() +" due to ");
		}
		super.balance = super.balance - amt;
		Account.noOfTransactions++;
	}

}
