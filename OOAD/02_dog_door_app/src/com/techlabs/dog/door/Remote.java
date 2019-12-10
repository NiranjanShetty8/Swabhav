package com.techlabs.dog.door;

public class Remote {

	private DogDoor door;
	
	public Remote(DogDoor door) {
		this.door = door;
	}
	
	public void pressButton() {
		System.out.println("Pressing the remote control button.");
		if(DogDoor.isOpen()) {
			door.close();
		}
		door.open();
		
	}
}
