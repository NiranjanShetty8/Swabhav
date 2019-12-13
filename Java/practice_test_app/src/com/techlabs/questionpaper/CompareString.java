package com.techlabs.questionpaper;

public class CompareString {
	public static void main(String[] args) {
		System.out.println(compare("geeksa","geeks"));

	}

	public static int compare(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int a1 = 0;
		int a2 = 0;
		
		for(int i=0;i<c1.length;i++) {
			a1 = a1 + c1[i]*1;
		}
		
		for(int j =0; j<c2.length;j++) {
			a2 = a2 + c2[j]*1;
		}
		if(a1>a2) {
			return 1;
		}
		else if(a1<a2) {
			return -1;
		}
		return 0;
	}

}
