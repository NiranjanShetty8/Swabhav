package com.techlabs.player;

public class Player {
	private int id;
	private String name;
	private int age;
	private static int count =0;
	
	public Player() {
		
	}

	public Player(int id, String name) {
		this(id, name, 18);
	}

	public Player(int id, String name, int age) {
		//count++;
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
	
	public static int getCount() {
		return count;
	}

}

