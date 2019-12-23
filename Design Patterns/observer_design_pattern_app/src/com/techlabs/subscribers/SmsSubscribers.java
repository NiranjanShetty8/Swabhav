package com.techlabs.subscribers;

import com.techlabs.publisher.Account;
import com.techlabs.publisher.ISubscribable;

public class SmsSubscribers implements ISubscribable {

	@Override
	public void balanceModified(Account acc) {
		System.out.println(
				"SMS: Hello " + acc.getAccountName() 
				+ ", your Account balance has changed to: " 
						+ acc.getBalance());

	}

}
