package com.techlabs.observer.frame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WelcomeFrame extends JFrame {


	public WelcomeFrame() {
//		Container contentPane = this.getContentPane();
		
		
		setVisible(true);
		setTitle("Niranjan");
	
		JButton jb = new JButton("You have 3 wishes");
//		JPanel jp = new JPanel();
//		jp.setBounds(200, 200, 100, 20);
//		jp.setBackground(Color.BLUE);
	
		jb.setLocation(150, 150);
		jb.addActionListener(new Action());
		add(jb);
//		this.getContentPane().add(jp);
		
		
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
