package com.techlabs.employee.poly;

public abstract class Employee {
	private int eNumber;
	private String eName;
	protected double basicSalary;
	protected double totalSalary;

	public Employee(int eNumber, String eName, double basicSalary) {
		this.eNumber = eNumber;
		this.eName = eName;
		this.basicSalary = basicSalary;
	}

	public int getENumber() {
		return eNumber;
	}

	public String getEName() {
		return eName;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public double getTotalSalary() {
		return totalSalary;
	}

	public abstract String salaryStructure();

	public abstract double calculateAmount();
}
