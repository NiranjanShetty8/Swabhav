package com.techlabs.observer.name;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Hello extends JFrame{
	private static final long serialVersionUID = -3012355435097906168L;

	public Hello(String name) {
		setLayout(null);
		setSize(500, 500);
		setVisible(true);
		JLabel label = new JLabel("Hello "+ name);
		add(label);
		label.setBounds(100,100,100,20);
		
		
		
	}
}
