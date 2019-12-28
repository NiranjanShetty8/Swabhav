package com.techlabs.emp;

import java.util.ArrayList;

public class Employee implements IEmployee {
	private int empID;
	private String empName;
	private String empDesignation;
	private String empManagerID;
	private String empDateOfJoining;
	private int empSalary;
	private String empCommission;
	private int empDeptNumber;
	private ArrayList<IEmployee> reportees = new ArrayList<IEmployee>();

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public void setEmpManagerID(String empManagerID) {
		this.empManagerID = empManagerID;
	}

	public void setEmpDateOfJoining(String empDateOfJoining) {
		this.empDateOfJoining = empDateOfJoining;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	public void setEmpCommission(String empCommission) {
		this.empCommission = empCommission;
	}

	public void setEmpDeptNumber(int empDeptNumber) {
		this.empDeptNumber = empDeptNumber;
	}

	public int getEmpID() {
		return empID;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public String getEmpManagerID() {
		return empManagerID;
	}

	public String getEmpDateOfJoining() {
		return empDateOfJoining;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public String getEmpCommission() {
		return empCommission;
	}

	public int getEmpDeptNumber() {
		return empDeptNumber;
	}
	
	public void addReportees(Employee e) {
		reportees.add(e);
	}
	
	public ArrayList<IEmployee> getReportees(){
		return reportees;
	}
	
}
