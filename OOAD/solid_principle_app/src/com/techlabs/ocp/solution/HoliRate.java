package com.techlabs.ocp.solution;

public class HoliRate extends FestInterestRate {
	@Override
	public double getRate() {
		this.intRate = 0.08;
		return intRate;
	}

}
