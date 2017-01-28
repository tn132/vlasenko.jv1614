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
public class Sphere extends Figure3D{
    protected final double radius;
    public Sphere(double radius){this.radius=radius;}
    public double volume(){return 4.0*Math.PI*Math.pow(radius, 3)/3.0;}
    public double surfaceArea(){return 4.0*(new Circle(radius).area());}
    public double baseCircumRadius(){return radius;}
    public double altitude(){return radius*2;}
}