package emp_app;

import java.util.ArrayList;
import java.util.TreeSet;

public class CompanyDetails {

	public String findLargestSalary() {
		ArrayList<String> singleEntry = new ArrayList<String>();
		singleEntry = EmpFileReader.getEntries();
		int largestEntry = 0;
		int largest = 0;
		for (int i = 0; i < singleEntry.size(); i++) {
			if ((singleEntry.get(i).split(",")[3]).equalsIgnoreCase("null")) {
				continue;
			}
			if (Integer.parseInt(singleEntry.get(i).split(",")[3]) > largest) {
				largest = Integer.parseInt(singleEntry.get(i).split(",")[3]);
				largestEntry = i;
			}
		}
		return singleEntry.get(largestEntry);
	}
	
	public ArrayList<String> getTotalManagers(){
		TreeSet<String> singleEntry = EmpFileReader.getSingleEntries();
		ArrayList<String> managers = new ArrayList<String>();
		for(String s : singleEntry) {
			if(s.split(",")[2].equalsIgnoreCase("'manager'")) {
				managers.add(s);
				}
			}
		return managers;
	}
	
	
}