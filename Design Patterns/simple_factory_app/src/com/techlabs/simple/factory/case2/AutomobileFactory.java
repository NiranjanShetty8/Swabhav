package com.techlabs.simple.factory.case2;

public class AutomobileFactory {
	private static AutomobileFactory fact;
	
	private AutomobileFactory() {
	}
	
	public IAutomobile make(AutoType type) {
		IAutomobile automobile;
		if(type == AutoType.AUDI) {
			automobile = new Audi();
			return automobile;
		}
		else if(type == AutoType.BMW) {
			automobile = new Bmw();
			return automobile;
		}
		automobile = new Tesla();
		return automobile;
	}
	
	public static AutomobileFactory getInstance() {
		if(fact == null) {
			fact = new AutomobileFactory();
		}
		return fact;
	}

}
