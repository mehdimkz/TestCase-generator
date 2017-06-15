/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testcasegenerator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mehdi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
   public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppInterface mainFrame = new AppInterface();
                    mainFrame.setBounds(200, 35, 1020, 780);
                    
                    File file = new File("C:\\Documents and Settings\\Mehdi Malekzadeh\\Java projects\\TestCaseGenerator\\Logo for testig Tools\\logo.gif");
                    BufferedImage googleLogo = ImageIO.read(file);
                    //     JFrame frame = new JFrame("JDesktopPaneWithBackground");
                    MyDesktopPane desktop = new MyDesktopPane(googleLogo);
                    mainFrame.setContentPane(desktop);
           

                    mainFrame.setVisible(true);

                    mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
  



     
                
            }
        });
    }
}
