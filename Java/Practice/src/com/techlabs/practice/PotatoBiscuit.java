package com.techlabs.practice;

public final class PotatoBiscuit implements Cloneable {

	public void display() {
		System.out.println("in potato");
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
