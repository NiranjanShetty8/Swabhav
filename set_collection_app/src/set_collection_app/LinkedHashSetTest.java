package set_collection_app;

import java.util.*;

public class LinkedHashSetTest {
	public static void main(String[] args) {
		LinkedHashSetTest lhm = new LinkedHashSetTest();
		Set<String> names =  new LinkedHashSet<String>();

		names.add("Niranjan");
		names.add("Pratik");
		names.add("Jay");
		names.add("Prakash");
		lhm.display(names);
		names.remove("Niranjan");
		System.out.println("After removing");
		lhm.display(names);
		System.out.println("After duplicates");
		names.add("Prakash");
		names.add("Jaydeep");
		lhm.display(names);
	}

	public void display(Set<String> names) {
		for (String show : names) {
			System.out.println(show);
		}
	}
}

//Iterator<String> iter = names.iterator();
//while (iter.hasNext()) {
//	iter.remove();
//	System.out.println(iter);
//}