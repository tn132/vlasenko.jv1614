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
public class IntegerNumberToken extends Token{
    private final long value;
    public IntegerNumberToken(int line, long val){
        super("",line,Token.INTEGER_NUMBER);
        value=val;
    }
    
    public String value(){
        String s="";
        s+=value;
        return s;
    }
    
    public long getValue(){
        return value;
    }
    
}
