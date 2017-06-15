/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testcasegenerator;
import java.io.IOException;
// We are using AWT so we need to say so.
import java.awt.* ;

// Also using events.
import java.awt.event.* ;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author Mehdi
 */

public class DrawGraph {

 private Stack theStack;
 private EHASH theHash;
  private String input;
  protected CTField f;
  private String output = "";
  String s="";
  int m=1,n=0,aInt;
  int y=20;
  char a='0';
  int x=30;
  String z,z1,ProjectName;
  int k=0,k1=0;
  int x1=0,y1=0;
  public int array[][];
 
  String Operators[];
    private String key;
  protected String constrain[][];
  int ncons1;
  public DrawGraph(String in,String cons[][],int ncons,String Prjname) {
    input = in;
    int stackSize = input.length();
    theStack = new Stack(stackSize);
    theHash=new EHASH();
    constrain = new String[ 7 ][2];
    ncons1=ncons;
    ProjectName=Prjname;
    for (int i=0;i<ncons;i++)  //copy constraints in local array
      {
       constrain[i][0]=cons[i][0];
       constrain[i][1]=cons[i][1];}
   //    System.out.println(z);
       


  }

  public void doTrans() {
    n=0;  
    CTField f = new CTField("Cause Effect Graph"); 
    Operators = new String[20];
    LinesArray DLine=new LinesArray(50,4);
    
    for (int j = 0; j < input.length(); j++) {
     char ch = input.charAt(j);

      if (ch!='+' && ch!='*'){
          s=s+ch;
          theStack.push(s);
  
          theHash.add(s, j, 30, y);
          s="";
          y=y+58;}//end if
     
       else{
              
        z=theStack.pop(); 
        z1=theStack.pop(); 
        
    try {//main try
          int a_aInt=Integer.parseInt(z);
          int a_aInt1 = Integer.parseInt(z1); 
           aInt = Integer.parseInt(z);
           int aInt1 = Integer.parseInt(z1);
           z=theHash.find(z); 
           aInt = Integer.parseInt(z);
           z1=theHash.find(z1); 
           aInt1 = Integer.parseInt(z1);
           s="";
           s=s+ch;
           if (s.equals(Operators[a_aInt]))
              
             {
               ///////////////////////////////////////Move Text_Filed toward
               s="";
               s=s+a_aInt;  
               theStack.push(s);
               s="";
               s=s+a_aInt;
               z=theHash.find(s); 
               int new1 = Integer.parseInt(z);
               s="";
               s=s+a_aInt1;
               z=theHash.find(s); 
               int new2 = Integer.parseInt(z);
               if ((array[new1][0])>(array[new2][0]))
                                  x1=(array[new1][0])+28+25;
                               else
                                  x1=(array[new2][0])+28+25; 
                 
               
               
               y1=((array[new1][1])+(array[new2][1]))/2;
               
               for (k=0;k<=j;k++)  // change position of line
                   if (DLine.Line[k][2]==array[new1][0] && DLine.Line[k][3]==(array[new1][1]+9))
                   {  DLine.Line[k][2]=x1;
                      DLine.Line[k][3]=y1+9;}
                
                   
               
               array[new1][0]=x1;
               array[new1][1]=y1;
               ///////////////////////////////////////////
               DLine.setes(n++,array[aInt1][0]+28,array[aInt1][1]+9,array[aInt][0],array[aInt][1]+9); 
               s=""; 
               
              } //end if
           else
           {
             if (s.equals(Operators[a_aInt1])) {
               s="";
               s=s+a_aInt1;  
               theStack.push(s);
               z=theHash.find(s); 
               int new1 = Integer.parseInt(z);
               s="";
               s=s+a_aInt;
               z=theHash.find(s); 
               int new2 = Integer.parseInt(z);
               if ((array[new1][0])>(array[new2][0]))
                                  x1=(array[new1][0])+28+25;
                               else
                                  x1=(array[new2][0])+28+25; 
                 
               
               
               y1=((array[new1][1])+(array[new2][1]))/2;
               
                 for (k=0;k<=j;k++)  // change position of line
                   if (DLine.Line[k][2]==array[new1][0] && DLine.Line[k][3]==(array[new1][1]+9))
                   {  DLine.Line[k][2]=x1;
                      DLine.Line[k][3]=y1+9;}
                
                   
               array[new1][0]=x1;
               array[new1][1]=y1;
               DLine.setes(n++,array[aInt][0]+28,array[aInt][1]+9,array[aInt1][0],array[aInt1][1]+9); 
               s="";
              }   //end of current if
             else {
                 
                  
         
               
    
                       
                              if ((array[aInt1][0])>(array[aInt][0]))
                                 x1=(array[aInt1][0])+28+25;
                              else
                                 x1=(array[aInt][0])+28+25; 
                                     
                       
                
                       s="";
                       s=s+m;  
                       theHash.add(s, j, x1,(array[aInt][1]+array[aInt1][1])/2);  
                       theStack.push(s);
                       s="";
                       s=s+ch;
                       Operators[m]=s;
                       DLine.setes(n++,array[aInt][0]+28,array[aInt][1]+9,x1,(array[aInt][1]+array[aInt1][1])/2+9); 
                      
                      System.out.println( aInt );
                      System.out.println( theStack.isEmpty() ); 
                      
                      DLine.setes(n++,array[aInt1][0]+28,array[aInt1][1]+9,x1,(array[aInt][1]+array[aInt1][1])/2+9);
                     
                       s="";
                       m++;
                 
                 
                
                 
                   }  //end of current else
             
             
             }//end   else
           } //end of try
       
       
       
       catch(NumberFormatException nFE){
       
           
         try{ //second try
              
          int a_aInt1 = Integer.parseInt(z1);     
          z=theHash.find(z); 
          aInt = Integer.parseInt(z); 
          s="";
          s=s+ch;
          if (s.equals(Operators[a_aInt1]))
              
               {  
               z1=theHash.find(z1); 
               int aInt1 = Integer.parseInt(z1);
               s="";
               s=s+a_aInt1;  
               
               theStack.push(s);
               s="";
               s=s+ch;
               Operators[m]=s;
               DLine.setes(n++,array[aInt][0]+28,array[aInt][1]+9,array[aInt1][0],array[aInt1][1]+9); 
               s="";              
                 
               }//end if  
           else
                { 
                  
                z1=theHash.find(z1); 
                int aInt1 = Integer.parseInt(z1);
               
                    if ((array[aInt1][0])>(array[aInt][0]))
                                  x1=(array[aInt1][0])+28+25;
                               else
                                  x1=(array[aInt][0])+28+25; 
            
               s="";
               s=s+ch;
               Operators[m]=s;
               s="";
               s=s+m;  
               theHash.add(s, j, x1,(array[aInt][1]+array[aInt1][1])/2);  
               theStack.push(s);
               s="";
               DLine.setes(n++,array[aInt][0]+28,array[aInt][1]+9,x1,(array[aInt][1]+array[aInt1][1])/2+9); 
             
               DLine.setes(n++,array[aInt1][0]+28,array[aInt1][1]+9,x1,(array[aInt][1]+array[aInt1][1])/2+9);
              
               s="";
               m++; 
                        
                }//end else
            }//end second try
           
           catch(NumberFormatException nFE1){     
     
        z=theHash.find(z); 
        aInt = Integer.parseInt(z); 
        z1=theHash.find(z1); 
        int aInt1 = Integer.parseInt(z1);
         
               
    
                       
                              if ((array[aInt1][0])>(array[aInt][0]))
                                 x1=(array[aInt1][0])+28+25;
                              else
                                 x1=(array[aInt][0])+28+25; 
                                     
                       
                
                       s="";
                       s=s+m;  
                       theHash.add(s, j, x1,(array[aInt][1]+array[aInt1][1])/2);  
                       theStack.push(s);
                       s="";
                       s=s+ch;
                       Operators[m]=s;
                       DLine.setes(n++,array[aInt][0]+28,array[aInt][1]+9,x1,(array[aInt][1]+array[aInt1][1])/2+9); 
                      
                      System.out.println( aInt );
                      System.out.println( theStack.isEmpty() ); 
                      
                      DLine.setes(n++,array[aInt1][0]+28,array[aInt1][1]+9,x1,(array[aInt][1]+array[aInt1][1])/2+9);
                     
                       s="";
                       m++;
                      }
                      //end of recent if          
             
        
           }
         }//end main else */
     
    } //for
 
Enumeration keys = theHash.h.keys();
while ( keys.hasMoreElements() )
   {
   key = (String)keys.nextElement();
   String n1 = (String)theHash.h.get( key );
 //  String ss=theHash.find(key); 
   int aInt_array = Integer.parseInt(n1); 
   try{
     
       aInt = Integer.parseInt(key);
       int xx=array[aInt_array][0];
       int yy=array[aInt_array][1];
       s=Operators[aInt]+"N"+key;
       f.CTField(xx,yy,28,18,s);
       s="";
   }
   catch(NumberFormatException nFE){
       
       int xx=array[aInt_array][0];
       int yy=array[aInt_array][1];
       f.CTField(xx,yy,28,18,key);
   }
   

   } 
    
   Enumeration keys1 = theHash.h.keys();
while ( keys1.hasMoreElements() )
   {
   key = (String)keys1.nextElement();
   String n1 = (String)theHash.h.get( key );
   System.out.println( key + " " + n1 );
   }
   
   
   // Draw Constrain for graph
    for (int j=0;j<ncons1;j++)
                          
                        {
                         z=theHash.find(constrain[j][0]); 
                         aInt = Integer.parseInt(z);
                         z1=theHash.find(constrain[j][1]); 
                         int aInt1 = Integer.parseInt(z1);
                         DLine.setes(n++,(array[aInt][0]+14),array[aInt][1]+9,(array[aInt1][0]+14),(array[aInt1][1]));
                         System.out.println(constrain[j][0]+","+constrain[j][1]+"\n");
                         System.out.println(z+","+z1+"\n");
                         k1=j+1;  //k1 is number of constraint
                        } 

   
   
   
    DrawLine2D applet = new DrawLine2D(); 
    applet.init(DLine.Line,n,k1,ProjectName);
    f.getContentPane().add("Center", applet);
    f.add(applet);   
  
    f.pack();
    f.setBounds(203, 90, 800, 700);

    f.show();
    f.saveFile();
    
    
}   
 private static void quit()
  {
    System.exit(0) ;
  }


/*  public static void main(String[] args) throws IOException {
    String input = "ab+c+de*+fg+h*+";
    
    String output;
    DrawGraph t = new DrawGraph(input);
     t.doTrans(); 
    
  
 
    
  }*/
  class Stack {
    private int maxSize;
  
