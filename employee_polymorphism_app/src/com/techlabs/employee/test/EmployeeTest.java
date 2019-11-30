package com.techlabs.employee.test;

import java.io.*;
import java.lang.reflect.Array;

import com.techlabs.employee.poly.*;

public class EmployeeTest extends Exception {

	public static void main(String[] args) throws IOException {
		EmployeeTest et = new EmployeeTest();
		EmpArray eArray = new EmpArray();
		Employee manager = new Manager(101, "Ramesh", 10000);
		// et.printSalary(manager);

		Employee coder = new Programmer(102, "Niranjan", 20000);
		// et.printSalary(coder);
		Employee accountant = new Accountant(103, "Bheem", 30000);

		Employee[] empArray = { manager, coder, accountant };
		eArray.getDetails(empArray);

	}

	public void printSalary(Employee e) {
		System.out.println("Designation is: " + e.getClass().getSimpleName());
		System.out.println("Employee name is: " + e.getEName());
		System.out.println("Employee number is: " + e.getENumber());
		System.out.println("Employee's basic salary is: " + e.getBasicSalary());
		System.out.println("Employee's salary structure is: " + e.salaryStructure());
		e.calculateAmount();
		System.out.println("Employee's total salary is: " + e.getTotalSalary());
	}

}
//if (e instanceof Manager) {
//String s = e.getClass().getSimpleName();
//if(s.equals("Manager")) {
//	System.out.println("hra is: " + ((Manager) e).getHra());
//	System.out.println("ta is: " + ((Manager) e).getTa());
//	System.out.println("da is: " + ((Manager) e).getda());
//}

// System.out.println("Designation is: " +e.getClass().getName().split("[.]")[4]
// );