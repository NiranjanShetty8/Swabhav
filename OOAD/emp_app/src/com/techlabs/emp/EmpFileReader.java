package com.techlabs.emp;

import java.io.*;
import java.util.*;

public class EmpFileReader implements ILoader{
	private TreeSet<String> singleEntries = new TreeSet<String>(new SortById());

	public TreeSet<String> getSingleEntries() {
		return singleEntries;
	}

	@Override
	public TreeSet<String> readEmpFile() throws Exception {
		File fis = new File("D:\\Swabhav\\Swabhav\\OOAD\\dataFile.txt");
		BufferedReader dis = new BufferedReader(new FileReader(fis));

		String lines;
		while ((lines = dis.readLine()) != null) {
			singleEntries.add(lines);
		}
		dis.close();
		return singleEntries;
	
		
	}
	

}
