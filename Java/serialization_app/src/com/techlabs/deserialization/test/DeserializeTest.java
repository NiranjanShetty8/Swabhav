package com.techlabs.deserialization.test;

import java.io.*;

import com.techlabs.serialize.*;

public class DeserializeTest {
	public static void main(String[] args) throws Exception{
		Account acc2;
		DeserializeTest dst = new DeserializeTest();
		FileInputStream fos;
		fos = new FileInputStream("D:\\Swabhav\\Swabhav\\Practice\\AccountObj.txt");
		ObjectInputStream oos = new ObjectInputStream(fos);
		acc2 = (Account)oos.readObject();
		System.out.println(acc2.balance);
		oos.close();
		fos.close();
//		dst.readFromFile(acc2);
	
	}

	
//	public void readFromFile(Account obj) throws Exception {
//		FileInputStream fis; 
//		fis = new FileInputStream("D:\\Swabhav\\Swabhav\\Practice\\AccountObj.txt");
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		obj = (Account) ois.readObject();
//		fis.close();
//		ois.close();
//	}

}

