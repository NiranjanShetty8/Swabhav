package com.techlabs.decorator;

public abstract class BikeServices implements IBikeService{
	
	protected IBikeService svc;
	
	public BikeServices(IBikeService svc) {
		this.svc = svc;
	}
	
	public String getDescription() {
		return svc.getDescription();
	}
	
	public double getCost() {
		return svc.getCost();
	}
	
	

}
