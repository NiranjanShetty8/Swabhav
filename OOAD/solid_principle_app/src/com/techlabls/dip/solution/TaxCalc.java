package com.techlabls.dip.solution;


public class TaxCalc {
	private ILogError log;
	
	public TaxCalc(ILogError log) {
		this.log = log;
	}
	
	public ILogError getLog() {
		return log;
	}
	
	public int calculate(int amount, int rate) throws Exception {
			int r;
			try {
				r = amount/rate;
				return r;
			} catch (Exception e) {
				log.logError(e.getMessage());
				return -1;
			}
			
	}
}
