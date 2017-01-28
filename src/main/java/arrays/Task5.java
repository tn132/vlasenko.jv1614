/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import static arrays.Task4.findProduct;
import static arrays.Task4.findSumm;
import static arrays.Task4.printArray;
import static arrays.Task4.printEvens;
import static arrays.Task4.printOdds;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Александр
 */
public class Task5 {
    
    public static void main(String[] args){
        Integer [][]a=set2dArray(6,10,99);
        for (int i=0;i<a.length;System.out.println(Arrays.toString(a[i++])));               
        System.out.println("");
        print2dArray(a,false,false);
        
        System.out.println("Evens in ever rows");
        printEvensOfEvenRows(a);
        
        System.out.println("Odds in odd cols");
        printOddsOfOddCols(a);
        
        System.out.println("Summ of divisibles by 7 in even rows= "
                            +findSumm(a,7));
        System.out.println("Product of divisibles by 3 in odd rows = "
                            +findProduct(a,3));        
        
    }
    
    public static Integer[][] set2dArray(int n,int m,int maxVal){
        Random rand=new Random();
        Integer[][] array=new Integer[n][m];
        for (int i=0;i<n;i++)
            for (int j=0;j<m;array[i][j++]=rand.nextInt(maxVal+1));
        return array;
    }

    
    public static void print2dArray(Integer[][]array,boolean reversedRowOrder,
                            boolean reversedColOrder){
        int firstRow=(reversedRowOrder)?(array.length-1):0;
        int incRow=(reversedRowOrder)?(-1):1;
        for (int i=firstRow;(i>=0)&&(i<array.length);i+=incRow)
            Task4.printArray(array[i], reversedColOrder);        
    }
    
    public static void printEvensOfEvenRows(Integer[][]array){
        for (int i=0;i<array.length;i++)
            if (i%2==0) Task4.printArray(array[i],false,true,2);
            else System.out.println("");                    
    }
    
    public static void printOddsOfOddCols(Integer[][]array){
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++)
                if ((j%2==0)||(array[i][j]%2==0))
                    System.out.print("   ");
                else System.out.print(array[i][j]); 
            System.out.println("");
        }                        
    }
    
    public static int findSumm(Integer[][] array,int divisor){
        int summ=0;
        for (int i=0;i<array.length;i++)
            if (i%2==0) summ+=Task4.findSumm(array[i], divisor);                   
        return summ;
    }
    
    public static double findProduct(Integer[][] array,int divisor){
        double product=1;
        for (int i=0;i<array.length;i++)
            if (i%2!=0) product*=Task4.findProduct(array[i], divisor);                  
        return product;
    }    
    
}
