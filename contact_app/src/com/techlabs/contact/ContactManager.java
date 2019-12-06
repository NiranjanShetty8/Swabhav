package com.techlabs.contact;

import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

public class ContactManager {
	public static final String location = "D:\\Swabhav\\Swabhav\\test\\Contacts.txt";
	private TreeSet<Contact> val = new TreeSet<Contact>();

	public ObjectInputStream getResource() throws Exception {
		FileInputStream fis = new FileInputStream(location);
		ObjectInputStream ois = new ObjectInputStream(fis);
		return ois;
	}

	public void addContact(String fName, String lName, long phoneNo, String emailID) 
			throws Exception {
		Contact obj = new Contact(fName, lName, phoneNo, emailID);
		val = readFromFile();
		val.add(obj);
		writeToFile(val);
	}

	public void writeToFile(TreeSet<Contact> obj) throws Exception {
		FileOutputStream fos = new FileOutputStream(location);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
	}

	public TreeSet<Contact> readFromFile() throws Exception {
		ObjectInputStream o = this.getResource();
		@SuppressWarnings("unchecked")
		TreeSet<Contact> read = (TreeSet<Contact>) o.readObject();
		o.close();
		return read;
	}

	public Contact search(String fname, String lname) throws Exception {
		ObjectInputStream ois = this.getResource();
		@SuppressWarnings("unchecked")
		TreeSet<Contact> deserial = (TreeSet<Contact>) ois.readObject();
		Iterator<Contact> iter = deserial.iterator();
		ois.close();
		while (iter.hasNext()) {
			Contact next = iter.next();
			if (next.getfName().equalsIgnoreCase(fname) && 
					next.getlName().equalsIgnoreCase(lname)) {
				return next;
			}
		}
		return null;
	}

	public boolean modifyPhoneNo(String fname, String lname, long newPhoneNo) 
			throws Exception {
		Contact modify = search(fname, lname);

		if (modify != null) {
			String emailId = modify.getEmailId();
			val = readFromFile();
			val.remove(modify);
			writeToFile(val);
			addContact(fname, lname, newPhoneNo, emailId);
			return true;
		}
		return false;
	}
}