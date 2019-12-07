package com.techlabs.employee.poly;

public class Manager extends Employee {
	private float hra;
	private float ta;
	private float da;

	public Manager(int eNumber, String eName, double basicSalary) {
		super(eNumber, eName, basicSalary);
		hra = (float) basicSalary * 50 / 100;
		ta = (float) basicSalary * 40 / 100;
		da = (float) basicSalary * 30 / 100;
	}

	public double getHra() {
		return hra;
	}

	public double getTa() {
		return ta;
	}

	public double getda() {
		return da;
	}

	@Override
	public double calculateAmount() {

		super.totalSalary = super.basicSalary + hra + ta + da;
		return super.totalSalary;
	}

	@Override
	public String salaryStructure() {
		String salarySlip = "HRA is: " + String.valueOf(hra) + " TA is:" + String.valueOf(ta) 
		+ " DA is: " + String.valueOf(da);
		return salarySlip;
	}

}
