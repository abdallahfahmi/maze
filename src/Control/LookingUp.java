/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Bullet;
import Model.Grid;
import Model.SmashedTree;
import Model.Tree;
import View.Game;

/**
 *
 * @author abdal
 */
public class LookingUp extends State{
    
    int oldI = grid.plane.i;
    int oldJ = grid.plane.j;

    public LookingUp(Grid grid, StatusObserver gameStatus) {
        super(grid, gameStatus);
    }
    
    @Override
    public void move(){
        
        grid.plane.up();
        
        if(oldI <= 0)
            {
		return;
            }else if(grid.isBomb(oldI-1, oldJ)) {
                grid.plane.bombHit();
                grid.bombCrash(oldI-1, oldJ);
                gameStatus.gameOverUpdate();
                return;
            }else if(grid.isWall(oldI-1 , oldJ)){
                return;
            }else if(grid.isTree(oldI-1, oldJ)){
                return;
            }else if(grid.isGasBomb(oldI-1, oldJ)){
                    grid.plane.gasbombHit();
                    grid.gasBombCrash(oldI-1, oldJ);
                    checkStamina();
                    return;
            }
            //System.out.println("moving up...");
            grid.plane.i = oldI-1;
    }

@Override
public void shoot() {
    if(gun.shoot())
    {
        Game.updateBullets();
            for(int i=oldI-1; i>=0; i--)
        {
            if(grid.shapesongrid[i][oldJ]==null){
                continue;
            }else if(grid.shapesongrid[i][oldJ] instanceof Tree)
            {
                /*for(int j=oldI-1; j>i; j--)
                {
                    grid.shapesongrid[j][oldJ] = new Bullet();
                    for(int k=0; k<100000000; k++);
                    grid.shapesongrid[j][oldJ] = null;
                }*/
                grid.shapesongrid[i][oldJ] = new SmashedTree();
                break;
            }else break;
                
        }
    }else System.out.print("gun is empty, please reload\n");
        
}
    
    
    
}
