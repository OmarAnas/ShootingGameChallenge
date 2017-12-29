/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shootingchallenge;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Omar Anas
 */
public class ShootingChallenge {
static Game g;
      static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static void main(String[] args) throws IOException {
     
       JFrame f = new JFrame();
       g= new Game();
       bricks();
      
       f.setSize(screenSize.width,screenSize.height);
       f.setDefaultCloseOperation(EXIT_ON_CLOSE);

       
       
       f.add(g);
       
       Thread t=new Thread(g);
       t.start();
       f.setVisible(true);
       g.check();
    }
    public static void bricks ()
    { 
    Point pos=  new Point();
    pos.x=80;
    pos.y=30;


    for ( int i=0; i<15 ; i++)
    {  
    for ( int j=0;j<4;j++)
    { 
        g.Bricks.add(new Brick (pos));
        pos.y+=120;
    }
         pos.x+=120;
         pos.y=30;
   }
    }
    }

