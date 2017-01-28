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
public class Task6 {
    
    public static void main(String[] args) {
        Integer [][]a=setTriangleArray(10, 99);
        
        Task5.print2dArray(a, false, false);
        System.out.println("Cols reversed");
        Task5.print2dArray(a, false, true);
        System.out.println("Rows reversed");
        Task5.print2dArray(a, true, false);
        System.out.println("Cols and rows reversed");
        Task5.print2dArray(a, true, true);
    }
    
    
    public static Integer[][] setTriangleArray(int n,int maxVal){
        Random rand=new Random();
        Integer[][] array=new Integer[n][];
        for (int i=0;i<n;i++)
        {   
            array[i]=new Integer[i+1];
            for (int j=0;j<=i;array[i][j++]=rand.nextInt(maxVal+1));
        }    
        return array;
    }
    

    
}
