package com.techlabs.account;

public class InsufficientFunds extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2245382894033105535L;

	public InsufficientFunds() {
		super();
	}
	
	public InsufficientFunds(String message) {
		super(message);
	}

}

