package com.techlabs.serialization.test;

import java.io.*;

import com.techlabs.serialize.Account;

public class SerializeTest {

	public static void main(String[] args) throws IOException {
		SerializeTest st = new SerializeTest();
		Account acc1 = new Account();
		acc1.balance = acc1.balance - 3000;
		acc1.balance = acc1.balance + 1000;
		System.out.println(acc1.balance);
				st.writeToFile(acc1);

	}

	public void writeToFile(Account acc) throws IOException{
		// File f = new File();
		FileOutputStream fs;
		fs = new FileOutputStream("D:\\Swabhav\\Swabhav\\Practice\\AccountObj.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fs);
		oos.writeObject(acc);
		oos.close();
		fs.close();
	}
}
