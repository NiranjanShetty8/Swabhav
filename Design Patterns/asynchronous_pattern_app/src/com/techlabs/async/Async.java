package com.techlabs.async;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Async extends JFrame {
	private static final long serialVersionUID = -59176126748138725L;

	public Async() {
		this.setVisible(true);
		this.setSize(400, 400);
		this.setLayout(null);
		this.setTitle("Asynchronous");
		JPanel jp = new JPanel();
		jp.setBounds(0, 0, 300, 100);
		JDialog jd = new JDialog(this, "hello", true);
		JButton date = new JButton("print date");
		date.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Thread obj = new Thread(new F1Thread());
				obj.start();
			}
		});

		JButton hello = new JButton("print hello");
		hello.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jd.setVisible(true);

			}
		});
		jp.add(date);
		jp.add(hello);
		this.add(jp);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Async();
	}

}
