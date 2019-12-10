package com.techlabs.dog.door;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {

	private static boolean open;
	private List<Bark> allowedBarks = new ArrayList<Bark>();

	public DogDoor() {
		open = false;
	}

	public ArrayList<Bark> getAllowedBArks(){
		return (ArrayList<Bark>) allowedBarks;
	}
	
	public void addAllowedBark(Bark bark) {
		allowedBarks.add(bark);
	}
	public void open() {
		System.out.println("The dog door opens.");
		open = true;
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				close();
				timer.cancel();
			}
		},5000);

	}

	public void close() {
		System.out.println("The dog door closes.");
		open = false;
	}

	public static boolean isOpen() {
		return open;
	}
}
