package com.techlabs.emp;

import java.util.ArrayList;

public class OrganisationBuilder {
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private Employee ceo;

	public OrganisationBuilder(ArrayList<Employee> employees) {
		this.employees = employees;

	}

	public void build() throws Exception {
		for (Employee e : employees) {
			if (e.getEmpManagerID().equalsIgnoreCase("Null")) {
				ceo = e;
			}
		}

		for (Employee e : employees) {
			int id = e.getEmpID();
			for (Employee em : employees) {
				if (em.getEmpManagerID().equalsIgnoreCase("null")) {
					continue;
				}
					int mId = Integer.parseInt(em.getEmpManagerID());
					if (id == mId) {
						e.addReportees(em);
					}
				}
			}
		}
	

	public Employee getCeo() {
		return ceo;
	}

}
