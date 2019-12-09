package com.techlabs.dog.door;

public class DogDoor {

	private static boolean open;

	public DogDoor() {
		open = false;
	}

	public void open() {
		System.out.println("The dog door opens.");
		open = true;

	}

	public void close() {
		System.out.println("The dog door closes.");
		open = false;
	}

	public static boolean isOpen() {
		return open;
	}
}
