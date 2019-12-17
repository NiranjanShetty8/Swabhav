package com.techlabs.lsp.violation;

public class Rectangles {
	protected int width;
	protected int height;
	
	public Rectangles(int width, int height) {
		this.height = height;
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int calculateArea() {
		int area = height * width;
		return area;
	}

}
