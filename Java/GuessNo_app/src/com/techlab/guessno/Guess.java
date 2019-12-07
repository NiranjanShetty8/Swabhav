package com.techlab.guessno;

import java.util.Scanner;
import java.util.Random;

public class Guess {
	public static void main(String args[]) {

		System.out.println("Enter your guess");
		Scanner sc = new Scanner(System.in);
		Guess gu = new Guess();
		gu.start();
		boolean b = true;
		String decision;
		System.out.println("Do you wish to play again?");
		decision = sc.nextLine();
		switch (decision) {
		case "yes":
			System.out.println("Enter your guess");
			gu.start();
		case "no":
			stop();
		}

	}

	public void start() {
		Random r = new Random();
		int randno = r.nextInt(100);
		int i = 0;
		boolean win = false;
		while (win == false) {
			Scanner sc = new Scanner(System.in);
			int guess = sc.nextInt();
			i = i + 1;
			if (guess > randno) {
				System.out.println("Your guess is higher than the actual number");

			} else if (guess < randno) {
				System.out.println("Your guess is lower than the actual number");

			} else {
				win = true;
			}
		}
		System.out.println("Your have guessed correctly");
		System.out.println("Number of guessses " + i);
		System.out.println("The actual number was " +randno);
	}

	public static void stop() {
		System.out.println("Thanks for playing");
	}
}
