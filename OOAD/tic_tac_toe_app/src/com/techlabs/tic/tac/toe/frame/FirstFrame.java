package com.techlabs.tic.tac.toe.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FirstFrame extends JFrame {
	private static final long serialVersionUID = -5472992898815249993L;

	private JTextField txt;
	private JLabel name1;

	public FirstFrame() {
		setVisible(true);
		setSize(500, 500);
		setLayout(null);
		setTitle("Tic Tac Toe");
		name1 = new JLabel("Enter First player's name: ");
		name1.setBounds(10, 10, 180, 20);
		JButton button = new JButton("Next");
		button.setBounds(330, 10, 100, 20);
		button.setActionCommand("first");

		txt = new JTextField();
		txt.setBounds(180, 10, 100, 20);
		add(txt);
		add(button);
		add(name1);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String firstPlayer;
				if(txt.getText().equalsIgnoreCase("")) {
					firstPlayer = "Player 1";
				}else {
					firstPlayer = txt.getText();
				}
				dispose();
				new SecondFrame(firstPlayer);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JTextField getTxt() {
		return txt;
	}

	public JLabel getName1() {
		return name1;
	}

	public void setName1(JLabel name1) {
		this.name1 = name1;
	}

}
