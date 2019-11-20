package com.techlabs.person;

public class Person {
	private String name;
	private int age;
	private String gender;
	private float height;
	private float weight;

	public Person(String newName, int newAge, String newGender, float newHeight, 
			float newWeight) {
		name = newName;
		age = newAge;
		gender = newGender;
		height = newHeight;
		weight = newWeight;

	}

	public Person(String newName, int newAge) {
		name = newName;
		age = newAge;
		gender = "Male";
		height = 5f;
		weight = 50f;

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public float getHeight() {
		return height;
	}

	public float getWeight() {
		return weight;
	}

	public void workOut() {
		weight = weight - weight * 2 / 100;
	}

	public void eat() {
		weight = weight + weight / 100;
		height = (float) (height + height * 0.25 / 100);
	}
}
