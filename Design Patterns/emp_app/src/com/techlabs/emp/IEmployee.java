package com.techlabs.emp;

import java.util.ArrayList;

public interface IEmployee {
	String getEmpName() ;
	ArrayList<IEmployee> getReportees();
}