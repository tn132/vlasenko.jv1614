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
public class Circle extends Figure2D{
    protected final double radius;
    public Circle(double radius){ this.radius=radius;}
    public double area(){return Math.PI*radius*radius;}    
    public double perimeter(){return 2.0*Math.PI*radius;}    
}
