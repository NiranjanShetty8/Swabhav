package com.techlabs.dog.door;

import java.util.Timer;
import java.util.TimerTask;

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
		
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				door.close();
				timer.cancel();
				System.out.println(DogDoor.isOpen());
			}
		},5000);;
		
	}
}
