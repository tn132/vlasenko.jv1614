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
public class Rectangle extends Figure2D{
    protected final double a,b;
    public Rectangle(double a,double b){ 
        this.a=a; this.b=b;
    }
    public double area(){        
        return a*b;
    }
    public double perimeter(){return (a+b)*2;}    
}