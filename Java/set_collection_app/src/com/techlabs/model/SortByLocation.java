package com.techlabs.model;

import java.util.Comparator;

public class SortByLocation implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		return o1.getLocation().compareTo(o2.getLocation());
	}
}
