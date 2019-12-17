package com.techlabs.lsp.violation.test;

import com.techlabs.lsp.violation.Rectangles;
import com.techlabs.lsp.violation.Square;

public class RectangleTest {

	public static void main(String[] args) {
		Rectangles r1 = new Rectangles(30,20);
		System.out.println(should_not_change_width_if_height_changes(r1));
		Square s1 = new Square(30);
		System.out.println(should_not_change_width_if_height_changes(s1));

	}

	public static boolean should_not_change_width_if_height_changes(Rectangles obj) {
		int before = obj.getWidth();
		obj.setHeight(obj.getHeight()+10);
		int after = obj.getWidth();
		if(before == after) {
			return true;
		}
		return false;
	}
}
