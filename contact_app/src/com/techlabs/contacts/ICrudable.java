package com.techlabs.contacts;

public interface ICrudable {

	void addEntry(String fName,String lName, int phoneNo, String emailId)throws Exception;
	//Object search(String fname, String lName);
	void exit();
}
