package com.techlabs.model.test;

import java.util.Iterator;

import com.techlabs.model.*;

public class GuitarTest {

	public static void main(String[] args) {
		Inventory iv = new Inventory();

		GuitarSpec type1 = new GuitarSpec("10001", Builder.GIBSON, Type.ACCOUSTIC, 
				Wood.ALDERM, Wood.BRAZILIAN_ROSEWOOD);
		GuitarSpec type2 = new GuitarSpec("10002", Builder.FENDER, Type.ACCOUSTIC, 
				Wood.BRAZILIAN_ROSEWOOD, Wood.CEDAR);
		GuitarSpec type3 = new GuitarSpec("10003", Builder.MARTIN, Type.ELECTRIC, 
				Wood.ALDERM, Wood.CEDAR);
		GuitarSpec type4 = new GuitarSpec("10002", Builder.FENDER, Type.ACCOUSTIC, 
				Wood.BRAZILIAN_ROSEWOOD, Wood.CEDAR);
		GuitarSpec numType1 = new GuitarSpec("10003", Builder.MARTIN, Type.ELECTRIC, 
				Wood.ALDERM, Wood.CEDAR, 12);
		GuitarSpec required = new GuitarSpec(null, Builder.MARTIN, Type.ELECTRIC, 
				Wood.ALDERM, Wood.CEDAR, 12);
		
		
		Guitar g1 = new Guitar("A-1", 50000, type1);
		Guitar g2 = new Guitar("A-2", 55000, type2);
		Guitar g3 = new Guitar("A-3", 75000, type3);
		Guitar g4 = new Guitar("A-4", 60000, type4);
		Guitar nG1 = new Guitar("N-1", 80000, numType1);

		iv.addGuitar(g1);
		iv.addGuitar(g2);
		iv.addGuitar(g3);
	    iv.addGuitar(g4);
	    iv.addGuitar(nG1);

		System.out.println("Price is: " + iv.getGuitar("A-1").getPrice());
		System.out.println(iv.getGuitar("A-7"));

		for (Iterator<Guitar> i = iv.getGuitarList().iterator(); i.hasNext();) {
			Guitar list = i.next();
			System.out.println(list.getSerialNumber());
			System.out.println(list.getPrice());
			System.out.println(list.getSpec().getModel());
			System.out.println(list.getSpec().getBackWood());

		}
		if (iv.search(required).size() == 0) {
			System.out.println("We do not have a match.");
		} else {
			System.out.println("Following are the matches: ");
			for (Iterator<Guitar> j = iv.search(required).iterator(); j.hasNext();) {
				Guitar match = j.next();
				System.out.println("Serial number: " + match.getSerialNumber());
				System.out.println("Price : " + match.getPrice());
			}
		}

	}
}
