package com.techlabs.dog.door;

public class BarkRecognizer {

	private DogDoor door;

	public BarkRecognizer(DogDoor door) {
		this.door = door;
	}

	public DogDoor getDoor() {
		return door;
	}

	public void recognize(Bark bark) {
		for (Bark bar : door.getAllowedBArks()) {
			if (bar.equals(bark)) {
				System.out.println("Bark Recognizer heard a " + bark.getSound());
				door.open();
				return;
			}
		}
	}
}
