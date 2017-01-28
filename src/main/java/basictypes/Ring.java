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
public class Ring extends Figure2D{
    protected final double radius,width;
    public Ring(double radius,double width){ 
        this.radius=radius; this.width=width;}
    public double area(){return Math.PI*width*(2.0*radius-width);}
    public double perimeter(){return 2.0*Math.PI*(radius+width);}    
}
