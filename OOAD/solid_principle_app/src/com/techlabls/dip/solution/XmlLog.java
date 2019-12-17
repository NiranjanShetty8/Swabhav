package com.techlabls.dip.solution;

public class XmlLog implements ILogError{

	@Override
	public void logError(String msg) {
		System.out.println("Wrote error in XML file.");
		System.out.println(msg);
	}

}
