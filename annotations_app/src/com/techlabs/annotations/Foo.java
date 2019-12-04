package com.techlabs.annotations;


public class Foo {
	public void greet() {
		System.out.println("Hello");
	}

	@RequireRefactor(key = 10)
	public void go() {
		System.out.println("bye");
	}

	public void play() {
		System.out.println("Playing");
	}

	@RequireRefactor(key = 10)
	public void dance() {
		System.out.println("dancing");
	}

}
