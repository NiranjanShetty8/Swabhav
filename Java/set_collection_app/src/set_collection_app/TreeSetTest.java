package set_collection_app;

import java.util.*;


public class TreeSetTest {

	public static void main(String[] args) {
		TreeSetTest ts = new TreeSetTest();
		Set<String> names = new TreeSet<String>();

		names.add("Niranjan");
		names.add("Pratik");
		names.add("Jay");
		names.add("Prakash");
		ts.display(names);
		names.remove("Niranjan");
		System.out.println("After removing");
		ts.display(names);
		System.out.println("After duplicates");
		names.add("Prakash");
		names.add("Jaydeep");
		ts.display(names);
	}

	public void display(Set<String> names) {
		for (String show : names) {
			System.out.println(show);
		}
	}
}

