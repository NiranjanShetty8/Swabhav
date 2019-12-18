package com.techlabs.tic.tac.toe;

import java.util.ArrayList;

public class ResultAnalyzer {
	private Result result;
	private ArrayList<Cell> cellList = new ArrayList<Cell>();
	private ResultAnalyzer resultAn;

	public ResultAnalyzer(Board obj) {
		cellList = obj.getCellList();
	}
	
	public ResultAnalyzer getResultAn() {
		return resultAn;
	}

	public Result getResult() {
		return result;
	}

	public ArrayList<Cell> getCellList() {
		return cellList;
	}
	
	public Result giveResult(Board b,Mark mark,int index) {
		Result result = Result.PROCESS;
		boolean resultCheck = checkRow(mark, index)|| 
				checkColumn(mark, index) ||
				checkForwardDiagonal(mark, index) || 
				checkReverseDiagonal(mark, index);
		if(resultCheck) {
			result = Result.WIN;
			return result;
		}
		else if(b.checkIfBoardIsFull()) {
			result = Result.DRAW;
			return result;
		}
		return result;
	}

	public boolean checkForwardDiagonal(Mark mark, int index) {
		int firstIndex = 0;
		int limit = (int) Math.sqrt(cellList.size());
		if (index % limit == index / limit) {
			for (int i = firstIndex; i < cellList.size(); i = i + limit + 1) {
				if (cellList.get(i).getMark() != mark) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean checkReverseDiagonal(Mark mark, int index) {
		int limit = (int) Math.sqrt(cellList.size());
		int firstIndex = limit - 1;
		if ((index % limit) + (index / limit) == firstIndex) {
			for (int i = firstIndex; i < cellList.size() - 1; i = i + firstIndex) {
				if (cellList.get(i).getMark() != mark) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean checkRow(Mark mark, int index) {
		int limit = (int) Math.sqrt(cellList.size());
		int row = index / limit;
		int firstIndex = row * limit;
		for (int i = firstIndex; i < firstIndex + limit; i++) {
			if (cellList.get(i).getMark() != mark) {
				return false;
			}
		}
		return true;
	}

	public boolean checkColumn(Mark mark, int index) {
		int limit = (int) Math.sqrt(cellList.size());
		int firstIndex = index % limit;
		for (int i = firstIndex; i < cellList.size(); i = i + limit) {
			if (cellList.get(i).getMark() != mark) {
				return false;
			}
		}
		return true;

	}


}

//public boolean checkDiagonal() {
//	cellList = b.getCellList();
//	boolean diagonal1 = cellList.get(0).getMark() == cellList.get(4).getMark() 
//			&& cellList.get(4) == cellList.get(8)
//			&& cellList.get(0).getMark() != Mark.EMPTY;
//	boolean diagonal2 = cellList.get(2).getMark() == cellList.get(4).getMark()
//			&& cellList.get(4) == cellList.get(6)
//			&& cellList.get(2).getMark() != Mark.EMPTY;
//	if (diagonal1) {
//		return true;
//	} else if (diagonal2) {
//		return true;
//	}
//	return false;
//}
