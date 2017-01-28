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
public class RectParallelepiped extends Figure3D{
    protected double a,b,c;
    public RectParallelepiped(double a,double b,double c){
        this.a=a; this.b=b; this.c=c;
    }
    public double volume(){return a*b*c;}
    public double surfaceArea(){
        return ((new Rectangle(a, b).area())
                +(new Rectangle(a, c).area())
                +(new Rectangle(b, c).area()))*2;                
    }
    public double baseCircumRadius(){ return Math.sqrt(a*a+b*b)/2.0;}

    public double altitude(){
        return c;
    }
    
}
