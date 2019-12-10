package com.techlabs.dog.door;

public class Bark {
	private String sound;

	public String getSound() {
		return sound;
	}

	public Bark(String sound) {
		this.sound = sound;
	}

	@Override
	public boolean equals(Object obj) {
		Bark bark = (Bark) obj;
		if (bark.getSound() == this.getSound()) {
			return true;
		}
		return false;
	}

}
