package com.techlabs.player.test;

import com.techlabs.player.Player;

public class PlayerTest {

	public static void main(String[] args) {
		Player niranjan = new Player(101, "Niranjan");
		System.out.println(niranjan.getAge());
		System.out.println(niranjan.getName());
		System.out.println(niranjan.getId());
		Player sachin = new Player(102, "Sachin", 20);
		System.out.println(sachin.whoIsElder(niranjan).getName());

	}

}

