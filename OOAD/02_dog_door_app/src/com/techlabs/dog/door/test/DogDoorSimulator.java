package com.techlabs.dog.door.test;

import com.techlabs.dog.door.*;

public class DogDoorSimulator {

	public static void main(String[] args) {
		DogDoor door = new DogDoor();
		Remote remote = new Remote(door);
		
		door.addAllowedBark(new Bark("wuff"));
		door.addAllowedBark(new Bark("rufff"));
		door.addAllowedBark(new Bark("gruff"));
		door.addAllowedBark(new Bark("zruff"));
		BarkRecognizer recognizer = new BarkRecognizer(door);
		
		System.out.println("Fidoo barks to go outside");
		recognizer.recognize(new Bark("wuff"));
		System.out.println("Fido has gone outside.");
		System.out.println("Fido's all done.");
		
		try {
			Thread.currentThread();
			Thread.sleep(10000);
		} catch(InterruptedException e) {
			System.out.println("in catch");
		}
			System.out.println("...but he is stuck outside.");
			System.out.println("Fido starts barking..");
//			System.out.println("..so Gina grabs the remote control.");
			recognizer.recognize(new Bark("wuff"));
			System.out.println("fido is back inside.");


	}

}
