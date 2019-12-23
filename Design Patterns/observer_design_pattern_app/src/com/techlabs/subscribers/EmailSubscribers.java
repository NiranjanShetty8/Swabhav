package com.techlabs.subscribers;

import com.techlabs.publisher.Account;
import com.techlabs.publisher.ISubscribable;

public class EmailSubscribers implements ISubscribable {

	@Override
	public void balanceModified(Account acc) {
		System.out.println(
				"Email: Hello " + acc.getAccountName() + 
				" Your Account balance has changed to: " 
						+ acc.getBalance());

	}

}
