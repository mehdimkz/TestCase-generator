/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testcasegenerator;

import java.io.IOException;
import java.util.Hashtable;

/**
 *
 * @author Mehdi
 */
public class CTestCase {
private Stack theStack;
private EHASH theHash;
private String input;

private String output = "";
String s="";
int m=1,n=0,aInt;
String z,z1;
protected String TestCases_T="";
protected String TestCases_F="";


  public String array[][];
  public CTestCase(String in) {
    input = in;
    int stackSize = input.length();
    theStack = new Stack(stackSize);
    theHash=new EHASH();

  }

  public void doTrans() {
    int i=0;
    for (int j = 0; j < input.length(); j++) {
     char ch = input.charAt(j);

      if (ch!='+' && ch!='*'){
          s="";
          s=s+ch;
          theStack.push(s);
          theHash.add(s, j,"T","F");
          s="";
         }//end if
     
       else{
              s="";
              z=theStack.pop(); 
              z1=theStack.pop(); 
              z=theHash.find(z); 
              z1=theHash.find(z1); 
              aInt = Integer.parseInt(z); 
              s=s+m;
              theStack.push(s);
              m++;
              int aInt1 = Integer.parseInt(z1); 
              if (ch=='*'){ //For //N1.N2
                array[j][0]="";
                array[j][1]="";
                array[j][0]=Dekarti(array[aInt1][0],array[aInt][0]);
                array[j][1]=Dekarti(array[aInt1][1],array[aInt][0])+","+Dekarti(array[aInt1][0],array[aInt][1]);
                theHash.add(s, j,array[j][0],array[j][1]);
                
                
                           }//end if
              else
                 {  //For N1+N2
                
                array[j][0]="";
                array[j][1]="";
                array[j][1]=Dekarti(array[aInt1][1],array[aInt][1]);
                array[j][0]=Dekarti(array[aInt1][0],array[aInt][1])+","+Dekarti(array[aInt1][1],array[aInt][0]);
                theHash.add(s, j,array[j][0],array[j][1]);
                }//end else
                         
       }//end else
     System.out.println(array[j][0]+","+array[j][1]);
     i=j;
    } //end for
    System.out.println(array[i][0]);
    TestCases_T=array[i][0];
    TestCases_F=array[i][1];
  }   //end of method        
 private static void quit()
  {
    System.exit(0) ;
  }

 
 public String Dekarti(String s,String s1)
        
 {
 String a1="";
 String a2="";
 String f="";
 String camma="";
 int i=0;
 int j=0;
 do{
 for (;i<s.length();i++)
   
    if (s.charAt(i)!=',')
           a1=a1+s.charAt(i);
    else 
    {   
      camma=camma+s.charAt(i);       
      break;  }
 
      for ( j=0;j<s1.length();j++)
        {                       
       if (s1.charAt(j)!=',')
                     
           a2=a2+s1.charAt(j);
          else 
            {
             f=f+a1+a2+s1.charAt(j);
             a2=""; 
            } //end else
        }//end of second for    
                f=f+a1+a2+camma;
                a2="";
                a1="";
                camma="";
                
       
   
 i++;
 }while(i<s.length());           
             
        
   return f;


 }// end of Dekarti method

 
  public static void main(String[] args) throws IOException {
    String input = "ab+cd+e*+";
    String output;
    CTestCase t = new CTestCase(input);
     t.doTrans(); 
    
  
 
    
  }
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
      array = new String[100][2];
   
    }
  
    public void add(String s, int i,String x,String y) {
        
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
