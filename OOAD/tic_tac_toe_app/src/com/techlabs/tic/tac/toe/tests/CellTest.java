package com.techlabs.tic.tac.toe.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.techlabs.tic.tac.toe.*;
class CellTest {
	Cell c = new Cell();
	Mark expectedMark;
	Mark actualMark;

	@Test
	void if_mark_is_empty_when_cell_is_created() {
		expectedMark = Mark.EMPTY;
		
		actualMark = c.getMark();
		assertEquals(expectedMark, actualMark);
		
	}
	
	@Test
	void if_marking_is_done_properly() {
		Cell cO = new Cell(Mark.O);
		expectedMark = Mark.O;
		actualMark = cO.getMark();
		assertEquals(expectedMark, actualMark);
		
		Cell cX = new Cell(Mark.X);
		expectedMark = Mark.X;
		actualMark = cX.getMark();
		assertEquals(expectedMark, actualMark);
	}
	
	@Test
	void if_set_mark_works_properly() {
		expectedMark = Mark.O;
		c.setMark(Mark.O);
		actualMark = c.getMark();
		assertEquals(expectedMark, actualMark);
	}
	@Test
	void check_if_marks_dont_overwrite_other_marks_in_a_call_and_throws_exception_if_we_try() {
		String errorMsg = null;
		boolean result = false;
		Mark expected = Mark.O;
		c.setMark(Mark.O);
		try {
			c.setMark(Mark.X);
		} catch (RuntimeException e) {
			result = true;
			errorMsg = e.getMessage();
		}
		Mark actual = c.getMark();
		assertEquals(expected, actual);
		assertTrue(result);
		assertEquals("Mark already present", errorMsg );
		
	}
}
