package com.techlabs.simple.factory.case1;

public class AutomobileFactory {
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

}
