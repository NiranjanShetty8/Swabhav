package com.techlabs.self.practice;

import java.io.IOException;

public class TestMain {

	public static void main(String[] args) throws Exception {

		TestSerializable ts = new TestSerializable();
		ts.writeToFile();
//		ts.writeToFile("Eir", "fdhe", 822, "he");
//		ts.writeToFile("Zir", "dje", 462, "he");

		ts.readFromFile();
	}

}
