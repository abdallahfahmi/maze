package View;

import Model.Bomb;
import Model.BrickWall;
import Model.GasBomb;
import Model.Grid;
import Model.Tree;
import java.awt.Graphics;
import javax.swing.JPanel;


public class GamePanel extends JPanel {
    
	public Grid currentgrid;
	
    public GamePanel(){
        currentgrid = new Grid(new BrickWall(), new Bomb(), new Tree(), new GasBomb());
    }
    
    @Override
    public void paintComponent(Graphics g){
    	
    	super.paintComponent(g);
        currentgrid.drawGrid(g);
    }
    
}
