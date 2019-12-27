package com.techlabs.decorator;

public class OilChange extends BikeServices{

	public OilChange(IBikeService svc) {
		super(svc);
	}
	
	public String getDescription() {
		return svc.getDescription() + ", oil changed";
	}
	
	public double getCost() {
		return svc.getCost() + 600;
	}
	
	

}
