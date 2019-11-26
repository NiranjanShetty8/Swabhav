package com.techlabs.account;

public class CurrentAccount extends Account {
	public CurrentAccount(int accNo, String name, double balance) {
		super(accNo,name,balance);
	}

	public void withdraw(double amt) {
		try {
		if(super.balance-amt <-10000) {
			throw new Exception();
		}
		super.balance = super.balance-amt;
	}catch(Exception e) {
		System.out.println("Cannot process withdrawal for " +this.getName()
				+ " Exceeding loan amount. Debit should not be more than 10000");
	}
}
}
