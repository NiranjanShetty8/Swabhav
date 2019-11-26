package com.techlabs.account;

public class SavingsAccount extends Account {
	public SavingsAccount(int accNo, String name, double balance) {
		super(accNo, name, balance);
	}

	public void withdraw(double amt) {
		try {
			if (super.balance - amt < super.LOWER_LIMIT) {
				throw new Exception();
			}
			super.balance = super.balance - amt;
		} catch (Exception e) {
			 System.out.println("Sorry cannot proccess this request for " +this.getName()
			 		+ " as minimum balance after wihtdrawal should be above 1000");
		}

	}
}
