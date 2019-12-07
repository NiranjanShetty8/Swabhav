package com.techlabs.employee.poly;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EmpArray {

	public void getDetails(Employee[] e) throws IOException {
		for (int index = 0; index < e.length; index++) {
			FileWriter fw = new FileWriter("D:\\Swabhav\\Swabhav\\Practice\\" + 
				e[index].getENumber() + ".txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.print("Name: " + e[index].getEName() + " " +
				e[index].salaryStructure() + " Total Salary is: "
					+ String.valueOf(e[index].calculateAmount()));
			pw.close();
			fw.close();
		}
	}

}
