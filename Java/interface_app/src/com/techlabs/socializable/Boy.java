package com.techlabs.socializable;

public class Boy implements ISocializable, IEmotionable {

	public void wish() {
		System.out.println("Boy says hello");
	}

	public void depart() {
		System.out.println("Boy says bye");
	}

	public void cry() {
		System.out.println("Boy is crying");
	}

	public void laugh() {
		System.out.println("Boy is laughing");
	}
}
