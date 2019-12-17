package com.techlabs.isp.violation;

public class Robots implements IWorkable{

	@Override
	public void startWork() {
		System.out.println("Robot is working.");
		
	}

	@Override
	public void stopWork() {
		System.out.println("Robot stops working.");
	}

	@Override
	public void startEat() {
		throw new RuntimeException("Robots don't eat");
	}

	@Override
	public void stopEat() {
		throw new RuntimeException("Robots don't eat");
	}

}
