package com.techlabs.employee.poly;

public class Programmer extends Employee {
	private float pa;
	private float bonus;

	public Programmer(int eNumber, String eName, double basicSalary) {
		super(eNumber, eName, basicSalary);
		pa = (float) super.basicSalary * 40 / 100;
		bonus = (float) super.basicSalary * 30 / 100;
	}

	@Override
	public double calculateAmount() {
		super.totalSalary = super.basicSalary + pa + bonus;
		return super.totalSalary;
	}

	@Override
	public String salaryStructure() {
		String salarySlip = "PA is: " + String.valueOf(pa) + 
				" Bonus is: " + String.valueOf(bonus);
		return salarySlip;

	}

}
