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
public class Cylinder extends Figure3D{
    protected final double radius,height;
    public Cylinder(double radius,double height){
        this.radius=radius;
        this.height=height;
    }
    public double volume(){return height*(new Circle(radius).area());}
    
    public double sideSurfaceArea(){
        return height*(new Circle(radius).perimeter());
    }
    public double surfaceArea(){
        return sideSurfaceArea()+2*(new Circle(radius).area());
    }
    
    public double baseCircumRadius(){
        return radius;}
    
    public double altitude(){
        return height;
    }
    
    public void print(){
        super.print();
        System.out.println("Side surface area: "+sideSurfaceArea());
        System.out.println("");
    }
}

