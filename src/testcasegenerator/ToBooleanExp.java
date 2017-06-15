/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testcasegenerator;

/**
 *
 * @author Mehdi
 */


import java.io.*;
import java.util.Hashtable;
import java.util.Stack;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

class ToBooleanExp 
{
  
                  protected int tokenCount,j=0,n=0;
                  protected Hashtable CauseTable = new Hashtable();
                  protected String BooleanExp="";
                  protected String Effect="";
                  protected String [] variables; 
                  String strLine,s,s1 = "",s2="",ss="";
                  Stack stack = new Stack();
   public    ToBooleanExp() 
   {
      variables = new String []{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"}; //define variables a,b,c
                   
   }      
    // Open the file that is the first 
   
   public void convertToBooleanExp(String file) throws FileNotFoundException, IOException
   {         
    FileInputStream fstream = new FileInputStream(file);
    // Get the object of DataInputStream
    DataInputStream in = new DataInputStream(fstream);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));



         Effect = br.readLine(); // recognize Effect from first line of specification file

         StringTokenizer st1=new StringTokenizer(Effect);
        tokenCount= st1.countTokens();
          s=st1.nextToken();
          System.out.println (s);
          //custom title, error icon
     if (s.equals("If")||s.equals("AND")){
    JOptionPane.showMessageDialog(null,
    "The defined effect in specification file is incorrect please check your input file",
    "Error",
    JOptionPane.ERROR_MESSAGE);}


         
         
    //Read File Line By Line for create cause table and cerate boolean expression
    
    while ((strLine = br.readLine()) != null)   {
      // Print the content on the console
        System.out.println (strLine);
        StringTokenizer st=new StringTokenizer(strLine);
        
        
        // check for incorrect input file
        StringTokenizer st2=new StringTokenizer(strLine);// make copy
        s=st2.nextToken();


       

        if (!s.equals("If")){
           JOptionPane.showMessageDialog(null,
           "The  specification file is incorrect please check your input file",
           "Error",
           JOptionPane.ERROR_MESSAGE);}


        while (st2.hasMoreTokens()) {

           s=st2.nextToken();

           if (s.equals("AND")||s.equals("OR")){
               n=n+1;
               s=st2.nextToken();
               if (s.equals(".")|| s.equals(")"))
                  JOptionPane.showMessageDialog(null,
                        "The  specification file is incorrect please check your input file",
                        "Error",
                         JOptionPane.ERROR_MESSAGE);

                          }//end main if

            if (s.equals("("))  // check for number of paranthesis
           stack.push("(");
        if (s.equals(")"))
            stack.pop();


        }//end while
         if (!stack.empty())
                  JOptionPane.showMessageDialog(null,
                        "The  specification file is incorrect please check your input file",
                        "Error",
                         JOptionPane.ERROR_MESSAGE);
        //finish

        tokenCount= st.countTokens();
        System.out.println("Number of tokens = " + tokenCount);
        if ((BooleanExp!=""))
            BooleanExp=BooleanExp+"+";
        
          while (st.hasMoreTokens()) 
              
           //extract tokens from each line and create cause table by hashtable    
             {
                s=st.nextToken();
                 System.out.println (s);
                 s = s.toUpperCase();



                 
                 // set paranthesis for boolean exp
                 if (s.equals("("))
                 BooleanExp= BooleanExp+"(";
                 
                 if (s.equals(")"))
                 BooleanExp= BooleanExp+variables[j]+")"; 
          
                 if (s.equals("OR")||s.equals("AND")){
                   
                     
                     
                     if (s.equals("OR")) //cerate boolean expression
                         
                          if (ss.equals(")"))
                                                    
                             BooleanExp= BooleanExp+"+"; 
                          else
                             BooleanExp= BooleanExp+variables[j]+"+";     
                     
                     else   
                         
                          if (ss.equals(")")) 
                         
                             BooleanExp= BooleanExp+"*";  
                          else
                             BooleanExp= BooleanExp+variables[j]+"*";  
                     
                     
                     
                   s1 = s1.replaceAll("If", "");
                   s1 = s1.replace( '.', ' ' );
                   s1 = s1.replace( '(', ' ' );
                   s1 = s1.replace( ')', ' ' );
                   CauseTable.put(variables[j++], s1);
                   s1="";           
                                                   }//end if
                 
                 
                 
                 
                  else
                      {
                     s1=s1+" "+s;
                      }// end else
              
               ss=s; // save previous token in ss
                  
               }//end of  tokenizing while
        
        
         if (!ss.equals(")")) 
             BooleanExp= BooleanExp+variables[j]; 
             
             
             
                s1 = s1.replaceAll("If", "");
                s2 = s1.replace( '.', ' ' );
                s2 = s2.replace( '(', ' ' );
                s2 = s2.replace( ')', ' ' );


               CauseTable.put(variables[j++], s2);
               s1="";
               s="";
                
       }//end of reading line by line while
    
     if ((n<1) )    // check wether the input file has OR / AND
      JOptionPane.showMessageDialog(null,
      "The  specification file is incorrect please check your input file",
      "Error",
      JOptionPane.ERROR_MESSAGE);

      System.out.println (BooleanExp);
      
      
   }//end of method
   
  public int findVariablePosition(String ss)
      {
     int m=0;
     for (int i=0;i<variables.length;i++)    
       if(variables[i].equals(ss))
           m=i;
     return m;  
   }
}//end of class
