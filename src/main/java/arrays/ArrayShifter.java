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
public class ArrayShifter {
    
    public void shiftArray(Object[] array,int first,int last, int shiftCount,boolean leftUp){
        if (shiftCount<0) {shiftCount=-shiftCount; leftUp=!leftUp;}
        int length=last-first+1;
        if (shiftCount>=length) shiftCount%=length;
        while (shiftCount>0){
            if (shiftCount>(length>>1)){
                shiftCount=length-shiftCount;
                leftUp=!leftUp;
            }
            if (leftUp){
                for (int i=last;i>(last-shiftCount);i--){
                    Object temp=array[i];
                    int j=i-shiftCount;
                    do{
                        array[j+shiftCount]=array[j];
                        j-=shiftCount;
                    }while (j>=first);
                    array[j+shiftCount]=temp;
                }      
                last=first+shiftCount-1;            
            }else{
                for (int i=first;i<(first+shiftCount);i++){
                    Object temp=array[i];
                    int j=i+shiftCount;
                    do{
                        array[j-shiftCount]=array[j];
                        j+=shiftCount;
                    }while (j<=last);
                    array[j-shiftCount]=temp;
                }
                first=last-shiftCount+1;            
            }
            shiftCount=length%shiftCount;
            leftUp=!leftUp;            
            length=(last-first+1);
        }    
    }    
    
    public void anotherShiftArray(Object[] array,int first,int last, int shiftCount,boolean leftUp){
        if (shiftCount<0) {shiftCount=-shiftCount; leftUp=!leftUp;}
        int length=last-first+1;
        if (shiftCount>=length) shiftCount%=length;
        if (shiftCount==0) return;
        if (shiftCount>(length>>1)){
            shiftCount=length-shiftCount;
            leftUp=!leftUp;
        }
        int auxLen=(shiftCount-length%shiftCount)%shiftCount;
        Object[] auxArray=new Object [auxLen];        
        if (leftUp){
            for (int i=last;i>(last-shiftCount);i--){
                Object temp=array[i];
                int j=i-shiftCount;
                do{
                    if (j>=first)
                        array[j+shiftCount]=array[j];
                    j-=shiftCount;
                }while (j>=(first-auxLen));                
                j+=shiftCount;
                if (j>=first) array[j]=temp;
                else auxArray[auxLen+j-first]=temp;                                                                                       
            }              
            if (auxLen!=0){
                for (int i=first+shiftCount-1; i>=first+auxLen;i--)
                    array[i]=array[i-auxLen];
                for (int i=auxLen-1;i>=0;i--)    
                    array[first+i]=auxArray[i];            
            }            
        }else{          
            for (int i=first;i<(first+shiftCount);i++){
                Object temp=array[i];
                int j=i+shiftCount;
                do{
                    if (j<=last)
                        array[j-shiftCount]=array[j];
                    j+=shiftCount;
                }while (j<=(last+auxLen));                
                j-=shiftCount;
                if (j<=last) array[j]=temp;
                else auxArray[j-last-1]=temp;                                
            }            
            if (auxLen!=0){
                for (int i=last-shiftCount+1;i<=last-auxLen;i++)
                    array[i]=array[i+auxLen];            
                for (int i=0;i<auxLen;i++)
                    array[last-i]=auxArray[auxLen-1-i];                    
            }            
        }                
    }       
    
}
