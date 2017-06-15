/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testcasegenerator;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.*;
/**
 *
 * @author Mehdi
 */
public class CTField extends JFrame {
JTextField input_text,input_text1;
    private static final String FILE_NAME = "layeredPane.jpg"; //save graph as image file
   boolean f=false;
   private javax.swing.JTextField jTextField1;
   CTField(String name) {
    super(name);
    setBackground(Color.BLACK);
 
   
   }
   public  void CTField (int x1,int y1,int width1,int high1,String c1){
   input_text1 = new JTextField(c1,0);
   
    input_text1.setBackground(Color.YELLOW);
   input_text1.setBounds(x1, y1, width1, high1); 
   input_text1.setEditable(f);
   input_text1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
   input_text1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
   input_text1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
   
    
   
   
   
   
   add(input_text1);
   
   }
   public void mehdi(int m){
    m=m+1;   
   }
 public void saveFile() {
        File file = new File(FILE_NAME);
	    if (file.exists()) {
	        file.delete();
	    }
        JLayeredPane comp = getLayeredPane();
        Container contain=getContentPane();
        int w = contain.getWidth();
        int h = contain.getHeight();
	    BufferedImage image = (BufferedImage)comp.createImage(w, h);
	    Graphics g = image.getGraphics();
	    if (g.getClipBounds()!=null) {
	        g.setClip(0, 0, w, h);
	    }
	    contain.paint(g);
	    try {
		    FileOutputStream out = new FileOutputStream(file);
		    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		    encoder.encode(image);
		    out.flush();
		    out.close();
	    } catch (IOException ioe) {
	        /* handle exception */
	    } catch(RasterFormatException rfe) {
	        /* handle exception */
	    }
    }  


}
