package com.techlabs.ocp.solution;

public class NormalRate implements IFestivalRate{

	@Override
	public double getRate() {
		double intRate = 0.07;
		return intRate;
	}
}
