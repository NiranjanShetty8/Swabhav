package com.techlabs.tic.tac.toe.presentation;

import java.util.ArrayList;
import java.util.Scanner;

import com.techlabs.tic.tac.toe.*;

public class GameConsole {

	public static void main(String[] args) {
		GameConsole gc = new GameConsole();

		ArrayList<Player> players = new ArrayList<Player>();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of board" + "(For 3x3 board enter 3): ");
		int size = sc.nextInt();
		Board board1 = new Board(size);

		System.out.println("Enter the name of the first player: ");
		String name1 = sc.next();
		Player player1 = new Player(name1, Mark.X);

		System.out.println("Enter the name of the second player: ");
		String name2 = sc.next();
		Player player2 = new Player(name2, Mark.O);

		players.add(player1);
		players.add(player2);

		ResultAnalyzer resultAn = new ResultAnalyzer(board1);
		Game game1 = new Game(players, board1, resultAn);
		gc.printStatus(board1);
		System.out.println(name1 + " to play(pick the position to enter mark: ");
		
		for (int i = 0; i < size * size; i++) {
			int index = sc.nextInt();

			try {
				game1.play(index);
				System.out.println(game1.nextPlayer()
						+ " to play: ");
			} catch (RuntimeException e) {
				game1.setCurrentPlayer();
				System.out.println(e.getMessage());
				System.out.println("Try again");

			}

			Result result = resultAn.giveResult(board1, 
					game1.getCurrentPlayer().getMark(), index);
			gc.printStatus(board1);
				if (result == Result.WIN) {
					System.out.println("Congratulations, " 
							+ game1.getCurrentPlayer().getName() + " won. \nThe Game"
									+ " has ended.");
					break;
				} else if (result == Result.DRAW) {
					System.out.println("It's a draw.");
					break;
				}
			}
	}

	public void printStatus(Board b) {
		int size = (int) Math.sqrt(b.getCellList().size());
		int index = 0;
		for (int i = 0; i < size; i++) {
			System.out.println();
			for (int j = 0; j < size; j++) {
				if (b.getCellList().get(index).getMark() == Mark.EMPTY) {
					System.out.print(" - ");
					index++;
					continue;
				} else if (b.getCellList().get(index).getMark() == Mark.X) {
					System.out.print(" X ");
					index++;
					continue;
				} else {
					System.out.print(" O ");
					index++;
				}
			}
		}
		System.out.println();
	}

}
