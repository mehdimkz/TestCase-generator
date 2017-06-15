/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testcasegenerator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import javax.sound.sampled.Line;
import javax.swing.JApplet;
import javax.swing.JPanel;

/**
 *
 * @author Mehdi
 */
public class DrawLine2D extends JPanel {
int x,y,x1,y1,j,z,z1,max_y=0;  
int array[][]; // declare array named array
String ProjectName="";
 
  public void init(int c[][],int d,int m,String s) {
      array = new int[ 50 ][4];
      z=d;
      z1=m;// m is numbers of 
      ProjectName=s;
      setBackground(Color.white);
      setForeground(Color.white);
    
for (int i=0;i<z;i++)
   for (int j=0;j<4;j++){
       array[i][j]=c[i][j];
   //    System.out.println(z);
       
     }
  }

  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2));
    g2.setPaint(Color.GREEN);
//System.out.println("n="+Grf.n);
 for (int i=0;i<z-z1;i++)
   {
     
     j=0;
       x=array[i][j];
       y=array[i][j+1];
       x1=array[i][j+2];
       y1=array[i][j+3];
     if (y>max_y)     // find maximum Y
       max_y=y;
    g2.draw(new Line2D.Double(x, y, x1, y1));
   }
   
    
 //   g2.setPaint( Color.GREEN );
//    g2.draw( new Line2D.Double( 395, 30, 320, 150 ) );  
     g2.setPaint( Color.ORANGE );
    g2.drawString("Cause Effect Graph For: ", 150, max_y+90);
    
    g2.setPaint( Color.LIGHT_GRAY );
    g2.drawString(ProjectName,300 , max_y+90);
    //Draw Constrain with dash line
    for (int i=z-z1;i<z;i++)
      {
         j=0;
       x=array[i][j];
       y=array[i][j+1];
       x1=array[i][j+2];
       y1=array[i][j+3];  
        
        
    float dashes[] = { 5 }; 
    g2.setPaint( Color.RED );
    g2.setStroke( new BasicStroke( 4, BasicStroke.CAP_ROUND,
            BasicStroke.JOIN_ROUND, 10, dashes, 0 ) );            
    g2.draw(new Line2D.Double(x, y, x1, y1));    
    g2.setPaint( Color.RED );
    g2.draw(new Line2D.Double(40, max_y+50, 75, max_y+50));// draw dash line for decleration
    g2.setPaint( Color.magenta );
    g2.drawString(":Constrain", 83, max_y+50);
    
    }
    
   
  }
}