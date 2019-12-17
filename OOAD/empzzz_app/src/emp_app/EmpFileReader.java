package emp_app;

import java.io.*;
import java.util.*;

public class EmpFileReader {

	private static ArrayList<String> entries = new ArrayList<String>();
	private static TreeSet<String> singleEntries = new TreeSet<String>(new SortById());

	public static TreeSet<String> getSingleEntries() {
		return singleEntries;
	}

	public static ArrayList<String> getEntries() {
		return entries;
	}

	public void addDeatilsToList() throws Exception {

		File fis = new File("D:\\Swabhav\\Swabhav\\OOAD\\dataFile.txt");
		BufferedReader dis = new BufferedReader(new FileReader(fis));

		String lines;
		while ((lines = dis.readLine()) != null) {
			entries.add(lines);
		}

		dis.close();

	}
	
	public void removeDuplicates() throws Exception {
		addDeatilsToList();
		singleEntries.addAll(entries);
	}

}
