package com.techlabs.person;

public class Person {

	private String name;
	private int age;
	private GenderOptions gender;
	private float height;
	private float weight;

	public Person(String name, int age, GenderOptions gender, float height, float weight) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
//		if ((float)(height % (int) height) > 0.11f)
//			height = (int) height + 1f;
		this.weight = weight;

	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		gender = GenderOptions.MALE;
		height = 5f;
		weight = 50f;

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public GenderOptions getGender() {
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

	public double getBmi() {
		float heightCm = height * 35.48f;
		double bmi = (weight / (heightCm * heightCm)) * 10000f;
		return bmi;
	}

}
