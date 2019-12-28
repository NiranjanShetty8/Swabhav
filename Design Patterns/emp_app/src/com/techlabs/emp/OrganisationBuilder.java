package com.techlabs.emp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class OrganisationBuilder {
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private Employee ceo;
	private ArrayList<Employee> reportees = new ArrayList<Employee>();
	private HashMap<Integer, Employee> managers = new HashMap<Integer, Employee>();
	private HashMap<Integer, ArrayList<Employee>> 
	orgHierarcy = new HashMap<Integer, ArrayList<Employee>>();
	
	public OrganisationBuilder(ArrayList<Employee> employees) {
		this.employees = employees;

	}

	public void build() throws Exception {
		
		for(Employee emp : employees) {
			orgHierarcy.put(emp.getEmpID(), reportees);
		}
		for(Employee emp : employees) {
			managers.put(emp.getEmpID(), emp);
		}
		
		for(Employee emp : employees) {
			if (emp.getEmpManagerID().equalsIgnoreCase("Null") ) {
				ceo = emp;
			} else {
				int mgrId = Integer.parseInt(emp.getEmpManagerID());
				Employee employee = managers.get(mgrId);
				employee.addReportees(emp);
				orgHierarcy.put(mgrId, reportees);
			
			}
		}
		for(Entry<Integer, ArrayList<Employee>> id : orgHierarcy.entrySet()) {
			System.out.println("Key" + " " +id.toString());
			for(Employee e : id.getValue()) {
			System.out.println("value " +e.getEmpName());
		}
		}
	}
	
	public StringBuilder parseToXml(Employee emp) {
		StringBuilder xml = new StringBuilder();
		
		xml.append("<" +emp.getEmpName() + "> \n");
		for(IEmployee e: emp.getReportees()) {
			xml.append("\n<" +e.getEmpName() +">\n");
			
		}
		xml.append("\n</" +emp.getEmpName() + ">");
		return xml;
	}

	public Employee getCeo() {
		return ceo;
	}
	
}
//	for (Employee e : employees) {
//		int id = e.getEmpID();
//		for (Employee em : employees) {
//			if (em.getEmpManagerID().equalsIgnoreCase("null")) {
//				continue;
//			}
//				int mId = Integer.parseInt(em.getEmpManagerID());
//				if (id == mId) {
//					e.addReportees(em);
//				}
//			}
//		}
