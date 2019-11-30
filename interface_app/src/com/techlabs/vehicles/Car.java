package com.techlabs.vehicles;

public class Car implements IMovable{
	public Car() {
		System.out.println(this);
	}

	public void move() {
		System.out.println(" car is moving ");
	}
}
