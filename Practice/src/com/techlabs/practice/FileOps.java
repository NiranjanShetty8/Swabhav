package com.techlabs.practice;

import java.io.*;

public class FileOps {

	public static void main(String[] args) throws IOException {

		usingPrintWriter("Niranjan");
	}

	public static void usingPrintWriter(String fileContent) {
		try {
			FileWriter fileWriter;
			fileWriter = new FileWriter("D:\\Swabhav\\Swabhav\\Practice\\hello.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print(fileContent);
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}