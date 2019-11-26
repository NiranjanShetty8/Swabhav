package com.techlabs.account;

public abstract class Account {
	private int accno;
	private String name;
	protected double balance;
	protected final int LOWER_LIMIT = 1000;
	protected final int LOAN_LIMIT = -10000;

	public Account(int accno, String name, double balance) {
		this.accno = accno;
		this.name = name;
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public int getAccno() {
		return accno;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public abstract void withdraw(double amount);
}

