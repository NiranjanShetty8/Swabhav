package com.techlabs.factory.method;

public class BmwFactory implements IAutomobileFactory {
	private static BmwFactory bmw;

	private BmwFactory() {
	}

	@Override
	public IAutomobile make() {
		IAutomobile automobile;
		automobile = new Bmw();
		return automobile;
	}

	public static BmwFactory getInstance() {
		if (bmw == null) {
			bmw = new BmwFactory();
		}
		return bmw;
	}

}
