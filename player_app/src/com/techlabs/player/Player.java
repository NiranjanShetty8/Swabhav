package com.techlabs.player;

public class Player {
	private int id;
	private String name;
	private int age;

	public Player(int id, String name) {
		this(id, name, 18);
	}

	public Player(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public Player whoIsElder(Player player) {
		if (player.getAge() > this.getAge()) {
			return player;
		} else {
			return this;
		}
	}

}