    private String[] stackArray;
  
    private int top;
  
    public Stack(int max) {
      maxSize = max;
      stackArray = new String[maxSize];
      top = -1;
    }
  
    public void push(String j) {
      stackArray[++top] = j;
    }
 
    public String pop() {
      return stackArray[top--];
    }
  
    public String peek() {
      return stackArray[top];
    }
  
    public boolean isEmpty() {
      return (top == -1);
    }
  }
class EHASH{
   // create a new Hashtable    
Hashtable h = new Hashtable( 149 /* capacity */, 0.75f /* loadfactor */ );


  public EHASH() {
      array = new int[100][2];
   
    }
  
    public void add(String s, int i,int x,int y) {
        
        // add some key/value pairs to the Hashtable
       
       array[i][0]=x;
       array[i][1]=y;
       String f="";
       f=f+i;
       h.put( s , f );


    }

   public String find(String s){
// look up a key in the Hashtable
String key = s;
String pos = (String)h.get( key );
//System.out.println( pos );
//System.out.println( h.get( key ) );
return pos;

// enumerate all the contents of the hashtable
/*Enumeration keys = h.keys();
while ( keys.hasMoreElements() )
   {
   key = (String)keys.nextElement();
   stateName = (String)h.get( key );
   System.out.println( key + " " + stateName );*/
   // prints lines of the form NY New York
   // in effectively random order.
   } // end while
}


}
