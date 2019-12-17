package com.techlabs.emp.test;

import java.util.Map;

import com.techlabs.emp.*;

public class EmpTest {

	public static void main(String[] args) {
	
		EmpParser parse = new EmpParser(new EmpFileReader());
		EmpAnalyzer empal = new EmpAnalyzer(parse);
		try {
			Employee e = empal.getMaxSalary();
			System.out.println("Highest paid employee is: " +e.getEmpName() +" with salary: "
		+ e.getEmpSalary() + " " +e.getEmpDateOfJoining());
		} catch (Exception e) {
		}
		
		try {
			for(Map.Entry<String, Integer> entry : empal.getJobWiseEmp().entrySet()) {
				System.out.println("Job designation: " +entry.getKey());
				System.out.println("Number of Employees: " +entry.getValue());
		}
			for(Map.Entry<Integer, Integer> entry : empal.getDeptWiseEmp().entrySet()) {
				System.out.println("Department No: " +entry.getKey());
				System.out.println("Number of people: " +entry.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
