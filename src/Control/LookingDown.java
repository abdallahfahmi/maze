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
public class LookingDown extends State{
    
    int oldI = grid.plane.i;
    int oldJ = grid.plane.j;
    
    public LookingDown(Grid grid, StatusObserver gameStatus) {
        super(grid, gameStatus);
    }

    @Override
    public void move() {
        grid.plane.down();
                        if(oldI >= 29)
			{
				return;
			}else if(grid.isBomb(oldI+1, oldJ)) {
                            grid.plane.bombHit();
                            grid.bombCrash(oldI+1, oldJ);
                            gameStatus.gameOverUpdate();
                            return;
			}else if(grid.isWall(oldI+1 , oldJ)){
                            return;
                        }else if(grid.isTree(oldI+1, oldJ)){
                            return;
                        }else if(grid.isGasBomb(oldI+1, oldJ)){
                            grid.plane.gasbombHit();
                            grid.gasBombCrash(oldI+1, oldJ);
                            checkStamina();
                            return;
                        }
                        //System.out.println("moving down...");
                        grid.plane.i = oldI+1;
    }
    
@Override
public void shoot() {
        
    if(gun.shoot())
    {
        Game.updateBullets();
            for(int i=oldI+1; i<=29; i++)
        {
            if(grid.shapesongrid[i][oldJ]==null){
                continue;
            }else if(grid.shapesongrid[i][oldJ] instanceof Tree)
            {
                grid.shapesongrid[i][oldJ] = new SmashedTree();
                break;
            }else break;
                
        }
    }else System.out.print("gun is empty, please reload\n");
}
    
    
}
