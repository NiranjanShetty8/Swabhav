package com.techlabs.tic.tac.toe;

public class Cell {
	private Mark mark;
	
	public Cell() {
		this.mark = Mark.EMPTY;
	}
	
	public Cell(Mark mark) {
		this.mark = mark;
	}

	public Mark getMark() {
		return mark;
	}

}
