/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public abstract class Sprite {
    
    BufferedImage image;
    int elementDimensions;
    public Sprite(String filename){
        try{
            image = ImageIO.read(new File(filename));
            elementDimensions = 1;
        }
        catch(Exception e){
            System.out.println("Image not found");
        }
    }
    
    public void changeImage(String filename){
        try{
            image = ImageIO.read(new File(filename));
        }
        catch(Exception e){
            System.out.println("Image not found");
        }
    }
    
}
