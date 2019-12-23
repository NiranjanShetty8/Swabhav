package com.techlabs.tic.tac.toe;

public class Player {
	private Mark mark;
	private String name;

	public Player(String name,Mark mark) {
		this.mark = mark;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public Mark getMark() {
		return mark;
	}

}
