package com.techlabls.dip.solution;

public class TextLog implements ILogError{

	@Override
	public void logError(String msg) {
		System.out.println("Wrote error in text file.");
		System.out.println(msg);
		
	}
	

}
