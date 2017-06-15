/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testcasegenerator;

import java.util.Hashtable;
import java.io.*;

/**
 *
 * @author MehdiMz
 */
public class fileContainer {
    
    String filename;
    String filePath;
    int executableLinesOfCode;
    int declerationLinesOfCode;
    int commentsLinesOfCode;
    Hashtable<Integer, Object[]> fileLines;
    
    
    public fileContainer(String filePath){
        this.filePath = filePath;
        this.fileLines = new Hashtable<Integer, Object[]>();
        this.loadTableFileLines();
//        this.testTableLines();
    }
          
    private void loadTableFileLines(){
        String line;
        int lineIndex = 1;
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(this.filePath));
            while(( line = br.readLine()) != null){
               int type = determineTypeOfLine(line);
               Object[] linesAndType = new Object[2];
               linesAndType[0] = line;
               linesAndType[1] = type;
               this.fileLines.put(lineIndex, linesAndType);
               lineIndex++;
            }
            br.close();

        }catch(IOException e){
            System.out.println(e.toString());
        }
    }
    
    private int determineTypeOfLine(String aLine){
        int result = -1;
        
        aLine = aLine.trim();
        int lineLength = aLine.length();
        
        if(lineLength==0){
//            System.out.println("Blank Line!");
            result = 0;
        }
        else if(aLine.startsWith("//")|
                aLine.startsWith("/*")|
                aLine.startsWith("*")){
//            System.out.println("Comment Line: " + aLine);
            this.commentsLinesOfCode++;
            result = 3;
        }
        
        else if(aLine.contains("+")|
                aLine.contains(".")|
                aLine.contains("-")|
                aLine.contains("*")|
                (aLine.contains("/") && !aLine.contains("//"))|
                aLine.contains("%")|
                aLine.contains(">=")|
                aLine.contains("=")|
                aLine.contains("<=")|
                (aLine.contains(">") && !aLine.contains("Hashtable") && !aLine.contains("HashSet") && !aLine.contains("Array") && !aLine.contains("Abstract"))|
                (aLine.contains("<") && !aLine.contains("Hashtable") && !aLine.contains("HashSet") && !aLine.contains("Array") && !aLine.contains("Abstract"))|
                aLine.contains("&")|
                aLine.contains("|")|
                aLine.contains("while")|
                aLine.contains("for")|
                aLine.contains("if")|
                aLine.contains("super")|
                aLine.contains("return")|
                aLine.contains("catch")|
                aLine.contains("break")|
                aLine.contains("continue")|
                aLine.contains("goto")|
                aLine.contains("else if")                
                ){
//           System.out.println("R1 , Executable Line: " + aLine); 
           this.executableLinesOfCode++;
           result = 1;
        }
        
        else if(aLine.startsWith("int ")|
                aLine.startsWith("double ")|
                aLine.startsWith("float ")|
                aLine.startsWith("public ")|
                aLine.startsWith("private ")|
                aLine.startsWith("protected ")|
                aLine.startsWith("abstract ")|
                aLine.startsWith("char ")|
                aLine.startsWith("String ")|
                aLine.startsWith("byte ")|
                aLine.startsWith("case ")|
                aLine.startsWith("else ")|
                aLine.startsWith("const ")|
                aLine.startsWith("default ")|
                aLine.startsWith("do ")|
                aLine.startsWith("enum ")|
                aLine.startsWith("extends ")|
                aLine.startsWith("final ")|
                aLine.startsWith("finally ")|
                aLine.startsWith("interface ")|
                aLine.startsWith("long ")|
                aLine.startsWith("native ")|
                aLine.startsWith("package ")|
                aLine.startsWith("static ")|
                aLine.startsWith("switch ")|
                aLine.startsWith("strictfp ")|
                aLine.startsWith("synchronized ")|
                aLine.startsWith("throw ")|
                aLine.startsWith("throws ")|
                aLine.startsWith("transient ")|
                aLine.startsWith("try ")|
                aLine.startsWith("void ")|
                aLine.startsWith("volatile ")){
//            System.out.println("Decleration line: " + aLine); 
            this.declerationLinesOfCode++;
            result = 2;
        }
        
        else if(aLine.startsWith("}")){
//            System.out.println("Decleration line: " + aLine);
            this.declerationLinesOfCode++;
            result = 2;
        }
        
        else{
//            System.out.println("R2, Executable Line: " + aLine);
            this.executableLinesOfCode++;
            result = 1;
        }
        
        
        
        return result;
    }
    
    public Hashtable<Integer, Object[]> getTableLines(){
        return this.fileLines;
    }
    
    public int getNumberOfExeLines(){
        return this.executableLinesOfCode;
    }
    
    public int getNumberOfDecLines(){
        return this.declerationLinesOfCode;
    }
    
    public int getNumberOfComLines(){
        return this.commentsLinesOfCode;
    }
    
    public String getFilePath(){
        return this.filePath;
    }
    
    private void testTableLines(){
        for(int i=1; i<=this.fileLines.size();i++){
            Object[] lineAndType = new Object[2];
            lineAndType = this.fileLines.get(i);
            System.out.println(lineAndType[1] + " , " + lineAndType[0]);
        }
    }
    
//    public static void main(String[] args){
//        fileContainer fc = new fileContainer("C:/Documents and Settings/user/Desktop/TextVisualization-UC/src/lexicalchainer/group.java");
//        fc.testTableLines();
//    }

}
