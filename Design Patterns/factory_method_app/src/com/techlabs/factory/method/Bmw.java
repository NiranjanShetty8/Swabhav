package com.techlabs.factory.method;

class Bmw implements IAutomobile{

	@Override
	public void start() {
		System.out.println("BMW starts");
	}

	@Override
	public void stop() {
		System.out.println("BMW stops.");
	}

}
