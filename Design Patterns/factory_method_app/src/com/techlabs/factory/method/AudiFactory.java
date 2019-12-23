package com.techlabs.factory.method;

public class AudiFactory implements IAutomobileFactory {

	private static AudiFactory audi;

	private AudiFactory() {
	}

	@Override
	public IAutomobile make() {
		IAutomobile auto = new Audi();
		return auto;
	}

	public AudiFactory getInstance() {
		if (audi == null) {
			audi = new AudiFactory();
		}
		return audi;
	}

}
