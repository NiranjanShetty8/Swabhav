package set_collection_app;

import java.util.Set;

public class LinkedHashMap {
	public static void main(String[] args) {
		Set<String> names = new java.util.TreeSet<String>();
		names.add("Niranjan");
		names.add("Pratik");
		names.add("Jay");
		names.add("Prakash");
		for (String show : names) {
			System.out.println(show);
		}
		names.remove("Niranjan");
		System.out.println("After removing");
		for (String show : names) {
			System.out.println(show);
		}

	}
}
