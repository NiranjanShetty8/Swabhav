package com.techlabs.account.exceptn;


public class InsufficientFundsException extends RuntimeException {
	String detailMessage;

	public InsufficientFundsException(Account obj) {
		this.detailMessage = "Cannot Process Transaction of the following account" 
				+"\nName of the account is : " + obj.getaccountName()
				+ "\nAccount Number is: " + obj.getaccountNumber()
				+ "\nAccount balance is: " + obj.getBalance();

//		super("Cannot Process Transaction of the following account" +"Name of the account is : " + obj.getaccountName() 
//			+ " Account Number is: " + obj.getaccountNumber()
//			+ " Account balance is: " + obj.getBalance());
//		
	}
	@Override
	public String getMessage() {
		return detailMessage;
	}
}

