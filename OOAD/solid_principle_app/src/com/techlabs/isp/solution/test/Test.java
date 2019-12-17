package com.techlabs.isp.solution.test;

import com.techlabs.isp.solution.IHumanWorkable;
import com.techlabs.isp.solution.IWorkable;
import com.techlabs.isp.solution.Manager;
import com.techlabs.isp.solution.Robot;

public class Test {
	public static void main(String[] args) {
		Manager m = new Manager();
		Robot r = new Robot();
		
		atTheWorkStation(m);
		atTheCafeteria(m);
		atTheWorkStation(r);
//		atTheCafeteria(r);
		
		
	}

	public static void atTheWorkStation(IWorkable inst) {
		inst.startWork();
		inst.stopWork();
	}

	public static void atTheCafeteria(IHumanWorkable inst) {
		inst.startEat();
		inst.stopEat();
	}
}


