package com.techlabs.isp.violation.test;

import com.techlabs.isp.violation.IWorkable;
import com.techlabs.isp.violation.*;

public class Test {

	public static void main(String[] args) {
		Managers m = new Managers();
		Robots r = new Robots();

		atTheWorkStation(m);
		atTheCafeteria(m);

		atTheWorkStation(r);
		atTheCafeteria(r); // Violation of LSP(False Promises). Solution is ISP.

	}

	public static void atTheWorkStation(IWorkable inst) {
		inst.startWork();
		inst.stopWork();
	}

	public static void atTheCafeteria(IWorkable inst) {
		inst.startEat();
		inst.stopEat();
	}
}
