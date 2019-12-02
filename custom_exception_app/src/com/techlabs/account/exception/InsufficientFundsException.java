package com.techlabs.account.exception;

public class InsufficientFundsException extends RuntimeException{

	public InsufficientFundsException() {
		super("Insufficient Funds Exception");
	}
	
	public InsufficientFundsException(String msg) {
		super(msg + "Insufficient Funds Exception");
	}
	
	public InsufficientFundsException(Account obj) {
	}
}
	

