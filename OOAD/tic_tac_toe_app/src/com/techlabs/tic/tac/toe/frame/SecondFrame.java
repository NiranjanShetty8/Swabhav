package com.techlabs.tic.tac.toe.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SecondFrame extends JFrame {
	private static final long serialVersionUID = 4510235335905984782L;

	private String firstName;
	private String secondName;
	private int boardSize;

	public SecondFrame(String firstName) {
		this.firstName = firstName;
		setView();

	}

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public int getBoardSize() {
		return boardSize;
	}
	
	private void setView(){
		setVisible(true);
		setSize(500, 500);
		setLayout(null);
		setTitle("Tic Tac Toe");
		JLabel name = new JLabel("Enter second player's name: ");
		name.setBounds(10, 10, 190, 20);
		JButton button = new JButton("Next");
		button.setBounds(330, 10, 100, 20);
		button.setActionCommand("second");

		JLabel size = new JLabel("Choose the size of your board :");
		size.setBounds(10, 100, 200, 20);

		JRadioButton r3 = new JRadioButton("3");
		r3.setBounds(10, 120, 50, 50);
		JRadioButton r4 = new JRadioButton("4");
		r4.setBounds(60, 120, 50, 50);
		JRadioButton r5 = new JRadioButton("5");
		r5.setBounds(110, 120, 50, 50);

		ButtonGroup group = new ButtonGroup();
		group.add(r3);
		group.add(r4);
		group.add(r5);

		JTextField txt = new JTextField();
		txt.setBounds(180, 10, 100, 20);
		add(txt);
		add(name);
		add(button);
		add(size);
		add(r3);
		add(r4);
		add(r5);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (txt.getText().equalsIgnoreCase("")) {
					secondName = "Player 2";
				} else {
					secondName = txt.getText();
				}
				if (r4.isSelected()) {
					boardSize = 4;
				} else if (r5.isSelected()) {
					boardSize = 5;
				} else {
					boardSize = 3;
				}
				
				dispose();
				new BoardFrame(firstName, secondName, boardSize);

			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
