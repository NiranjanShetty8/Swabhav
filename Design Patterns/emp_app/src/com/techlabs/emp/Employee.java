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
	private StringBuilder xml = new StringBuilder();

	@Override
	public void setEmpID(int empID) {
		this.empID = empID;
	}

	@Override
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	@Override
	public void setEmpManagerID(String empManagerID) {
		this.empManagerID = empManagerID;
	}

	@Override
	public void setEmpDateOfJoining(String empDateOfJoining) {
		this.empDateOfJoining = empDateOfJoining;
	}

	@Override
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public void setEmpCommission(String empCommission) {
		this.empCommission = empCommission;
	}

	@Override
	public void setEmpDeptNumber(int empDeptNumber) {
		this.empDeptNumber = empDeptNumber;
	}

	@Override
	public int getEmpID() {
		return empID;
	}

	@Override
	public String getEmpName() {
		return empName;
	}

	@Override
	public String getEmpDesignation() {
		return empDesignation;
	}

	@Override
	public String getEmpManagerID() {
		return empManagerID;
	}

	@Override
	public String getEmpDateOfJoining() {
		return empDateOfJoining;
	}

	@Override
	public int getEmpSalary() {
		return empSalary;
	}

	@Override
	public String getEmpCommission() {
		return empCommission;
	}

	@Override
	public int getEmpDeptNumber() {
		return empDeptNumber;
	}
	
	@Override
	public void addReportees(IEmployee e) {
		reportees.add(e);
	}
	
	@Override
	public ArrayList<IEmployee> getReportees(){
		return reportees;
	}
	
	public StringBuilder parseToXml() {
		String space = " ";
	
		
		xml.append("<" +this.getEmpName() + ">\n");
		if(this.getReportees()!= null) {
			for(IEmployee e: this.getReportees()) {
				space += " ";
				Employee emp = (Employee ) e;
				xml.append(space +emp.parseToXml() +"\n");
				
			}
			space += " ";
			xml.append(space +"</" +this.getEmpName() + ">");
		}
		
		return xml;
	}
	
}

//@Override
//public String toString() {
//	String name = this.getEmpName();
//	return name;
//}
