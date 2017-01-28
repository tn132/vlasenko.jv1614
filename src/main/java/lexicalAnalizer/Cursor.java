/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalAnalizer;

/**
 *
 * @author Александр
 */


public class Cursor {
    private String[] inputText;
    private int currentLine,currentPos;
    
    public Cursor(String[] args){
        inputText=args;
        currentLine=0;
        currentPos=0;
    }
    
    public boolean eof(){
        return (currentLine>=inputText.length)||
                ((currentLine==(inputText.length-1))&&
                (currentPos==inputText[currentLine].length()));
    }
    
    public int line(){return currentLine;}
    
    public char getChar(){
        if ((currentPos)==inputText[currentLine].length()) return '\n';
        else return inputText[currentLine].charAt(currentPos);
    }
    
    public void nextChar(){
        currentPos++;
        if (eof()) return;
        if (currentPos>inputText[currentLine].length()){
            currentPos=0;
            do{
                currentLine++;
            } while ((!eof())&&(inputText[currentLine].length()==0));
        }            
    }
    
}
