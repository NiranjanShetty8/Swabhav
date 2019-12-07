package com.techlabs.model;

public enum Type {
	ACCOUSTIC, ELECTRIC;
	
	public String toString() {
		switch(this) {
		case ACCOUSTIC:
			return "Accoustic";
		default:
			return "Electric";
		}
	}
}
