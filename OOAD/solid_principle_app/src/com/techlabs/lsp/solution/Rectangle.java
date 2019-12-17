package com.techlabs.lsp.solution;

public class Rectangle implements IShape {
	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
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
	
	@Override
	public int calculateArea() {
		int area = height * width;
		return area;
	}

}
