package com.techlabs.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {
	private ArrayList<Guitar> guitarList = new ArrayList<Guitar>();


	public ArrayList<Guitar> getGuitarList() {
		return guitarList;
	}
	
	public void addGuitar(Guitar guitarToAdd) {
		guitarList.add(guitarToAdd);
	}

	public Guitar getGuitar(String serialNumber) {
		for (Iterator<Guitar> j = guitarList.iterator(); j.hasNext();) {
			Guitar addedGuitar = (Guitar) j.next();
			if (addedGuitar.getSerialNumber().equals(serialNumber)) {
				return addedGuitar;
			}
		}
		return null;
	}

	public ArrayList<Guitar> search(GuitarSpec searchSpec) {
		ArrayList<Guitar> matchingGuitars = new ArrayList<Guitar>();
		for (Iterator<Guitar> i = guitarList.iterator(); i.hasNext();) {
			Guitar guitar = (Guitar) i.next();
			if (guitar.getSpec().matches(searchSpec)) {
				matchingGuitars.add(guitar);
			}
		}
		return matchingGuitars;
	}
}
