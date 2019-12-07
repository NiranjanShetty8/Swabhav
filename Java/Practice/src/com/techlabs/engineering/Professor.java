package com.techlabs.engineering;

import java.util.Date;

public class Professor extends Person implements SalariedEmployee {
	private int experience;

	public Professor(int id, String address, String dob, int experience) {
		super(id, address, dob);
		this.experience = experience;

	}

	@Override
	public double getSalary() {
		double salary = 10000 * experience;
		return salary;
	}
}
