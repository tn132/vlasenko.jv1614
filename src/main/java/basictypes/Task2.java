/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basictypes;

import java.util.Scanner;
import lexicalAnalizer.Lexer;

/**
 *
 * @author Александр
 */
public class Task2 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        Figure2D figure=null;                  
        String menu="Choose figure:\n1. Circle\n2. Ring\n3. Triangle\n"
                        +"4. Rectangle\n5. Exit\n";
        do{            
            int choice;
            do {
                choice=readPositiveInteger(menu);                
            }while ((choice<1)||(choice>5));
            if (choice==5)break;
            for (figure=null;figure==null;figure=readFigure2D(choice));
            figure.print();        
        }while (true);
    }
    
    public static int readPositiveInteger(String message){        
        Scanner scan=new Scanner(System.in);
        Integer result=null;
        Lexer lex = null;
        do{
            System.out.print(message);            
            if ((lex==null)||(lex.endOfInput()))
                lex = new Lexer(new String[] {scan.next()+"\n"});
            result=lex.nextInteger();
            if ((result!=null)&&(result<=0)) System.out.println("Enter positive value");
        }while ((result==null)||(result<=0));
        return result;
    }
    
    public static double readPositiveDouble(String message){
        
        Scanner scan=new Scanner(System.in);
        Double result=null;
        Lexer lex = null;
        do{
            System.out.print(message);            
            if ((lex==null)||(lex.endOfInput()))
                lex = new Lexer(new String[] {scan.next()+"\n"});
            result=lex.nextNumber();
            if ((result!=null)&&(result<=0)) System.out.println("Enter positive value");
        }while ((result==null)||(result<=0));
        return result;
    }
    
    private static Figure2D readFigure2D(int type){
        switch (type){
            case 1:return readCircle();
            case 2:return readRing();
            case 3:return readTriangle();
            case 4:return readRectangle();
            default: return null;
        }        
    }
        
    
    
    private static Circle readCircle(){           
        return new Circle(readPositiveDouble("Circle. Enter radius: "));
    }
    
    private static Ring readRing(){
        System.out.print("Ring\n");
        double radius=readPositiveDouble("Enter radius: ");
        double width=readPositiveDouble("Enter width: ");
        while (width>=radius){
            System.out.println("Error: width too big. Try again");
            width=readPositiveDouble("Enter width: ");
        }        
        return new Ring(radius,width);
    }
    
    private static Triangle readTriangle(){    
        System.out.println("Triangle");
        boolean flag=true;
        double[] sides={0,0,0};
        String []s={"first","second","third"};
        do{
            for (int i=0;i<3;sides[i]=readPositiveDouble("Enter "+s[i++]+" side "));                                    

            for (int i=0;i<3; flag&=(sides[i]+sides[(i+1)%3]>sides[(i+2)%3]),i++);
            if (!flag){
                System.out.println("Error: not a triangle! Try again");
                return null;
            }
            }while (!flag);
        return new Triangle(sides[0],sides[1],sides[2]);
    }
    
    private static Rectangle readRectangle(){        
        System.out.println("Rectangle");
        return new Rectangle(readPositiveDouble("Enter length: "), 
                            readPositiveDouble("Enter width: "));
    }    
    
}
