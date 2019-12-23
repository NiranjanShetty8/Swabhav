package com.techlabs.observer.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Action implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame jf = new JFrame();
		JLabel jl = new JLabel("Just Kidding");
		jl.setLocation(100, 100);
		jf.add(jl);
		jf.setSize(200, 200);
		jf.setVisible(true);
		JPanel jp = new JPanel();
		jf.add(jp);
		

	}

}
