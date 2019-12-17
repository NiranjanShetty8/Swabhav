package com.techlabls.dip.violation.test;

import com.techlabls.dip.violation.LogType;
import com.techlabls.dip.violation.TaxCalculation;

public class AccountTest {

	public static void main(String[] args) {
		TaxCalculation txc = new TaxCalculation(LogType.XML);
		System.out.println(txc.calculate(10, 5));
		System.out.println(txc.calculate(0,0 ));

	}

}
