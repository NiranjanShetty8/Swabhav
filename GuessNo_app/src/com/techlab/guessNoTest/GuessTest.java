package com.techlab.guessNoTest;

public class GuessTest {
	public static void main(String[] args) {
	String s1 = "java";
	String s2 = s1;
	s1 = s2.concat(" rules");
	System.out.println("s1 refers to "+s1); 
	System.out.println(s2);
}
}
