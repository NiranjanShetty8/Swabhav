package com.techlabs.tic.tac.toe.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.techlabs.tic.tac.toe.*;

class PlayerTest {

	@Test
	void Player_constructor_and_get_Mark() {
		Player p1 = new Player("Niranjan", Mark.O);
		Mark expected = Mark.O;
		Mark actual = p1.getMark();
		String expectedName = "Niranjan";
		String actualName = p1.getName();
		assertEquals(expected, actual);
		assertEquals(expectedName, actualName);
	}

}
