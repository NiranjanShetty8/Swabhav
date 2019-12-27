package com.techlabs.tic.tac.toe.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import com.techlabs.tic.tac.toe.Game;
import com.techlabs.tic.tac.toe.Result;

public class ButtonAction implements ActionListener {

	private Game game;
	private BoardFrame bf;
	
	public ButtonAction(BoardFrame bf, Game game) {
		this.game = game;
		this.bf = bf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		Result r = game.play(Integer.parseInt(button.getText()));
		button.setText(game.getCurrentPlayer().getMark().toString());
		button.setEnabled(false);
		
		bf.setStringResultLabel("RESULT: " +r.toString());
		bf.setStringNameLabel(game.nextPlayer() + " to play");
		
		if(r == Result.WIN) {
			for(JButton butn : bf.getButtons()) {
				butn.setEnabled(false);
			}
			bf.setStringResultLabel("Congratulations!!! " 
					+game.getCurrentPlayer().getName() + " WON!!!");
			bf.setStringNameLabel("");
		}
		
		else if(r == Result.DRAW) {
			for(JButton butn : bf.getButtons()) {
				butn.setEnabled(false);
			}
			bf.setStringResultLabel("The game is a draw!! Well played.");
			bf.setStringNameLabel("");
		}
	}

	public Game getGame() {
		return game;
	}

}
