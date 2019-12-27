package com.techlabs.account;

import java.sql.Timestamp;
import java.util.Date;

public class AccountProxy extends Account {
	Date date = new Date();
	
	@Override
	public void deposit(int deposit) {
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		System.out.println("Time Before operation: " +ts);
		super.deposit(deposit);
		
		System.out.println(super.getBalance());
		System.out.println("Time after Operation: " +ts);
	}

}
