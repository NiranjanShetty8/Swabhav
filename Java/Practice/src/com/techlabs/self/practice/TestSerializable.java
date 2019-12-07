package com.techlabs.self.practice;

import java.io.*; 
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;


public class TestSerializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5970539745988991909L;
	
	String location = "D:\\Swabhav\\Swabhav\\test\\value.txt";

public void writeToFile() throws IOException {
	HashSet<Contacts> val = new HashSet<>();
	val.add(new Contacts("Niranjan","Shetty", 4353356, "Shet@gm.com"));
	val.add(new Contacts("Rajesh","Shetty", 4353356, "Shet@gm.com"));
	val.add(new Contacts("Prakash","Shetty", 4353356, "Shet@gm.com"));
	FileOutputStream fos = new FileOutputStream(location);
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(val);
	System.out.println("done");
	oos.close();
}
	
	
public void readFromFile() throws Exception {
	FileInputStream fis = new FileInputStream(location);
	ObjectInputStream ois = new ObjectInputStream(fis);
	@SuppressWarnings("unchecked")
	HashSet<Contacts> deserialize = (HashSet<Contacts>) ois.readObject();
	System.out.println(deserialize);
	Iterator<Contacts> iter = deserialize.iterator();
	while(iter.hasNext()) {
		Contacts v = iter.next();
		System.out.println(v.getfName() + " " +
		v.getlName() + " " +
		v.getEmailId() + " " +
		v.getPhoneNo());
	}
	ois.close();
	
	
	
}
}