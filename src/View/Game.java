/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.KeyListener;

import Control.StatusObserver;
import Control.MovementObserver;
import Control.KeyController;
import Control.State;
import Model.Plane;

public class Game extends javax.swing.JFrame {

    public KeyController keyboardController; 
    
    public Game() {
    	 
    	initComponents();
    }

    public void setKeyboardController(KeyController k) {
		
    	this.keyboardController = k;
    	this.addKeyListener(keyboardController);
		
	}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new GamePanel();
        stamina = new javax.swing.JLabel();
        bullets = new javax.swing.JLabel();
        score = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setAutoscrolls(true);
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        stamina.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stamina.setText("Stamina: Full");

        bullets.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bullets.setText("Bullets: 6");

        score.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        score.setText("Score:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stamina, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(bullets, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(score, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(stamina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bullets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
         
        	public void run() {
        		
                Game game = new Game();
                game.setVisible(true);
                GamePanel panel = (GamePanel) game.jPanel1;
                KeyController kc = new KeyController(new MovementObserver(panel.currentgrid, new StatusObserver(game)));
                
                game.setKeyboardController(kc);
                
                game.requestFocusInWindow();
               // panel.paintComponent(panel.getGraphics());
                
                Thread thread = new Thread(new Runnable(){
                    
                	public void run(){
                    	
                        while(true){
                           panel.repaint();
                          // panel.paintComponent(panel.getGraphics());
                            try{
                                Thread.sleep(50);
                            }
                            catch(Exception e){
                                
                            }
                        }
                    }
                });
                
                thread.start();
            }
        });
    }
    
    public static void updateBullets(){
        bullets.setText("Bullets: "+State.gun.getBullets());
    }
    
    public static void updateStamina(){
        if(Plane.getStamina()==2)
            stamina.setText("Stamina: Full");
        else if(Plane.getStamina()==1)
            stamina.setText("Stamina: Weak");
        else stamina.setText("Stamina: Dead");
    }
    
    public static void updateScore(){
        score.setText("Score: ");
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel bullets;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JLabel score;
    private static javax.swing.JLabel stamina;
    // End of variables declaration//GEN-END:variables

	public void removeListener() {
		
	
		this.removeKeyListener(keyboardController);
		
	}
}
