/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Александр
 */
public class Task2 {
    private static final String[] 
        BASICS={" ","од","дв","три","четыре","пять","шесть","семь","восемь",
            "девять","десять","одиннадцать","двенадцать","тринадцать",
            "четырнадцать","пятнадцать","шестнадцать","семнадцать",
            "восемнадцать","девятнадцать"};
    private static final String[] BASICS_ENDINGS_F={"","на ","е "," "," "," "};
    private static final String[] BASICS_ENDINGS_M={"","ин ", "а "," "," "," "};            
    private static final String[] TENS={" ","","двадцать ","тридцать ","сорок ",
            "пятьдесят ","шестьдесят ","семьдесят ","восемьдесять ","девяносто "};
    private static final String[] HUNDREDS={"","сто ","двести ","триста ",
            "четыреста ","пятьсот ","шестьсот ","семьсот ","восемьсот ",
            "девятьсот "};
    private static final String[] ENDINGS_F={" ","а ","и ","и ","и "," "}; 
    private static final String[] ENDINGS_M={"ов "," ","а ","а ","а ","ов "}; 
    private static final String[] UNITS={" ","тысяч"
                                        ,"миллион"
                                        ,"миллиард"
                                        ,"триллион"
//                                        ,"квадриллион"
//                                        ,"квинтиллион"
//                                        ,"секстиллион"
//                                        ,"септиллион"
//                                        ............................
            
                                        };
    
    
    private static int sp=0;
    private static int pow1000=0,realPow=0;
    private static String[] stack=new String[1000];
    
    
    public static void main(String[] args){        
        Random rand=new Random();
        
        for (int i=0;i<10;i++){
            long l=rand.nextInt();
            System.out.println(l);
            writeNumber(l);
        }
        for (int i=0;i<10;i++){
            long l=rand.nextLong();
            System.out.println(l);
            writeNumber(l);
        }        
        
        for (int i=0;i<10;i++){
            byte[] bytes=new byte[25];
            rand.nextBytes(bytes);
            BigInteger bigI=new BigInteger(bytes);
            System.out.println(bigI.toString());
            writeNumber(bigI);
        }

    }
    
    private static void writeNumber(BigInteger number){      
        if (number.compareTo(new BigInteger(new byte[]{0}))<0){
            System.out.print("минус ");
            writeNumber(number.abs());
        }else{
            pow1000=realPow=0; 
            sp=0;
            while (number.compareTo(new BigInteger(0,new byte[]{0}))!=0){                   
                int d=number.remainder(new BigInteger(new byte[]{(byte)3,(byte)232})).intValue();
                write3digits(d);
                number=number.divide(new BigInteger(new byte[]{(byte)3,(byte)232}));          
                pow1000=(pow1000+1)%UNITS.length;
                if (pow1000==0) pow1000=1;
                realPow++;
            };
            if (sp>0){
                while (sp>0)
                    System.out.print(stack[--sp]);
            }else System.out.print("ноль");
            System.out.println("");
        }
    }
        
    
    
    private static void writeNumber(long number){      
        if (number<0){
            System.out.print("минус ");
            writeNumber(-number);
        }else{
            pow1000=realPow=0; 
            sp=0;
            while (number!=0){            
                write3digits((int)(number%1000));
                number/=1000;
                pow1000=(pow1000+1)%UNITS.length;
                if (pow1000==0) pow1000=1;
                realPow++;
            };
            if (sp>0){
                while (sp>0)
                    System.out.print(stack[--sp]);
            }else System.out.print("ноль");
            System.out.println("");
        }
    }
    
    private static void write3digits(int number){        
        if (number!=0){
            int num=number;
            String result=HUNDREDS[num/100];
            num%=100;
            if (num<20){
//                if ((num!=1)||(pow1000==0))
                result+=BASICS[num];
            }else{
                result+=TENS[num/10];
                num%=10;
                result+=BASICS[num];
            }
            if (num>5)num=5;
            
            if (pow1000==1){
                
                result+=BASICS_ENDINGS_F[num];
                result+=UNITS[pow1000];
                result+=ENDINGS_F[num];
                
            }else{
                result+=BASICS_ENDINGS_M[num];
                
                if (pow1000!=0){
                    result+=UNITS[pow1000];
                    result+=ENDINGS_M[num];
                }                
            }
            
            if (realPow>=UNITS.length)
                for (int n=realPow;n>=UNITS.length;n-=(UNITS.length-1)){
                    result+=UNITS[UNITS.length-1];
                    if (UNITS.length>2) result+="ов";  
                    result+=" ";
                }             
            stack[sp++]=result;
        }                
    }
    
}
