/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testcasegenerator;

/**
 *
 * @author MEHDIMZ
 */
public class LinesArray {

 protected  int Line[][] ;

public LinesArray(int a,int b){
   Line = new int[a][b];
  //  Line[0]=0;
}
public void setes(int i,int x, int y,int x1,int y1){
   int j=0; 
    
   Line[i][j]=x;
   Line[i][j+1]=y;
   Line[i][j+2]=x1;
   Line[i][j+3]=y1;
}
/*public static void main(String[] args) {
     mehdi m=new mehdi(50,4);
     m.setes(0,20,10,50,90);
    System.out.printf( "%8d\n",m.Line.length  );
    for ( int counter = 0; counter <4; counter++ ) {
        
           int h=0;    
           System.out.printf( "%5d%8d\n", counter, m.Line[ 0 ][counter] );*/

  
   }



