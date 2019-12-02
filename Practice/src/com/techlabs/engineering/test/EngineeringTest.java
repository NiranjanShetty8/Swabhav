package com.techlabs.engineering.test;

import com.techlabs.engineering.*;

public class EngineeringTest {

	public static void main(String[] args) {
		EngineeringTest et = new EngineeringTest();
		Person raju = new Student(101, "Mahim", "30-19-1990", Branch.CIVIL);
		Person kannan = new Professor(901, "Byculla", "24-08-1987", 3);
		et.printInfo(raju);
		et.printInfo(kannan);

	}

	public void printInfo(Person obj) {
		System.out.println("Id number is: " +obj.getId());
		System.out.println("Address is: " +obj.getAddress());
		System.out.println("Date of brith is: " +obj.getDateOFBirth());
		if(obj instanceof Student) {
			System.out.println("Branch name is: " +((Student) obj).getBranch());
		}
		if(obj instanceof Professor) {
			System.out.println("Salary is: " +((Professor) obj).getSalary());
		}
	}
}
