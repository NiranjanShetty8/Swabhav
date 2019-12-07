package com.techlabs.model;

public enum Wood {
	INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY,
	MAPLE, COCOBOLO, CEDAR, ADIRONDACK, ALDERM, SITKA;
	
	public String toString() {
		switch(this) {
		case INDIAN_ROSEWOOD:
			return "Indian Rosewood";
		case BRAZILIAN_ROSEWOOD:
			
		case MAHOGANY:
			return "Mahogany";
		case MAPLE:
			return "Maple";
		case COCOBOLO:
			return "Cocobolo";
		case CEDAR:
			return "Cedar";
		case ADIRONDACK:
			return "Adriondack";
		case ALDERM:
			return "Alderm";
		default:
			return "Sitka";
		}
	}
}
