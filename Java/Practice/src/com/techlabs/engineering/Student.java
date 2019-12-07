package com.techlabs.engineering;

import java.util.Date;

public class Student extends Person {
	private Branch branch;

	public Student(int id, String address, String dateOfBirth, Branch b) {
		super(id, address, dateOfBirth);
		this.branch = b;
	}

	public Branch getBranch() {
		return branch;
	}
}
