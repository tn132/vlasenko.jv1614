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
public class HollowCylinder extends Cylinder{
    protected Figure3D cavity;
    public HollowCylinder(double radius, double height, Figure3D cavity){
        super(radius,height);
        if ((baseCircumRadius()>=cavity.baseCircumRadius())
                &&(altitude()>=cavity.altitude())){
            if (!(cavity instanceof HollowCylinder)){
                this.cavity=cavity;
            }else{
                this.cavity=null;
                System.out.println("Error: cavity cannot be hollow");
                System.out.println("Cylinder without cavity created");
            }
        }else{
            this.cavity=null;
            System.out.println("Error: cavity too big");
            System.out.println("Cylinder without cavity created");
        }            
    }
    public double volume(){
        double vol=super.volume();
        if (cavity!=null) vol-=cavity.volume();
        return vol;
    }    
    
    public void print(){
        super.print();
        System.out.println("Information about cavity:");
        if (cavity!=null) cavity.print();
        else System.out.println("No cavity");
        System.out.println("");
    }    
}
