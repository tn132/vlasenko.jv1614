/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalAnalizer;

/**
 *
 * @author Александр
 */
public class RealNumberToken extends Token{
    
    private final double value;
    public RealNumberToken(int line, double val){
        super("",line,Token.REAL_NUMBER);
        value=val;
    }
    
    public String value(){        
        String s="";
        s+=value;
        return s;
    }
    
    public Double getValue(){
        return value;
    }    
    
}
