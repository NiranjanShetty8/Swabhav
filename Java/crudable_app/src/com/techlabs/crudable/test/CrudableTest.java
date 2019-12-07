package com.techlabs.crudable.test;

import com.techlabs.crudable.*;
import com.techlabs.crudable.ICurdable;

public class CrudableTest {

	public static void main(String[] args) {
		CrudableTest cdt = new CrudableTest();
		cdt.doDbOperations(new CustomerDB());
		cdt.doDbOperations(new InvoiceDB());
		cdt.doDbOperations(new AddressDB());

	}

	public void doDbOperations(ICurdable obj) {
		System.out.println("Different DB Operations:-");
		obj.create();
		obj.read();
		obj.update();
		obj.delete();
	}
}
