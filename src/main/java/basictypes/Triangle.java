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
public class Triangle extends Figure2D{
    protected final double a,b,c;
    public Triangle(double a,double b,double c){ 
        this.a=a; this.b=b;this.c=c;
    }
    public Triangle(double a){ 
        this.a=this.b=this.c=a;
    }    
    public double area(){
        double p=perimeter()/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    public double perimeter(){return a+b+c;}    
}
