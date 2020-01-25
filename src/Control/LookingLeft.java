/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.State.gun;
import Model.Grid;
import Model.SmashedTree;
import Model.Tree;
import View.Game;

/**
 *
 * @author abdal
 */
public class LookingLeft extends State{
    
    int oldI = grid.plane.i;
    int oldJ = grid.plane.j;

    public LookingLeft(Grid grid, StatusObserver gameStatus) {
        super(grid, gameStatus);
    }

    @Override
    public void move() {
        grid.plane.left();
                        if(oldJ <= 0)
			{
				return;
			}else if(grid.isBomb(oldI, oldJ-1)) {
                            grid.plane.bombHit();
                            grid.bombCrash(oldI, oldJ-1);
                            gameStatus.gameOverUpdate();
                            return;
			}else if(grid.isWall(oldI , oldJ-1)){
                            return;
                        }else if(grid.isTree(oldI, oldJ-1)){
                            return;
                        }else if(grid.isGasBomb(oldI, oldJ-1)){
                            grid.plane.gasbombHit();
                            grid.gasBombCrash(oldI, oldJ-1);
                            checkStamina();
                            return;
                        }
                        //System.out.println("moving left...");
                        grid.plane.j = oldJ-1;
    }
    
@Override
public void shoot() {
        
    if(gun.shoot())
    {
        Game.updateBullets();
        for(int j=oldJ-1; j>=0; j--)
        {
            if(grid.shapesongrid[oldI][j]==null){
                continue;
            }else if(grid.shapesongrid[oldI][j] instanceof Tree)
            {
                grid.shapesongrid[oldI][j] = new SmashedTree();
                break;
            }else break;
                
        }
    }else System.out.print("gun is empty, please reload\n");
}
    
}
