/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author Александр
 */
public class Task7 {
    
    public static void main(String[] args) {

        Integer [][]a=Task5.set2dArray(13, 11, 99);
        Task5.print2dArray(a, false, false);
        System.out.println("Shifted left or right");
        shiftLeftRight(a, 7, true);
        Task5.print2dArray(a, false, false);
        System.out.println("Shifted up or down");
        shiftUpDown2(a, 4, false);
        Task5.print2dArray(a, false, false);
        
    }
    
    
    public static void shiftLeftRight(Integer[][] array,int n,boolean right ){        
        for (int i=0;i<array.length;i++)
            (new ArrayShifter()).shiftArray(array[i],0,array[i].length-1, n, right);
    }
    
    public static void shiftLeftRight2(Integer[][] array,int n,boolean right ){        
        for (int i=0;i<array.length;i++)
            (new ArrayShifter()).anotherShiftArray(array[i],0,array[i].length-1, n, right);
    }
    
          
    public static void shiftUpDown(Integer[][] array,int n,boolean down ){                      
        (new ArrayShifter()).shiftArray(array,0,array.length-1, n, down);        
    }    
    

    public static void shiftUpDown2(Integer[][] array,int n,boolean down ){                      
        (new ArrayShifter()).anotherShiftArray(array,0,array.length-1, n, down);        
    }    

    
}
