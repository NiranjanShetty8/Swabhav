package com.techlabs.account;

public class Account {

	private int balance;
	private String name;
	private int accountNumber;
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public int getBalance() {
		return balance;
	}
	public String getName() {
		return name;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void deposit(int deposit) {
		balance = balance + deposit;
	}
	
	public void withdraw(int withdraw) {
		balance = balance - withdraw;
	}
	
	
	
}
