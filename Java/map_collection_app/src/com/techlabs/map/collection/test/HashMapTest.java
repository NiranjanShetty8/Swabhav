package com.techlabs.map.collection.test;

import java.util.*;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<Integer, String> entry = new HashMap<Integer, String>();
		entry.put(10, "Apple");
		entry.put(203, "Banana");
		entry.put(1001, "Car");
		entry.put(199, "Mars");
		entry.put(203, "Not Banana");
		System.out.println("Entry is: " + entry.get(203));
		System.out.println(entry.entrySet());
		for (Map.Entry<Integer, String> itr : entry.entrySet()) {
			System.out.println(itr);
		}
	}

}
