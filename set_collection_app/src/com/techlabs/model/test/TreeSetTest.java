package com.techlabs.model.test;

import java.sql.Wrapper;
import java.util.*;
import java.util.TreeSet;

import com.techlabs.model.*;

public class TreeSetTest {

	public static void main(String[] args) {
		// TreeSet<Student> student = new TreeSet<Student>(new SortByName());
		TreeSet<Student> student = new TreeSet<Student>(new SortByLocation());
		Student s1, s2, s3, s4;
		s1 = new Student(101, "Niranjan", "Mumbai");
		s2 = new Student(102, "Vinod", "Ratnagiri");
		s3 = new Student(101, "Niranjan", "Mumbai");
		s4 = new Student(103, "Abhi", "Panvel");
		student.add(s1);
		student.add(s2);
		student.add(s3);
		student.add(s4);

		for (Student s : student) {

			System.out.print(s.getRollNo() + " ");
			System.out.print(s.getName() + " ");
			System.out.print(s.getLocation());
			System.out.println();
		}
	}
}