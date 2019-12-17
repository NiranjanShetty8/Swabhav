package com.techlabs.ocp.solution;

public class HoliRate implements IFestivalRate {
	@Override
	public double getRate() {
		double intRate = 0.08;
		return intRate;
	}

}
