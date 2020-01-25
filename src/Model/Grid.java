/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Game;
import java.awt.Graphics;


public class Grid {
    
    public Sprite [][] shapesongrid;
    public BrickWall wall;
    public Tree tree;
    public Bomb bomb;
    public GasBomb gasbomb;
    int dimensions;
    public Plane plane;

    public Grid(BrickWall wall, Bomb bomb, Tree tree, GasBomb gasbomb) {
        this.wall  = wall;
        this.tree = tree;
        this.bomb = bomb;
        this.gasbomb = gasbomb;
        dimensions = 30;
        shapesongrid = new Sprite[dimensions][dimensions];
        
        
        for(int i = 0; i < dimensions;i++){
            for(int j =0;j < dimensions;j++){
                double randomnumber = Math.random();
                //System.out.println("random number" + randomnumber);
                if(randomnumber>0.7)
                    {
                        if(randomnumber>0.85)
                            shapesongrid[i][j]= tree;
                        else shapesongrid[i][j]= wall;
                    }
                else if(randomnumber < 0.1)
                {
                    if(randomnumber>0.05)
                        shapesongrid[i][j]= gasbomb;
                    else shapesongrid[i][j] = bomb;
                }
            }
        }
        int i = dimensions-1;
        for (int j = 0; j < dimensions; j++) {
            if(shapesongrid[i][j]== null){
                plane = new Plane(i,j);
             break;
            }
        }
       
    }
     public void drawGrid(Graphics g){
            for(int i = 0; i<dimensions;i++){
            for(int j =0;j<dimensions;j++){
              if(shapesongrid[i][j]!= null){
                  g.drawImage(shapesongrid[i][j].image,j*600/dimensions , i*600/dimensions,600/30,600/30, null);
              }
                }
            }
            int i = plane.i;
            int j = plane.j;
             g.drawImage(plane.image,j*600/dimensions , i*600/dimensions,600/30,600/30, null);
        }

     public Boolean isBomb(int i, int j)
     {
    	 return shapesongrid[i][j] instanceof Bomb;
     }
     
     public Boolean isWall(int i, int j)
     {
         return shapesongrid[i][j] instanceof BrickWall;
     }
     
     public Boolean isTree(int i, int j)
     {
         return shapesongrid[i][j] instanceof Tree;
     }
     
     public Boolean isGasBomb(int i, int j)
     {
         return shapesongrid[i][j] instanceof GasBomb;
     }
     
     public void bombCrash(int i, int j)
     {
        shapesongrid[i][j] = new Explode("src/Model/Images/bomb_explode.png");
        Game.updateStamina();
     }
     
     public void gasBombCrash(int i, int j)
     {
        shapesongrid[i][j] = new Explode("src/Model/Images/gasbomb_explode.png"); 
        Game.updateStamina();
     }
    
}
