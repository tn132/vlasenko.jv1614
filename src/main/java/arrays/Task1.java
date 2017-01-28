/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;
import java.util.Arrays;

/**
 *
 * @author Александр
 */
public class Task1 {
    public static void main(String[] args){
        int[] divisors={2,3,5,7};
        int[] summ=new int[divisors.length];
        for (int i=0;i<=100;i++)
            for (int j=0;j<divisors.length;j++)
                if (i%divisors[j]==0){
                    summ[j]++;
                    System.out.println("Number "+i+" can be divided by "
                                        +divisors[j]);
                }
        System.out.println("");
        for(int j=0; j<divisors.length;j++)
            System.out.println("Summ of numbers divisible by "+divisors[j]+" is "
                            +summ[j]);
        System.out.println("Difference of summs of numbers divisible by"
                            +" 7 and 2 is "
                            +(summ[Arrays.binarySearch(divisors, 7)]
                             -summ[Arrays.binarySearch(divisors, 2)]));
        System.out.println("Relation of summs of numbers divisible by"
                            +" 5 and 3 is "
                            +(summ[Arrays.binarySearch(divisors, 5)]*1.0
                             /summ[Arrays.binarySearch(divisors, 3)]));        
    }
    
}
