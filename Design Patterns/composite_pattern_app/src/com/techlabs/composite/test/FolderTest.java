package com.techlabs.composite.test;

import com.techlabs.composite.*;

public class FolderTest {

	public static void main(String[] args) {
		Folder f1 = new Folder("movie");
		
		IStorable f11 = new File("abc",1100,"avi");
		IStorable f12 = new File("def",1800,"mp4");
		
		Folder f2 = new Folder("Comedy");
		IStorable f21 = new File("ghi",1200,"mp4");
		IStorable f22 = new File("jkl",1600,"avi");
		
		Folder f3 = new Folder("Action");
		IStorable f31 = new File("mno",1900,"mp4");
		
		IStorable f13 = new File("pqr",2000,"avi");
	
		f3.addChild(f31);
		f1.addChild(f11);
		f1.addChild(f12);
		f1.addChild(f2);
		f2.addChild(f21);
		f2.addChild(f22);
		f1.addChild(f3);
		f1.addChild(f13);
		
		
		f1.display("");
		
	}
	
}
