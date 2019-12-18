package com.techlabs.tic.tac.toe;

import java.util.ArrayList;

public class Board {
	private ArrayList<Cell> cellList = new ArrayList<Cell>();

	public Board(int size) {
		for (int i = 0; i < size * size; i++) {
			cellList.add(new Cell());
		}
	}

	public ArrayList<Cell> getCellList() {
		return cellList;
	}

	public ArrayList<Cell> putMarkInPosition(Mark mark, int index) {
		cellList.get(index).setMark(mark);
		return cellList;
	}

	public boolean checkIfBoardIsFull() {
		int index = 0;
		while (index < cellList.size()) {
			if(cellList.get(index).getMark() == Mark.EMPTY) {
				break;
			}
			else if (cellList.get(index).getMark() != Mark.EMPTY) {
				if (index == cellList.size() - 1) {
					return true;
				}
				index++;
			} 
		}
		return false;
	}
}
