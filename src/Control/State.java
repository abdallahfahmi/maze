
package Control;

import Model.Grid;
import Model.Gun;

/**
 *
 * @author abdal
 */
public abstract class State {
    
    public Grid grid;
    public StatusObserver gameStatus;
    public static Gun gun = new Gun();

    public State(Grid grid, StatusObserver gameStatus) {
        this.grid = grid;
        this.gameStatus = gameStatus;
    }
    
    public void move(){
    
    }
        
    public void shoot(){
        
    }
    
    public void checkStamina(){
            if(grid.plane.getStamina()==0)
                gameStatus.gameOverUpdate();
        }
}
