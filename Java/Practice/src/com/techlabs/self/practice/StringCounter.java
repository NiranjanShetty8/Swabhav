package com.techlabs.self.practice;

public class StringCounter {
	static int countG =0;
	static int countR =0;

	public static void main(String[] args) {
		
		char[] alphabets = { 'g', 'r', 'b', 'r', 'g', 'b', 'r', 'g' };
//		for (int i = 0, countB = alphabets.length-1; i < alphabets.length
//				&& countB>0 && countR<alphabets.length; i++) {
		int countB = alphabets.length - 1;
		for (int i = 0; i < alphabets.length; i++) {
			if (alphabets[i]=='r') {
				if(alphabets[countR]=='b') {
					alphabets[i] = alphabets[countB];
					alphabets[countB] = 'b';
					countB--;
				}
				alphabets[i] = alphabets[countR];
				alphabets[countR] = 'r';
				countR++;
//				continue;
			} else if (alphabets[i]=='b') {
				if(alphabets[countB]=='r') {
					alphabets[i] = alphabets[countR];
					alphabets[countR] = 'r';
					countR++;
				}
				alphabets[i] = alphabets[countB];
				alphabets[countB] = 'b';
				countB--;
//				continue;
			} else {
				countG++;
			}
//				for (char a : alphabets) {
//					System.out.print(a);
//				}
//				System.out.println();
//		}
		
//		for(int j =countR+1;j<=countR+countG;j++) {
//			System.out.println("here");
//			alphabets[j] = 'g';
		}
//		

		for (char a : alphabets) {
			System.out.println(a);
		}

	}
}
