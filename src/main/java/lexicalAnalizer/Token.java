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

/*

%   37
^   94
&   38
/   47
*   42
+   43
-   45
|   124
<   60
=   61      +256
>   62
!   33




*/
public class Token {
    
    public static final int IDENTIFIER=1024, INTEGER_NUMBER=1025, REAL_NUMBER=1026;
            
    public static final int COMPARISON=256+61;
    
    public static final int ASSIGNMENT_MUL=256+42,ASSIGNMENT_DIV=256+47;
    public static final int ASSIGNMENT_REM=256+37,ASSIGNMENT_XOR=256+94;
    public static final int ASSIGNMENT_PLUS=256+43,ASSIGNMENT_MINUS=256+45;
    public static final int ASSIGNMENT_AND=256+38,ASSIGNMENT_OR=256+124;
    public static final int LESS_OR_EQUAL=256+60,GREATER_OR_EQUAL=256+62;
    public static final int NOT_EQUAL=256+33;
    
    public static final int DOUBLE_PLUS=512+43, DOUBLE_MINUS=512+45;
    public static final int DOUBLE_ASTERIX=512+42,DOUBLE_AND=512+35;
    public static final int DOUBLE_OR=512+124,DOUBLE_LESS=512+60;
    public static final int DOUBLE_GREATER=512+62;
    
    
    
    private final String lexeme;
    private final int line, type;
    
    public String value(){
        return lexeme;
    }
    
    public int line(){
        return line;
    }
    public int type(){
        return type;
    }
    
    public Token(String lex, int line, int type){
        lexeme=lex;
        this.line=line;
        this.type=type;
    }
    
    public void println(){
        System.out.print("Token: "+value()+" type: "+type);

        System.out.println(" line: "+line);        
    }
    
}
