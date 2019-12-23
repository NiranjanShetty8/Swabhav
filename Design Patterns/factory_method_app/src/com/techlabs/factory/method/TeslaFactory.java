package com.techlabs.factory.method;

public class TeslaFactory implements IAutomobileFactory {

	private static TeslaFactory tesla;

	private TeslaFactory() {
	}

	@Override
	public IAutomobile make() {
		IAutomobile auto = new Tesla();
		return auto;
	}

	public static TeslaFactory getInstance() {
		if (tesla == null) {
			tesla = new TeslaFactory();

		}
		return tesla;
	}
	
}
