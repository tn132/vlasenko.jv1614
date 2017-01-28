/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;
import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author Александр
 */
public class Task4 {
    
    public static void main(String[] args){
        Integer []a=setArray(20, 100);
        System.out.println(Arrays.toString(a));
        printArray(a, false);
        System.out.println("Reversed");
        printArray(a, true);
        System.out.println("Evens");
        printEvens(a);
        System.out.println("Odds");
        printOdds(a);
        System.out.println("Summ of divisibles by 7 = "+findSumm(a,7));
        System.out.println("Product of divisibles by 3 = "+findProduct(a,3));
    }
    
    public static Integer[] setArray(int len,int maxVal){
        Random rand=new Random();
        Integer[] array=new Integer[len];
        for (int i=0;i<array.length;array[i++]=rand.nextInt(maxVal+1));
        return array;
    }
    
    public static void printArray(Integer[] array, boolean reversedOrder, boolean divisibilityFlag, int... divisors){
        int increment=(reversedOrder)?-1:1;
        int start=(reversedOrder)?(array.length-1):(0);
        for (int i=start;(i>=0)&&(i<array.length);i+=increment)
            for (int d:divisors)
                if (((array[i]%d==0)==divisibilityFlag)||(d==1))
                    System.out.print(array[i]+" ");                                   
        System.out.println("");
    }
    
    public static void printArray(Integer[] array, boolean reversedOrder){
        printArray(array,reversedOrder,true,1);
    }
    
    public static void printEvens(Integer[] array){
        printArray(array,false,true,new int[] {2});
    }
    
    public static void printOdds(Integer[] array){
        printArray(array,false,false,2);
    }    
    
    public static int findSumm(Integer[] array,int divisor){
        int summ=0;
        for (int n:array)
            if (n%divisor==0)summ+=n;
        return summ;
    }
    
    public static double findProduct(Integer[] array,int divisor){
        double product=1;
        for (int n:array)
            if (n%divisor==0)product*=n;
        return product;
    }
    
}
