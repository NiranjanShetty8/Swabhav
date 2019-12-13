package com.techlabs.ocp.solution;

public class FixedDeposit {
	private int accountNo;
	private String name;
	private double principal;
	private int duration;
	private FestInterestRate festName;

	public FixedDeposit(int accountNo, String name, double principal, int duration,
			FestInterestRate festName) {
		this.accountNo = accountNo;
		this.name = name;
		this.principal = principal;
		this.duration = duration;
		this.festName = festName;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public String getName() {
		return name;
	}

	public double getPrincipal() {
		return principal;
	}

	public int getDuration() {
		return duration;
	}

	public FestInterestRate getFestival() {
		return festName;
	}

	public double calculateSimpleInterest() {
		double simpleInterest = (principal * duration * 
				festName.getRate()) / 100;
		return simpleInterest;

	}

}
