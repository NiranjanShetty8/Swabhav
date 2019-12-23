package com.techlabs.tic.tac.toe.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.techlabs.tic.tac.toe.*;

class ResultAnalyzerTest {

	@Test
	void test_if_row_check_works() {
		Board b = new Board(3);
		b.putMarkInPosition(Mark.O, 3);
		b.putMarkInPosition(Mark.O, 4);
		
		ResultAnalyzer analyzeb = new ResultAnalyzer(b);
		boolean actual = analyzeb.checkRow(Mark.O, 4);
		b.putMarkInPosition(Mark.O, 5);
		boolean expected = false;
		boolean expectedResult = true;
		boolean actualResult = analyzeb.checkRow(Mark.O, 5);
	
		assertEquals(expected, actual);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void test_if_column_check_works() {
		Board b = new Board(3);
		b.putMarkInPosition(Mark.O, 2);
		b.putMarkInPosition(Mark.O, 5);
		
		ResultAnalyzer analyzeb = new ResultAnalyzer(b);
		boolean actual = analyzeb.checkColumn(Mark.O, 5);
		b.putMarkInPosition(Mark.O, 8);
		boolean expected = false;
		boolean expectedResult = true;
		boolean actualResult = analyzeb.checkColumn(Mark.O, 8);
	
		assertEquals(expected, actual);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void test_if_forward_diagonal_check_works() {
		Board b = new Board(3);
		b.putMarkInPosition(Mark.O, 0);
		b.putMarkInPosition(Mark.O, 4);
		
		ResultAnalyzer analyzeb = new ResultAnalyzer(b);
		boolean actual = analyzeb.checkForwardDiagonal(Mark.O, 4);
		b.putMarkInPosition(Mark.O, 8);
		boolean expected = false;
		boolean expectedResult = true;
		boolean actualResult = analyzeb.checkForwardDiagonal(Mark.O, 8);
	
		assertEquals(expected, actual);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void test_if_reverse_diagonal_check_works() {
		Board b = new Board(3);
		b.putMarkInPosition(Mark.O, 2);
		b.putMarkInPosition(Mark.O, 4);
		
		ResultAnalyzer analyzeb = new ResultAnalyzer(b);
		boolean actual = analyzeb.checkReverseDiagonal(Mark.O, 4);
		b.putMarkInPosition(Mark.O, 6);
		boolean expected = false;
		boolean expectedResult = true;
		boolean actualResult = analyzeb.checkReverseDiagonal(Mark.O, 6);
	
		assertEquals(expected, actual);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void test_if_result_analyser_gives_proper_results() {
		Board b = new Board(3);
		Result expectedDraw = Result.DRAW;
//		Result expectedWin = Result.WIN;
		Result expectedProcess = Result.PROCESS;
		b.putMarkInPosition(Mark.O,0);
		b.putMarkInPosition(Mark.X,1);
		b.putMarkInPosition(Mark.O,2);
		b.putMarkInPosition(Mark.X,3);
		b.putMarkInPosition(Mark.O,4);
		b.putMarkInPosition(Mark.X,5);
		b.putMarkInPosition(Mark.X,6);
		b.putMarkInPosition(Mark.O,7);
		ResultAnalyzer resultAn = new ResultAnalyzer(b);
		Result actualProcess = resultAn.giveResult(b, Mark.O, 7);
		b.putMarkInPosition(Mark.X, 8);
		Result actualDraw = resultAn.giveResult(b, Mark.X, 8);
		assertEquals(expectedProcess, actualProcess);
		assertEquals(expectedDraw, actualDraw);
		
	}
	
	@Test
	void test_if_column4x4_check_works() {
		Board b = new Board(4);
		b.putMarkInPosition(Mark.O, 2);
		b.putMarkInPosition(Mark.O, 6);
		b.putMarkInPosition(Mark.O, 10);
		ResultAnalyzer analyzeb = new ResultAnalyzer(b);
		boolean actual = analyzeb.checkColumn(Mark.O, 10);
		b.putMarkInPosition(Mark.O, 14);
		boolean expected = false;
		boolean expectedResult = true;
		boolean actualResult = analyzeb.checkColumn(Mark.O, 14);
	
		assertEquals(expected, actual);
		assertEquals(expectedResult, actualResult);
	}
}
