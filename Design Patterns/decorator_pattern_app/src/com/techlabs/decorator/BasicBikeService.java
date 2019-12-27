package com.techlabs.decorator;

public class BasicBikeService implements IBikeService {

	@Override
	public String getDescription() {
		return "Basic service done";
	}

	@Override
	public double getCost() {
		return 400;
	}

}
