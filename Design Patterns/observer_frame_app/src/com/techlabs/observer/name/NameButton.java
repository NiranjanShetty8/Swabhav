package com.techlabs.observer.name;

import javax.swing.*;

public class NameButton extends JFrame {
	private static final long serialVersionUID = 6663269784869308971L;

	private JTextField txt;

	public NameButton() {
		Handler handle = new Handler(this);
		setSize(500, 500);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 500);
		panel.setLayout(null);
		JLabel label = new JLabel("Name");
		label.setBounds(10, 200, 100, 20);
		txt = new JTextField();
		txt.setBounds(50, 185, 300, 40);
		panel.add(label);
		panel.add(txt);
		JButton button = new JButton("Next");
		button.setBounds(360, 200, 100, 20);
		button.addActionListener(handle);
		panel.add(button);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JTextField getTxt() {
		return txt;
	}
}
