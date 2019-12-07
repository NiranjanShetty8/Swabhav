package com.techlabs.model.test;

import java.util.HashSet;
import java.util.Set;

import com.techlabs.model.Student;

public class HashSetTest {

	public static void main(String[] args) {
		Set<Student> student = new HashSet<Student>();
		Student s1,s2,s3;
		s1 = new Student(101,"Niranjan","Mumbai");
		s2 = new Student(102, "Junaid", "Pune");
		s3 = new Student(101,"Niranjan","Mumbai");
		student.add(s1);
		student.add(s2);
		student.add(s3);
		System.out.println(student.size());
		System.out.println(s1.hashCode() +" " +s3.hashCode() +" " +s2.hashCode());
	}

}
