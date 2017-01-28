/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basictypes;

/**
 *
 * @author Александр
 */
public abstract class Figure2D {    
    public abstract double area();
    public abstract double perimeter(); 
    public void print(){
        System.out.println("");        
        System.out.println("2D figure of type "+this.getClass()+" created");
        System.out.println("Area: "+area());
        System.out.println("perimeter: "+perimeter());
        System.out.println("");
    }
}









