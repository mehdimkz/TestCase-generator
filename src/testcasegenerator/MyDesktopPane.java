/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testcasegenerator;

/**
 *  *****************Put Image in Bcakground of Mainframe*********************
 * @author Mehdi
 */
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;


public class MyDesktopPane extends JDesktopPane {

  private Image image;

  public MyDesktopPane(Image image) {
     super();
     this.image = image;
  }

  


  protected void paintComponent(Graphics g)
  {
     super.paintComponent(g);
     
     // the size of the component
     
   
        Dimension d = getSize();
        
        
        // the internal margins of the component
        
        
        Insets i = new Insets(200,350,250,250);
        // draw to fill the entire component
        
   //     g.drawImage(image, i.left, i.top, d.width - i.left - i.right, d.height - i.top - i.bottom, this );
     
      
     
    g.drawImage(image,i.left, i.top,this);
  }

  
  public static void main(String[] args) throws Exception {
      
      File file = new File("C:\\Documents and Settings\\Mehdi\\Desktop\\Logo for testig Tools\\big-logo.png");

     BufferedImage googleLogo = ImageIO.read(file);
     JFrame frame = new JFrame("JDesktopPaneWithBackground");
     MyDesktopPane desktop = new MyDesktopPane(
           googleLogo);
     
      JInternalFrame mboxFrame = new JInternalFrame("Mail Reader", true,
        true, true, true);
    JLabel reader = new JLabel("Mail Reader Would Be Here");
    mboxFrame.setContentPane(reader);
    mboxFrame.setSize(400, 300);
    mboxFrame.setLocation(50, 50);
    mboxFrame.setVisible(true);
    

     
     
  /*   JInternalFrame pane = new JInternalFrame();
     desktop.add(pane);
     pane.setBounds(50, 50, 100, 100);
     pane.setVisible(true);*/
     desktop.setPreferredSize(new Dimension(400, 500));
     frame.setContentPane(desktop);
     
     Container content = frame.getContentPane();
     content.doLayout();
     content.add(mboxFrame);
    
     
  //   frame.setResizable(false);
     Dimension s=desktop.getPreferredSize();
      System.out.println(s.getWidth());  
     frame.pack();
     frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     frame.setVisible(true);
  }
}