package com.techlabs.vehicles.test;

import com.techlabs.vehicles.*;

public class VehicleTest {

	public static void main(String[] args) {
		VehicleTest vt = new VehicleTest();
		IMovable bmw = new Car();
		IMovable audi = new Car();
		IMovable mahindra = new Truck();
		IMovable pulsar = new Bike();
		IMovable bajaj = new Bike();

		IMovable[] imoveArray = { bmw, audi, mahindra, pulsar, bajaj };

		vt.startTheRace(imoveArray);

	}

	public void startTheRace(IMovable[] obj) {
		for (IMovable index : obj) {
			//System.out.print(index.toString().split("@")[1]);
			index.move();
			//System.out.println(index.getClass().getName());
		}
	}
}
