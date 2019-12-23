package com.techlabs.simple.factory.case1;

class Tesla implements IAutomobile {

	@Override
	public void start() {
		System.out.println("Tesla starts");
	}

	@Override
	public void stop() {
		System.out.println("Tesla stops");
	}
	

}
