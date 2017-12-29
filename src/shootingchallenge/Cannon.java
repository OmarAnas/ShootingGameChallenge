/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shootingchallenge;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Omar Anas
 */
public class Cannon {
    public Point pos = new Point();
    int speed;
    BufferedImage Cannonpic;
    BufferedImage Cannonpic2;
//     JLabel Cannonpic= new JLabel();
//    JLabel Cannonpic2= new JLabel();
    Ball ball= new Ball();
    ArrayList <Ball> Balls = new ArrayList<Ball>();
    Brick brick = new Brick(pos);
    public Cannon() throws IOException
    {
        this.Cannonpic = ImageIO.read(new File("Cannon.png"));
        this.Cannonpic2 = ImageIO.read(new File("Cannon2.png"));
//        Cannonpic.setIcon(new ImageIcon(new ImageIcon("Cannon.png").getImage().getScaledInstance(124, 260, Image.SCALE_DEFAULT)));
//        Cannonpic2.setIcon(new ImageIcon(new ImageIcon("Cannon2.png").getImage().getScaledInstance(124, 260, Image.SCALE_DEFAULT)));
        
     speed=5;
     pos.x=ShootingChallenge.screenSize.width/2;
     pos.y=ShootingChallenge.screenSize.height/2+250; 
     //Cannonpic.setBounds(pos.x, pos.yy, 124, 260);
    }
    
    public void mover()
    {
        pos.x+=speed; 
        if (pos.x>=ShootingChallenge.screenSize.width-150)
            pos.x-=speed;
       
    }
     public void movel()
    {
        pos.x-=speed;
        if (pos.x ==0)
            pos.x+=speed;
    }
   public void edrab () throws IOException
   {
     //    Ball b = new Ball();  
     // Balls.add(b);
          ball.pos.x= this.pos.x+25;
       ball.pos.y= this.pos.y;


       Thread t = new Thread(ball);
       t.start();
     //  Thread t2 = new Thread()
   }
}
