/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;
import java.util.Random;

/**
 *
 * @author Александр
 */
public class Task3 {
    
    
    public static void main(String[] args){
        String[][] speech;        
        Random rand=new Random();
        String s="";
        int len=4,minLen=5,maxLen=10;

        speech=new String[len][];
        for (int i=0;i<len;i++){
            int n=minLen+rand.nextInt(maxLen-minLen+1);
            speech[i]=new String [n];
            for (int j=0;j<n; j++)
                speech[i][j]="Phrase "+(j+1)+" of set "+(i+1)+" ";
        }

        
        for (int i=0;i<10;i++){
            
            for (int j=0;j<speech.length;s+=speech[j][rand.nextInt(speech[j].length)],j++);
            s+='\n';
        }
        System.out.println(s);
    }
    
    
}
