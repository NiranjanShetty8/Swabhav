package com.techlabs.emp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.TreeSet;

public class EmpUrlReader implements ILoader{
	private TreeSet<String> singleEntries = new TreeSet<String>(new SortById());

	public TreeSet<String> getSingleEntries() {
		return singleEntries;
	}
	
	@Override
	public TreeSet<String> readEmpFile() throws Exception {
		URL empFile = new URL("https://swabhav-tech.firebaseapp.com/emp.txt ");
		BufferedReader in = new BufferedReader(new InputStreamReader(empFile.openStream()));
		
		String lines;
		while ((lines = in.readLine()) != null) {
			singleEntries.add(lines);
		}
		
		in.close();
		return singleEntries;
	}

}
