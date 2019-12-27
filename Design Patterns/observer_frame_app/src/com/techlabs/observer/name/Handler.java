package com.techlabs.observer.name;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Handler implements ActionListener {

	NameButton name;
	public Handler(NameButton name) {
		this.name = name;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new Hello(name.getTxt().getText());
		
	
	}

}
