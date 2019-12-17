package emp_app;

import java.util.Comparator;

public class SortById implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o1.split(",")[0].compareTo(o2.split(",")[0]);
	}

}
