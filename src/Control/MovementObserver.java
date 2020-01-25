package Control;



import java.awt.event.KeyEvent;


import Model.Grid;

public class MovementObserver {

    State currentState;
    String currentDirection="right";
    Grid grid;
    StatusObserver gameStatusObserver;

        public MovementObserver(Grid grid, StatusObserver gameStatusObserver) {
            this.grid = grid;
            this.gameStatusObserver = gameStatusObserver;
        }
	
	public void movementUpdate(int keyCode)
	{
		
		switch(keyCode)
		{
		case KeyEvent.VK_UP:
                    currentState = new LookingUp(grid, gameStatusObserver);
                    currentState.move();
                    currentDirection = "up";
			break;
		case KeyEvent.VK_DOWN:
                    currentState = new LookingDown(grid, gameStatusObserver);
                    currentState.move();
                    currentDirection = "down";
			break;
                case KeyEvent.VK_RIGHT:
                    currentState = new LookingRight(grid, gameStatusObserver);
                    currentState.move();
                    currentDirection = "right";
			break;
                case KeyEvent.VK_LEFT:
                    currentState = new LookingLeft(grid, gameStatusObserver);
                    currentState.move();
                    currentDirection = "left";
			break;
                case KeyEvent.VK_SPACE:
                    if(currentDirection.equals("up"))
                    {
                        currentState = new LookingUp(grid, gameStatusObserver);
                        currentState.shoot();
                    }else if(currentDirection.equals("down"))
                    {
                        currentState = new LookingDown(grid, gameStatusObserver);
                        currentState.shoot();
                    }else if(currentDirection.equals("right"))
                    {
                        currentState = new LookingRight(grid, gameStatusObserver);
                        currentState.shoot();
                    }else {
                        currentState = new LookingLeft(grid, gameStatusObserver);
                        currentState.shoot();
                    }
		}
	}
        
        
	
}
