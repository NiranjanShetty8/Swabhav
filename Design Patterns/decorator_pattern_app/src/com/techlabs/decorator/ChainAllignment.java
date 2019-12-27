package com.techlabs.decorator;

public class ChainAllignment extends BikeServices {

	public ChainAllignment(IBikeService svc) {
		super(svc);
	}

	public String getDescription() {
		return svc.getDescription() + ", chains alligned";
	}
	
	public double getCost() {
		return svc.getCost() + 500;
	}
	
}
