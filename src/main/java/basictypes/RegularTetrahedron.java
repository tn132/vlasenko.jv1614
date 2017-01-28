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
public class RegularTetrahedron extends Figure3D{
    protected double a;
    public RegularTetrahedron(double a){
        this.a=a; 
    }
    public double volume(){return a*a*a/12*Math.sqrt(2);}
    public double surfaceArea(){
        return (new Triangle(a,a,a).area())*4;                
    }
    public double baseCircumRadius(){return a/Math.sqrt(3.0);}
    public double altitude(){return a*Math.sqrt(2.0/3.0);}
}
