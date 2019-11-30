package com.techlabs.employee.poly;

public class Accountant extends Employee {
	private float perks;

	public Accountant(int eNumber, String eName, double basicSalary) {
		super(eNumber, eName, basicSalary);
		perks = (float) basicSalary * 30 / 100;
	}

	@Override
	public double calculateAmount() {
		super.totalSalary = super.basicSalary + perks;
		return super.totalSalary;
	}

	public String salaryStructure() {
		String salarySlip = "Perks is: " +String.valueOf(perks);
		return salarySlip;
	}
}
