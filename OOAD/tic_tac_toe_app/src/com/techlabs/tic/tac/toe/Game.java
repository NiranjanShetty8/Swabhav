package com.techlabs.tic.tac.toe;

import java.util.ArrayList;

public class Game {
	private Player currentPlayer;
	private ArrayList<Player> players = new ArrayList<Player>();
	private Board board;
	private ResultAnalyzer resultAn;

	public Game(ArrayList<Player> players, Board b, ResultAnalyzer resultAn) {
		this.players = players;
		this.board = b;
		this.resultAn = resultAn;

	}

	public void setCurrentPlayer() {
		if (currentPlayer == players.get(0)) {
			currentPlayer = players.get(1);
			return;
		}
		currentPlayer = players.get(0);
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public Board getB() {
		return board;
	}

	public ResultAnalyzer getResultAn() {
		return resultAn;
	}

	public Result play(int index) {
		setCurrentPlayer();
		Mark mark = getCurrentPlayer().getMark();
		board.putMarkInPosition(mark, index);
		Result result = resultAn.giveResult(board, mark, index);
		return result;

	}

}

