package com.techlabs.basic;

public class DrumKitTestDrive {

	public static void main(String[] args) {
		
		Drumkit d = new Drumkit();
		d.playSnare();
		d.playTopHat();

	}
}

class Drumkit {

	void playSnare() {
		System.out.println("bang bang ba-bang");
	}

	void playTopHat() {
		System.out.println("ding ding da-ding");
	}
}
