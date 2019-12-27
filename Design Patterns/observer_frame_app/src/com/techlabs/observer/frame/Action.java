package com.techlabs.observer.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Action implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()==JButtonType.HELLO.name()) {
			JFrame jf = new JFrame();
			jf.setTitle("Hello");
			JLabel label = new JLabel("hello");
			label.setBounds(50, 50, 100, 100);
			JPanel jp = new JPanel();
			jf.add(jp);
			jp.add(label);
			jf.setSize(200, 200);
			jf.setVisible(true);
		}
		else if(e.getActionCommand()==JButtonType.EXIT.name()) {
			System.exit(0);
		}
		

	}

}
