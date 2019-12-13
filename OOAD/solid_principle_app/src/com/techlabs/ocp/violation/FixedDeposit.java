package com.techlabs.ocp.violation;

public class FixedDeposit {
	private int accountNo;
	private String name;
	private double principal;
	private int duration;
	private FestivalType festival;

	public FixedDeposit(int accountNo, String name, double principal, 
			int duration, FestivalType festival) {
		this.accountNo = accountNo;
		this.name = name;
		this.principal = principal;
		this.duration = duration;
		this.festival = festival;
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

	public FestivalType getFestival() {
		return festival;
	}

	public double calculateSimpleInterest() {
		double simpleInterest = (principal * duration) / 100;
		if (this.getFestival() == FestivalType.HOLI) {
			simpleInterest = simpleInterest * 0.08;
			return simpleInterest;
		}
		if (this.getFestival() == FestivalType.DIWALI) {
			simpleInterest = simpleInterest * 0.09;
			return simpleInterest;

		}
		simpleInterest = simpleInterest * 0.07;
		return simpleInterest;
	}

}
