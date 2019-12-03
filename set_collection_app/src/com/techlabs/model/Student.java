package com.techlabs.model;

public class Student implements Comparable<Student>{
	private int rollNo;
	private String name;
	private String location;

	public Student(int rollNo, String name, String location) {
		this.rollNo = rollNo;
		this.name = name;
		this.location = location;
	}

	public int getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public int hashCode() {
		int result = rollNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Student sobj = (Student) obj;
		if (this.getRollNo() == sobj.getRollNo()) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Student obj) {
		if (this.getRollNo() == obj.getRollNo())
			return 0;
		else if (this.getRollNo() > obj.getRollNo())
			return 1;
		else
			return -1;
	}

}
