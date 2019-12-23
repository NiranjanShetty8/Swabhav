package com.techlabs.tic.tac.toe.tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import com.techlabs.tic.tac.toe.*;

class GameTest {
	Player player1 = new Player("p1",Mark.X);
	Player player2 = new Player("p2",Mark.O);
	ArrayList<Player> players = new ArrayList<Player>();
	Board board1 = new Board(3);
	ResultAnalyzer resultAn = new ResultAnalyzer(board1);
	
	@Test
	void check_if_current_player_switches_after_ever_Turn() {
		players.add(player1);
		players.add(player2);
		Game game1 = new Game(players, board1, resultAn);
		String expectedPlayer = players.get(0).toString();
		String expectedPlayer2 = players.get(1).toString();
		game1.play(0);
		String actualPlayer = game1.getCurrentPlayer().toString();
		assertEquals(expectedPlayer, actualPlayer);
		game1.play(1);
		String actualPlayer2 = game1.getCurrentPlayer().toString();
		assertEquals(expectedPlayer2, actualPlayer2);
		
	}

	@Test
	void test_if_game_gives_proper_results() {
	
		players.add(player1);
		players.add(player2);
		Game game1 = new Game(players, board1, resultAn);
		Result expectedProcess = Result.PROCESS;
//		Result expectedWin = Result.WIN;
		Result expectedDraw = Result.DRAW;
		game1.play(0);
		game1.play(1);
		game1.play(3);
		Result actualProcess = game1.play(4);
		game1.play(7);
		game1.play(6);
		game1.play(2);
		game1.play(8);
		Result actualDraw = game1.play(5);
		assertEquals(expectedProcess, actualProcess);
		assertEquals(expectedDraw, actualDraw);
		
	}

	@Test
	void check_win_condition() {
		players.add(player1);
		players.add(player2);
		Game game1 = new Game(players, board1, resultAn);
		Result expectedWin = Result.WIN;
		game1.play(0);
		game1.play(1);
		game1.play(3);
		game1.play(4);
		Result actualWin = game1.play(6);
		assertEquals(expectedWin, actualWin);
	}
}
