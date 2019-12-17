package com.techlabs.self.practice;

public class StringCounter {
	static int countG =0;
	static int countR =0;

	public static void main(String[] args) {
		
		char[] alphabets = { 'g', 'r', 'b', 'r', 'g', 'b', 'r' };
		for (int i = 0, countB = alphabets.length-1,countR=0; i < alphabets.length
				&& countB>0 && countR<alphabets.length; i++) {
			if (alphabets[i]=='r') {
				alphabets[countR] = 'r';
				countR++;
				continue;
			} else if (alphabets[i]=='b') {
				alphabets[countB] = 'b';
				countB--;
				continue;
			}
				countG++;
				StringCounter.countR = countR;
		}
		
		for(int j =countR;j<=countR+countG;j++) {
			alphabets[j] = 'g';
		}
		

		for (char a : alphabets) {
			System.out.println(a);
		}

	}
}
