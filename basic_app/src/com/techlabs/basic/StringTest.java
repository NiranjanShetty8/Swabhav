package com.techlabs.basic;

public class StringTest {
	public static void main(String args[]) {
		String query = "https://swabhavtechlabs.com?developer= NIRANJAN";
		String companyName = query.substring(8, 22);
		String developerName = query.substring(39, query.length());
		System.out.println("Company name is " + companyName);
		System.out.println("Developer name is " + developerName);

		String[] compName = query.split("[:/=?.]");
		/*
		 * for(int i =0; i< compName.length; i++) { System.out.println("split is"
		 * +compName[i]); }
		 */
		System.out.println("Company name is " + compName[3]);
		System.out.println("Developer name is " + compName[6]);

		String query2 = "https://swabhavtechlabs.com?developer= NIRANJAN";
		String[] compName2 = query2.split("://");
		String[] test1 = compName2[1].split("[.]");
		System.out.println("Company Name : " + test1[0]);
		String[] test2 = query2.split("=");
		System.out.println("Develpoer name : " + test2[1]);

	}
}
