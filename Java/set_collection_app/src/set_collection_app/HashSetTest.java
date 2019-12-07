package set_collection_app;

import java.util.*;


public class HashSetTest {
	public static void main(String[] args) {
		HashSetTest hst = new HashSetTest();
		Set<String> names = new HashSet<String>();

		names.add("Niranjan");
		names.add("Pratik");
		names.add("Jay");
		names.add("Prakash");
		hst.display(names);
		names.remove("Niranjan");
		System.out.println("After removing");
		hst.display(names);
		System.out.println("After duplicates");
		names.add("Prakash");
		names.add("Jaydeep");
		hst.display(names);
	}

	public void display(Set<String> names) {
		for (String show : names) {
			System.out.println(show);
		}
	}
}
