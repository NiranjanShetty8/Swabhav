package com.techlabs.dog.door.test;

import com.techlabs.dog.door.DogDoor;
import com.techlabs.dog.door.Remote;

public class DogDoorSimulator {

	public static void main(String[] args) {
		DogDoor door = new DogDoor();
		Remote remote = new Remote(door);
		
		System.out.println("Fidoo barks to go outside");
		remote.pressButton();
		System.out.println("Fido has gone outside.");
		System.out.println("Fido's all done.");
		System.out.println(DogDoor.isOpen());
		
		try {
			Thread.currentThread().sleep(10000);
		} catch(InterruptedException e) {
			System.out.println("...but he is stuck outside.");
			System.out.println("Fido starts barking..");
			System.out.println("..so Gina grabs the remote control.");
			remote.pressButton();
			System.out.println("fido is back inside.");
		}

	}

}
