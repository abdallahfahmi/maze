package Control;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import View.Game;

public class StatusObserver {
	
	public Game game;
	
	public StatusObserver(Game game)
	{
		this.game = game;
	}
	
	public void gameOverUpdate()
	{
		game.removeListener();
		JOptionPane.showMessageDialog(new JPanel(), "BOOOOOOOOOOM!!", "Game Over", JOptionPane.ERROR_MESSAGE);
	}

}
