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
public abstract class Figure3D {
    public abstract double volume();
    public abstract double surfaceArea(); 
    public abstract double baseCircumRadius();
    public abstract double altitude();
    
    public void print(){
        System.out.println("");        
        System.out.println("3D figure of type "+this.getClass()+" created");        
        System.out.println("Volume: "+volume());
        System.out.println("Surface area: "+surfaceArea());
        System.out.println("");
    }    
}
