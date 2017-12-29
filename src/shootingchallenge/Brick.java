/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shootingchallenge;

import java.awt.Color;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Omar Anas
 */
public class Brick implements Runnable
{ //int x ,y;
Color color;
Point pos= new Point();
int speed;
    public Brick(Point pos) 
    {
     this.pos.x=pos.x;
     this.pos.y=pos.y;
//        this.x = x;
//        this.y = y;
      color= Color.BLUE;
        speed=1;
    }
   public void move()
   {
     //  y+=speed;
      pos.y+=speed; 
   }

    @Override
    public void run() {
      for (int i=0 ; i<400 ; i++)
       {
        move();
    try {
       
        Thread.sleep(5);
    } catch (InterruptedException ex) {
        Logger.getLogger(Brick.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    }      
}
