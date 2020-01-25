/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author abdal
 */
public class Gun {
    
    int bullets=6;
    
    public boolean shoot(){
        if(bullets>0){
            bullets--;
            return true;
        }
        return false;
    }
    
    public void reload(){
        bullets = 6;
    }

    public int getBullets() {
        return bullets;
    }
    
    
}
