package com.techlabs.tic.tac.toe.frame;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.techlabs.tic.tac.toe.*;

@SuppressWarnings("serial")
public class BoardFrame extends JFrame {
	
	private String p1;
	private String p2;
	private int boardSize;
	private JLabel resultLabel;
	private JLabel nameLabel;
	private Game game;
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();

	public BoardFrame(String p1, String p2, int boardSize) {
		this.p1 = p1;
		this.p2 = p2;
		this.boardSize = boardSize;
		
		addPlayers();
		createBoard();
		createLabel();
		createButton();

		setTitle("Tic Tac Toe Board");
		setSize(700, 700);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public String getP1() {
		return p1;
	}

	public String getP2() {
		return p2;
	}

	public int getBoardSize() {
		return boardSize;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public JLabel getResultLabel() {
		return resultLabel;
	}

	public void setStringResultLabel(String result) {
		this.resultLabel.setText(result);
	}
	
	private void addPlayers() {
		Player player1 = new Player(p1, Mark.X);
		Player player2 = new Player(p2, Mark.O);
		players.add(player1);
		players.add(player2);
	}
	
	private void createBoard() {

		Board board = new Board(boardSize);
		ResultAnalyzer rza = new ResultAnalyzer(board);
		Game game1 = new Game(players, board, rza);
		this.game = game1;
	}
	
	private void createButton() {
		ButtonAction action = new ButtonAction(this, game);
		JButton button0 = new JButton("0");
		button0.setBounds(210, 210, 50, 50);
		button0.addActionListener(action);

		JButton button1 = new JButton("1");
		button1.setBounds(270, 210, 50, 50);
		button1.addActionListener(action);

		JButton button2 = new JButton("2");
		button2.setBounds(330, 210, 50, 50);
		button2.addActionListener(action);

		JButton button3 = new JButton("3");
		button3.setBounds(210, 270, 50, 50);
		button3.addActionListener(action);

		JButton button4 = new JButton("4");
		button4.setBounds(270, 270, 50, 50);
		button4.addActionListener(action);

		JButton button5 = new JButton("5");
		button5.setBounds(330, 270, 50, 50);
		button5.addActionListener(action);

		JButton button6 = new JButton("6");
		button6.setBounds(210, 330, 50, 50);
		button6.addActionListener(action);

		JButton button7 = new JButton("7");
		button7.setBounds(270, 330, 50, 50);
		button7.addActionListener(action);

		JButton button8 = new JButton("8");
		button8.setBounds(330, 330, 50, 50);
		button8.addActionListener(action);

		add(button0);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button7);
		add(button8);
		
		buttons.add(button0);
		buttons.add(button1);
		buttons.add(button2);
		buttons.add(button3);
		buttons.add(button4);
		buttons.add(button5);
		buttons.add(button6);
		buttons.add(button7);
		buttons.add(button8);
	}
	
	private void createLabel() {
		JLabel label1 = new JLabel("Click the button to put your mark: ");
		label1.setBounds(80, 100, 500, 100);
		label1.setFont(new Font("Serif", Font.BOLD , 30));
		add(label1);
		
		resultLabel = new JLabel("RESULT: PROCESS");
		resultLabel.setBounds(300, 30, 400, 50);
		resultLabel.setFont(new Font("Serif", Font.BOLD, 20));
		add(resultLabel);
		
		nameLabel = new JLabel("It is " +p1.toString() +"'s turn.");
		nameLabel.setBounds(10, 30, 300, 50);
		nameLabel.setFont(new Font("TimesRoman", Font.LAYOUT_LEFT_TO_RIGHT, 30));
		add(nameLabel);
		
		
	}

	public ArrayList<JButton> getButtons() {
		return buttons;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setStringNameLabel(String name) {
		this.nameLabel.setText(name);
	}
//	public void createrButton() {
//		int i;
//		for(i=0; i<9 ; i++) {
//			JButton button = new JButton(Integer.toString(i));
//			add(button);
//			button.addActionListener(action);
//		}
//	}
}



