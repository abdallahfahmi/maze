package Control;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter {

	MovementObserver movementObserver;
	public KeyController(MovementObserver movementObserver)
	{
		this.movementObserver = movementObserver;
	}
	
	public void keyPressed(KeyEvent ke) {
		 
		int keyCode = ke.getKeyCode();
		movementObserver.movementUpdate(keyCode);
	}
}
