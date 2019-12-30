package com.techlabs.emp;

import java.util.ArrayList;
import java.util.HashMap;

public class OrganisationBuilder {
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private Employee ceo;
	private ArrayList<IEmployee> reportees = new ArrayList<IEmployee>();
	private HashMap<Integer, ArrayList<IEmployee>> 
	orgHierarcy = new HashMap<Integer, ArrayList<IEmployee>>();
	
	public OrganisationBuilder(ArrayList<Employee> employees) {
		this.employees = employees;

	}

	public void build() throws Exception {
		
		for(IEmployee emp : employees) {
			orgHierarcy.put(emp.getEmpID(), emp.getReportees());
		}
		
		for(IEmployee emp : employees) {
			if (emp.getEmpManagerID().equalsIgnoreCase("Null") ) {
				ceo = (Employee) emp;
				orgHierarcy.put(ceo.getEmpID(),ceo.getReportees());
			} else {
				int mgrId = Integer.parseInt(emp.getEmpManagerID());
				reportees = orgHierarcy.get(mgrId);
				reportees.add(emp);
				orgHierarcy.put(mgrId, reportees);
			
			}
		}
	}
		
//		for(Map.Entry<Integer, ArrayList<IEmployee>> test : orgHierarcy.entrySet()) {
//			System.out.println();
//			System.out.println(test.getKey() + "\n");
//			for(IEmployee e : test.getValue()) {
//				System.out.print(e.toString() + " ");
//			}
//		}
//		System.out.println(Arrays.asList(orgHierarcy));
		
//		for(Entry<Integer, ArrayList<IEmployee>> id : orgHierarcy.entrySet()) {
//			System.out.println("Key" + " " +id.toString());
//			for(IEmployee e : id.getValue()) {
//			System.out.println("value " +e.getEmpName());
//		}
//		}
	
	public Employee getCeo() {
		return ceo;
	}
	
}
