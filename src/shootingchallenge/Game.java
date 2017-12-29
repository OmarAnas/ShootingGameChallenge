/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shootingchallenge;

import com.sun.prism.impl.shape.BasicEllipseRep;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import jdk.nashorn.internal.ir.BreakNode;
import jdk.nashorn.internal.ir.BreakableNode;
/**
 *
 * @author Omar Anas
 */
public class Game extends JPanel implements Runnable
{
    ArrayList <Brick> Bricks = new ArrayList<Brick>();
    ArrayList<Cannon> cannons = new ArrayList<Cannon>(2);
    ArrayList<Ball> Balls = new ArrayList<Ball>();
         Cannon cannon= new Cannon();
Cannon cannon2 = new Cannon();
int countp1=0,countp2=0;
 JLabel countlbl1;
 JLabel countlbl2;
 boolean isFinished=false;
            public Game () throws IOException
            {
                setFocusable(true);
                 requestFocusInWindow();
                this.addKeyListener(new Kys());
                cannons.add(cannon);
                cannons.add(cannon2);
                 countlbl1= new JLabel();
                 countlbl2= new JLabel();
                        countlbl1.setText("Player One: "+ String.valueOf(countp1));
                        countlbl1.setForeground(Color.RED);
        countlbl2.setText("Player Two: "+ String.valueOf(countp2));
        countlbl2.setForeground(Color.BLUE);

                add(countlbl1);
                add(countlbl2); 
            }
public void paintComponent (Graphics  g)
{
    g.clearRect(0, 0, ShootingChallenge.screenSize.width, ShootingChallenge.screenSize.height);
    //for (Ball B :Balls)
    {
    g.drawImage(cannon.ball.Ballpic, cannon.ball.pos.x, cannon.ball.pos.y, null);
    g.drawImage(cannon2.ball.Ballpic2, cannon2.ball.pos.x, cannon2.ball.pos.y, null);
        g.clearRect(0, 0, 80, 82);

//    Balls.add(B);
    }
     g.drawImage(cannon.Cannonpic, cannon.pos.x, cannon.pos.y, null);
        g.drawImage(cannon2.Cannonpic2, cannon2.pos.x, cannon2.pos.y, null);
    try {
    for (Brick brick : Bricks)
    {
     g.fillRect(brick.pos.x, brick.pos.y,100, 50);
    if (cannon.ball.pos.distance(brick.pos)<=70)
    {
        Bricks.remove(brick);
        countlbl1.setText("Player One: "+ String.valueOf(countp1++));
    }
    if (cannon2.ball.pos.distance(brick.pos)<=70)
    {
        Bricks.remove(brick);
        countlbl2.setText("Player Two: "+ String.valueOf(countp2++));
    }     
    }
    } catch  
        (java.util.ConcurrentModificationException e) {
    }                

}
            public void check ()
            {        
            if (Bricks.isEmpty()|| cannons.isEmpty())
            {
                
            {  if (countp1 > countp2){
            JOptionPane.showMessageDialog(null, "Winner is Player 1 by score ");
            System.exit(0);
            }
            if (countp1 < countp2){
            JOptionPane.showMessageDialog(null, "Winner is Player 2 by score ");
            System.exit(0);
            }
            if (countp1 == countp2)
            {JOptionPane.showMessageDialog(null, "Draw!");
            System.exit(0);}
            }
            }
            }
            
    @Override
    public void run() 
    {

        try {
 while(true)
{
         for (Brick brick: Bricks)
        {
            brick.move();        
            if (brick.pos.y > ShootingChallenge.screenSize.height-150)
             {
                  JOptionPane.showMessageDialog(null, "Game Over");
                  System.exit(0);
             }
            
            if (cannon.pos.distance(brick.pos) <=50)
          {
        cannons.remove(cannon);
        JOptionPane.showMessageDialog(null, "Winner is Player 2 (Player 1 hit a brick)");
            System.exit(0);
          }
            if (cannon2.pos.distance(brick.pos) <=50)
           {
              cannons.remove(cannon2);
                    JOptionPane.showMessageDialog(null, "Winner is Player 1 (Player 2 hit a brick)");
                    System.exit(0);
            }
        }
         check();
            Thread.sleep(50);
            repaint();
        }
    }
    catch (InterruptedException ex) {Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    private class Kys implements KeyListener {

        public Kys() {
        }

        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyPressed(KeyEvent ke) 
        {        //System.out.println(cannons.size());

         if (ke.getKeyCode() == KeyEvent.VK_CONTROL){
            try {
                cannon.edrab();
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
        { 
              cannon.mover();
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT)
        {
              cannon.movel();
        }
         if (ke.getKeyCode() == KeyEvent.VK_SPACE)
        {            
            for (int i=0; i <3;i++)
            {    try {
                cannon2.edrab();
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }}
        }     
         
        if (ke.getKeyCode() == KeyEvent.VK_D)
        { 
              cannon2.mover();
        }
        if (ke.getKeyCode() == KeyEvent.VK_A)
        {
              cannon2.movel();
        }
         }

        @Override
        public void keyReleased(KeyEvent ke) {
        }
    }
}
