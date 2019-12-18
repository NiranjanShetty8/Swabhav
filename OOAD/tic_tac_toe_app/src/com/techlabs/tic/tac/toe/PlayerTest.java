package com.techlabs.tic.tac.toe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void Player_constructor_and_get_Mark() {
		Player p1 = new Player(Mark.O);
		Mark expected = Mark.O;
		Mark actual = p1.getMark();
		assertEquals(expected, actual);
	}

}
