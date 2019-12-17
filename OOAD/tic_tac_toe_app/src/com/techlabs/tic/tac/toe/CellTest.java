package com.techlabs.tic.tac.toe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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

}
