/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Game;

/**
 *
 * @author mabady
 */
public class Plane extends Sprite {
    public int i,j;
    private static int stamina = 2;
    
    public Plane(int i , int j) {
        super("src/Model/Images/plane right.png");
        this.i = i;
        this.j = j;
    }
    
    public void right(){
        super.changeImage("src/Model/Images/plane right.png");
    }
    
    public void left(){
        super.changeImage("src/Model/Images/plane left.png");
    }
    
    public void up(){
        super.changeImage("src/Model/Images/plane up.png");
    }
    
    public void down(){
        super.changeImage("src/Model/Images/plane down.png");
    }

    public static int getStamina() {
        return stamina;
    }

    public void gasbombHit(){
        stamina--;
    }
    
    public void bombHit(){
        stamina -= 2;
    }
    
    
}
