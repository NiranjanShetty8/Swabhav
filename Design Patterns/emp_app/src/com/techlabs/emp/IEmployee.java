package com.techlabs.emp;

import java.util.ArrayList;

public interface IEmployee {

	void setEmpID(int empID);

	void setEmpName(String empName);

	void setEmpDesignation(String empDesignation);

	void setEmpManagerID(String empManagerID);

	void setEmpDateOfJoining(String empDateOfJoining);

	void setEmpSalary(int empSalary);

	void setEmpCommission(String empCommission);

	void setEmpDeptNumber(int empDeptNumber);

	int getEmpID();

	String getEmpName();

	String getEmpDesignation();

	String getEmpManagerID();

	String getEmpDateOfJoining();

	int getEmpSalary();

	String getEmpCommission();

	int getEmpDeptNumber();

	void addReportees(IEmployee e);

	ArrayList<IEmployee> getReportees();

}