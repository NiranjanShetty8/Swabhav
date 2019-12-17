package com.techlabs.emp;

import java.util.ArrayList;

public class EmpParser {
	
	private ILoader obj;

	public EmpParser(ILoader obj) {
		this.obj = obj;
	}

	public ArrayList<Employee> parseEmp() throws Exception {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		for (String s : obj.readEmpFile()) {
			Employee e = new Employee();
			e.setEmpID(Integer.parseInt(s.split(",")[0]));
			e.setEmpName(s.split("'")[1]);
			e.setEmpDesignation(s.split("'")[3]);
			e.setEmpManagerID(s.split(",")[3]);
			e.setEmpDateOfJoining(s.split("'")[5]);
			e.setEmpSalary(Integer.parseInt(s.split(",")[5]));
			e.setEmpCommission(s.split(",")[6]);
			e.setEmpDeptNumber(Integer.parseInt(s.split(",")[7]));
			empList.add(e);
		}
		return empList;
	}

}
