package com.techlabs.ocp.solution;

public class DiwaliRate extends FestInterestRate{
	@Override
	public double getRate() {
		this.intRate = 0.09;
		return intRate;
	}

}
