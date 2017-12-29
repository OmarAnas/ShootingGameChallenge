/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shootingchallenge;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Omar Anas
 */
public class Ball implements Runnable 
{
    Point pos = new Point();
    BufferedImage Ballpic;
    BufferedImage Ballpic2;

    int speed;
    public Ball() throws IOException
    {
        this.Ballpic = ImageIO.read(new File("Ball.png"));
                this.Ballpic2 = ImageIO.read(new File("Ball2.png"));

    speed=2;
    }        
    
    void move ()
    {
       pos.y-=speed;
    }

    @Override
    public void run() 
    {
          for (int i=0;i<600;i++)
          {
              move();
              try {
                  Thread.sleep(20);
              } catch (InterruptedException ex) {
                  Logger.getLogger(Ball.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
    
    }
    
    
}
