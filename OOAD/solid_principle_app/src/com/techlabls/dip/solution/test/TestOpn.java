package com.techlabls.dip.solution.test;

import com.techlabls.dip.solution.ILogError;
import com.techlabls.dip.solution.TaxCalc;
import com.techlabls.dip.solution.TextLog;

public class TestOpn {

	public static void main(String[] args) {
		ILogError txt = new TextLog();
		TaxCalc calc = new TaxCalc(txt);
		try {
			System.out.println(calc.calculate(50, 10));
			System.out.println(calc.calculate(0, 0));
		} catch (Exception e) {
			txt.logError(e.getMessage());
		}

	}

}
