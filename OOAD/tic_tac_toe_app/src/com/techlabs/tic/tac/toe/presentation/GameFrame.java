package com.techlabs.tic.tac.toe.presentation;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.techlabs.tic.tac.toe.frame.FirstFrame;

public class GameFrame extends JFrame {
	private static final long serialVersionUID = 8794481143519867972L;

	public static void main(String[] args) {
//		GameFrame gf = new GameFrame();
//		gf.openFrame();
		new FirstFrame();

	}

	public void openFrame() {
		setVisible(true);
		setSize(500,500);
		setLayout(null);
		setTitle("Tic Tac Toe");
		JLabel name1 = new JLabel("Enter first player name: ");
		name1.setBounds(10,10,150,20);
		JButton button = new JButton("Next");
		button.setBounds(330,10,100,20);
		JTextField txt = new JTextField();
		txt.setBounds(180,10,100,20);
		add(txt);
		add(button);
		add(name1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
