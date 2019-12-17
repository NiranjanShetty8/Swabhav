package com.techlabs.lsp.violation;

public class Square extends Rectangles {

	public Square(int side) {
		super(side,side);
	}
	
	@Override
	public void setWidth(int side){
		this.height = this.width = side;
	}
	
	@Override
	public void setHeight(int side){
		this.height = this.width = side;
	}
	
}
