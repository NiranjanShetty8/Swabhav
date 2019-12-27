package com.techlabs.observer.frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WelcomeFrame {
	private JButton hello;
	private JButton exit;

	public WelcomeFrame() {
		Action action = new Action();
		JFrame frame = new JFrame();

		frame.setVisible(true);
		frame.setTitle("Niranjan");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		hello = new JButton("Hello");
		hello.setBounds(10, 150, 200, 20);
		hello.setActionCommand(JButtonType.HELLO.name());
		
		hello.addActionListener(action);

		exit = new JButton("Bye");
		exit.setBounds(220, 150 , 200, 20);
		exit.setActionCommand(JButtonType.EXIT.name());
		exit.addActionListener(action);
		

		panel.add(hello);
		panel.add(exit);
	}

	public JButton getHello() {
		return hello;
	}

	public JButton getExit() {
		return exit;
	}

}
