/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basictypes;

import static basictypes.Task2.readPositiveInteger;
import static basictypes.Task2.readPositiveDouble;


/**
 *
 * @author Александр
 */
public class Task3 {
    public static void main(String[] args){
        String menu="Choose figure\n1. Sphere\n2. Cylinder\n"
                +"3. Rectangular parallelepiped\n4. Regular tetrahedron\n"
                +"5. Hollow cylinder\n6. Exit\n";
        do{   
            Figure3D figure;
            int choice;
            do {
                choice=readPositiveInteger(menu);                
            }while ((choice<1)||(choice>6));
            if (choice==6)break;
            for (figure=null;figure==null;figure=readFigure3D(choice));
            figure.print();               
        }while (true);
    }
    

    private static Figure3D readFigure3D(int type){
        switch (type){
            case 1:return readSphere();
            case 2:return readCylinder();
            case 3:return readParallelepiped();
            case 4:return readTetrahedron();
            case 5:return readHollowCylinder();
            default: return null;
        }        
    }

    private static Sphere readSphere(){
        System.out.println("Sphere");        
        return new Sphere(readPositiveDouble("Enter radius: "));
    }
    
    private static Cylinder readCylinder(){        
        System.out.println("Cylinder");                     
        return new Cylinder(readPositiveDouble("Enter radius: "),
                            readPositiveDouble("Enter height: "));
    }
    
    private static RectParallelepiped readParallelepiped(){        
        System.out.print("RectParallelepiped");                                
        return new RectParallelepiped(readPositiveDouble("Enter first side: "),
                                      readPositiveDouble("Enter second side: "),
                                      readPositiveDouble("Enter third side: "));
    }
    
    private static RegularTetrahedron readTetrahedron(){
        System.out.println("Regular tetrahedron");
        return new RegularTetrahedron(readPositiveDouble("Enter edge: "));
    }
    
    private static HollowCylinder readHollowCylinder(){        
        System.out.println("Cylinder with cavity");
        double radius=readPositiveDouble("Enter radius: ");
        double height=readPositiveDouble("Enter height: ");       
        Figure3D cavity;
        String menu="Coose cavity type\n1. Sphere\n2. Cylinder\n"
                    +"3. Rectangular parallelepiped\n4. Regular tetrahedron\n";        
        int choice;
        do {
            choice=readPositiveInteger(menu);
        }while ((choice<1)||(choice>4));
        for (cavity=null;cavity==null;cavity=readFigure3D(choice));                
        return new HollowCylinder(radius, height, cavity);
    }
    

    
}

 
