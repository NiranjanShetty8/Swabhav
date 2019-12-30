package com.techlabs.emp;

import java.util.ArrayList;
import java.util.HashMap;

public class EmpAnalyzer {
	private EmpParser obj;
	private ArrayList<Employee> empList;


	public EmpAnalyzer(EmpParser obj) {
		try {
			empList = obj.parseEmp();
		} catch (Exception e) {
		}
	}

	public ArrayList<Employee> getEmpList() {
		return empList;
	}

	public EmpParser getObj() {
		return obj;
	}
	
	public IEmployee getMaxSalary() throws Exception {
		
		int largest =0;
		int indexOfLargest = 0;
		for(int i = 0; i< empList.size(); i++) {
			if(empList.get(i).getEmpSalary()> largest) {
				largest = empList.get(i).getEmpSalary();
				indexOfLargest = i; 
			}
		}
		return empList.get(indexOfLargest);
	}
	
	public HashMap<String, Integer> getJobWiseEmp() throws Exception{
		int count = 1;
		HashMap<String , Integer> deptEmpCount = new 
				HashMap<String, Integer>();
		for(IEmployee e : empList) {
			if(deptEmpCount.containsKey(e.getEmpDesignation())) {
				deptEmpCount.put(e.getEmpDesignation(), 
						deptEmpCount.get(e.getEmpDesignation())+1);
			} else {
			deptEmpCount.put(e.getEmpDesignation(), count);
		}
		}
		return deptEmpCount;
	}
	
	public HashMap<Integer, Integer> getDeptWiseEmp() throws Exception{
		int count =1;
		HashMap<Integer , Integer> deptEmpCount = new 
				HashMap<Integer, Integer>();
		for(IEmployee e : empList) {
			if(deptEmpCount.containsKey(e.getEmpDeptNumber())) {
				deptEmpCount.put(e.getEmpDeptNumber(), 
						deptEmpCount.get(e.getEmpDeptNumber())+1);
				}
			else {
			deptEmpCount.put(e.getEmpDeptNumber(), count);
			}
		}
		return deptEmpCount;
	}
	
}
//public Employee getManager(Employee emp) {
//for(Employee e: empList) {
//	Integer.
//	if(emp.get)
//}
//}
