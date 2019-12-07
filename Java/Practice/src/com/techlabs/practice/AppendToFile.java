package com.techlabs.practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AppendToFile {
	public Scanner sc;
	
	public static void main(String args[]) throws IOException{
		AppendToFile atf = new AppendToFile();
		//append();
		atf.openFile();
		atf.readFile();
		
		
	}
	public static void append() throws IOException {
		String append = " Shetty";
		FileWriter fw = new FileWriter("D:\\Swabhav\\Swabhav\\Practice\\hello.txt",true);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(append);
		
		pw.close();
		System.out.println("Done");
		
	}
	
	public void openFile() {
	
		try {
			sc = new Scanner(new File("D:\\Swabhav\\Swabhav\\Practice\\hello.txt"));
			
		}catch(Exception e) {
			System.out.println("Error");
		}
		
	}
	
	public void readFile() {
		while(sc.hasNext()) {
			String a = sc.next();
			System.out.println(a);
		}
		sc.close();
	}
}


