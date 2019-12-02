package set_collection_app;

import java.util.HashSet;
import java.util.*;

public class HashSetTest {
	public static void main(String[] args) {
		Set<String> names = new HashSet<String>();
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
