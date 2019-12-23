package com.techlabs.publisher;

import java.util.ArrayList;

public class Account {

	private int accountNo;
	private String accountName;
	private long mobileNo;
	private String emailId;
	private double balance;
	private ArrayList<ISubscribable> subscribers =
			new ArrayList<ISubscribable>();
		
	
	public Account(int accountNo, String accountName, long mobileNo, 
			String emailId, double balance) {
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.balance = balance;
	}
	
	public int getAccountNo() {
		return accountNo;
	}
	
	public String getAccountName() {
		return accountName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
		for(ISubscribable obj : subscribers) {
			obj.balanceModified(this);
		}
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		for(ISubscribable obj : subscribers) {
			obj.balanceModified(this);
		}
	}
	
	public void addSubscription(ISubscribable obj) {
		subscribers.add(obj);
	}
	
	public void removeSubscription(ISubscribable obj) {
		subscribers.remove(obj);
	}
	
	public ArrayList<ISubscribable> getSubscribers(){
		return subscribers;
	}

}
