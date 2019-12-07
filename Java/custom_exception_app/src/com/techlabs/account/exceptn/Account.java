package com.techlabs.account.exceptn;


public class Account {
	private String accountName;
	private int accountNumber;
	private double balance;
	private final static double MIN_BALANCE = 500;

	public Account(String accountName, int accountNumber) {
		this(accountName, accountNumber, MIN_BALANCE);
	}

	public Account(String accountName, int accountNumber, double balance) {
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		if (balance >= MIN_BALANCE) {
			this.balance = balance;
			return;
		}
		throw new InsufficientFundsException(this);
	}

	public String getaccountName() {
		return accountName;
	}

	public int getaccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance = balance + amount;
	}

	public void withdraw(double amount){
		if (balance - amount < MIN_BALANCE) {
			throw new InsufficientFundsException(this);
		}
		balance = balance - amount;
	}

	@Override
	public String toString() {
		return super.toString() + "|" + " Account number is: " + this.getaccountNumber() + 
				" Account name is: " + this.getaccountName()+ " Balance is:  " + 
				this.getBalance();
	}
	
	@Override 
	public boolean equals(Object object) {
		Account obj = (Account) object;
		if(this.getaccountName()==obj.getaccountName() && 
		this.getaccountNumber()==obj.getaccountNumber() && 
		this.getBalance()==obj.getBalance()) {
			return true;
		}
		return false;
	}

}
