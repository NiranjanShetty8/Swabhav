package com.techlabs.srp.violation.test;

import com.techlabs.srp.violation.Invoice;

public class InvoiceTest {

	public static void main(String[] args) {

		Invoice iv = new Invoice(101, "abc", 100, 20);
		iv.print(iv);
	}

}
