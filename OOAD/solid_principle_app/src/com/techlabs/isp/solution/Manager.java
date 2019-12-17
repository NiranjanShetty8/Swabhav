package com.techlabs.isp.solution;

public class Manager implements IHumanWorkable{

	@Override
	public void startWork() {
		System.out.println("Manager starts working.");
		
	}

	@Override
	public void stopWork() {
		System.out.println("Manager stops working.");
	}

	@Override
	public void startEat() {
		System.out.println("Manager starts eating.");
		
	}

	@Override
	public void stopEat() {
		System.out.println("Manager stops eating.");
	}
	

}
