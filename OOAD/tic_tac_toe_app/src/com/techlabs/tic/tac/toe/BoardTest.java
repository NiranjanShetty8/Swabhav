package com.techlabs.tic.tac.toe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void check_if_board_is_created_with_proper_number_of_Cells() {
		Board b1 = new Board(3);
		int expectedSize = 9;
		int actualSize = b1.getCellList().size();
		assertEquals(expectedSize, actualSize);
	}
	
	@Test
	void check_if_board_has_empty_cells() {
		Board b2 = new Board(3);
		Mark expected = Mark.EMPTY;
		Mark actual = b2.getCellList().get(0).getMark();
		Mark actual1 = b2.getCellList().get(1).getMark();
		Mark actual2 = b2.getCellList().get(2).getMark();
		Mark actual3 = b2.getCellList().get(3).getMark();
		Mark actual4 = b2.getCellList().get(4).getMark();
		Mark actual5 = b2.getCellList().get(5).getMark();
		Mark actual6 = b2.getCellList().get(6).getMark();
		Mark actual7 = b2.getCellList().get(7).getMark();
		Mark actual8 = b2.getCellList().get(8).getMark();
		assertEquals(expected, actual);
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
		assertEquals(expected, actual4);
		assertEquals(expected, actual5);
		assertEquals(expected, actual6);
		assertEquals(expected, actual7);
		assertEquals(expected, actual8);
	}
	
	@Test
	void check_if_marks_can_be_set_on_a_given_position() {
		Board b = new Board(3);
		Mark expectedMark = Mark.O;
		Mark expected = Mark.X;
		b.putMarkInPosition(Mark.O, 2);
		b.putMarkInPosition(Mark.X, 3);
		Mark actualMark = b.getCellList().get(2).getMark();
		Mark actual = b.getCellList().get(3).getMark();
		assertEquals(expectedMark, actualMark);
		assertEquals(expected, actual);
	}
	
	@Test
	void check_if_marks_dont_overwrite_other_marks_and_throws_exception_if_we_try() {
		Board b = new Board(3);
		String errorMsg = null;
		boolean result = false;
		Mark expected = Mark.O;
		b.putMarkInPosition(Mark.O, 2);
		try {
			b.putMarkInPosition(Mark.X, 2);
		} catch (RuntimeException e) {
			result = true;
			errorMsg = e.getMessage();
		}
		Mark actual = b.getCellList().get(2).getMark();
		assertEquals(expected, actual);
		assertTrue(result);
		assertEquals("Mark already present", errorMsg );
		
	}
	
	@Test
	void check_if_board_full_returns_true_if_board_is_full() {
		Board b = new Board(3);
		boolean expected = false;
		boolean expectedResult = true;
		b.putMarkInPosition(Mark.O, 0);
		b.putMarkInPosition(Mark.X, 1);
		b.putMarkInPosition(Mark.O, 2);
		b.putMarkInPosition(Mark.X, 3);
		b.putMarkInPosition(Mark.O, 4);
		b.putMarkInPosition(Mark.X, 5);
		b.putMarkInPosition(Mark.O, 6);
		b.putMarkInPosition(Mark.X, 7);
		boolean actual = b.checkIfBoardIsFull();
		b.putMarkInPosition(Mark.O, 8);
		boolean actualResult = b.checkIfBoardIsFull();
		assertEquals(expected, actual);
		assertEquals(expectedResult, actualResult);
	}
	
}
