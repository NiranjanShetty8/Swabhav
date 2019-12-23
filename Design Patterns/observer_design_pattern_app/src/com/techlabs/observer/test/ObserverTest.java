package com.techlabs.observer.test;

import com.techlabs.publisher.Account;
import com.techlabs.subscribers.EmailSubscribers;
import com.techlabs.subscribers.SmsSubscribers;

public class ObserverTest {

	public static void main(String[] args) {
		
		SmsSubscribers sms = new SmsSubscribers();
		Account raju = new Account(101, "Raju", 887686693,
				"raju@gamil.com", 10000);
		Account sanju = new Account(101, "Sanju", 997686693, 
				"sanju@gamil.com", 20000);
		raju.addSubscription(new EmailSubscribers());
		raju.addSubscription(sms);
		sanju.addSubscription(sms);
		raju.deposit(5000);
		sanju.withdraw(2000);
		raju.removeSubscription(sms);
		raju.deposit(2000);
	}

}
