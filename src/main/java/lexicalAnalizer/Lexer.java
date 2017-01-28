
package lexicalAnalizer;

/**
 *
 * @author Александр
 */
public class Lexer {
    private Cursor cursor;

    private final int UNKNOWN=0x80000000, SPACE=0, LETTER=1, DIGIT=2;
    private final int PARENTHESIS=4, OPERATOR=8, DIVIDER=16;
    // automaton states
    private final int BEGIN=0, ID=1, NUMBER=2, NUMBER_BASE_SET=3, NUMBER_INT=4;
    private final int NUMBER_PERIOD=5, NUMBER_FRAC=6, NUMBER_EXP=7;
    private final int NUMBER_OPTSIGN=8,NUMBER_EXPONENT=9;
    private final int BINARY_SINGLE=10,BINARY_DOUBLE=11;
       
    private final int END=256, FAIL=257;
    // types of lexemes
    
    
    private int state,base;
    private String lexeme;  
    private int lexemeType;
    
        
    private Token token;
    
    public Lexer(String[] text){
        cursor=new Cursor(text);                        
    }
    
    public boolean endOfInput(){
        return cursor.eof();
    }

    
    public Token getToken(){
        return token;
    }
    
    public Integer nextInteger(){
        Token prev=null;
        Integer result;
        while (!endOfInput()){
            nextToken();            
            if ((token!=null)&&(token.type()==Token.INTEGER_NUMBER)){
                result=new Integer(token.value());
                if ((prev!=null)&&(prev.type()=='-')) result*=-1;
                return result;
            }                
            prev=token;
        }
        return null;
    }
    
    public Double nextDouble(){
        Token prev=null;
        Double result;        
        while (!endOfInput()){
            nextToken();            
            if ((token!=null)&&(token.type()==Token.REAL_NUMBER)){
                result=new Double(token.value());
                if ((prev!=null)&&(prev.type()=='-')) result*=-1;
                return result;
            }
            prev=token;
        }
        return null;
    }
    
    public Double nextNumber(){
        Token prev=null;
        Double result;               
        while (!endOfInput()){
            nextToken();
            if ((token!=null)
                &&((token.type()==Token.REAL_NUMBER)
                    ||(token.type()==Token.INTEGER_NUMBER))){
                result=new Double(token.value());
                if ((prev!=null)&&(prev.type()=='-')) 
                    result*=-1;
                return result;
            }
            prev=token;
        }
        return null;
    }    
    
    private int charType(char ch, int base){
        if (base<=10){
            if (((ch>='a')&&(ch<='z'))||((ch>='A')&&(ch<='Z'))) return LETTER;
            if ((ch>='0')&&(ch<(char)((int)'0'+base))) return DIGIT;
        }else{
            if ((ch>='0')&&(ch<='9')) return DIGIT;
            if ((ch>='a')&&(ch<(char)((int)'a'+base-10))) return DIGIT;
            if ((ch>=(char)((int)'a'+base-10))&&(ch<='z')) return LETTER;
            if ((ch>='A')&&(ch<(char)((int)'A'+base-10))) return DIGIT;
            if ((ch>=(char)((int)'A'+base-10))&&(ch<='Z')) return LETTER;
        }
        if ((ch==' ')||(ch=='\t')||(ch=='\n')) return SPACE;
        if ((ch=='(')||(ch==')')||(ch=='[')||(ch==']')||(ch=='{')||(ch=='}'))
            return PARENTHESIS;
        if ((ch=='+')||(ch=='-')||(ch=='*')||(ch=='/')||(ch=='~')||(ch=='!')
            ||(ch=='%')||(ch=='\\')|(ch=='^')||(ch=='|')||(ch=='&'))
            return OPERATOR;
       
        return UNKNOWN;
    }

private int digitValue(char ch, int base){
    if (base<=10) 
        return (int)ch-(int)'0';
    if ((ch<='z')&&(ch>='a')&&(((int)ch-(int)'a')>=(base-10))) 
        return (int)ch-(int)'a'+10;
    if ((ch<='Z')&&(ch>='A')&&(((int)ch-(int)'A')>=(base-10))) 
        return (int)ch-(int)'A'+10;
    return -1;
}

    
    public void nextToken(){
        lexeme="";         
        base=10;
        char ch='\0';
        long intPart=0,exponent=0,expSign=1;                       
        double fracPart=0;
                
        while (!cursor.eof()){
            ch=cursor.getChar();
            if (charType(ch, base)!=SPACE) break;
            cursor.nextChar();
        }
        if (cursor.eof()){
            token=null;
            return;
        }
        
        int errorState=0;
        lexemeType=0;
        for (state=BEGIN, ch=cursor.getChar(); ; ch=cursor.getChar()){               
            if (cursor.eof())state=END;
            switch (state){
//******************************************************************************
                case BEGIN:{                      
                    switch (charType(ch, base)){
                        case UNKNOWN:{
                            errorState=state;
                            state=END;                                                        
                        }break;
                        case LETTER:{                            
                            state=ID;                            
                        }break;
                        case DIGIT:{                            
                            state=NUMBER;
                            base=10;
                            intPart=digitValue(ch, base);                            
                        }break;
                        case PARENTHESIS:{
                            lexemeType=(int)ch;
                            state=END;
                        }break;
                        case OPERATOR:{                            
                            lexemeType=ch;
                            switch (ch){
                                case '=':
                                case '!':
                                case '/':
                                case '%':
                                case '^':{                                    
                                    state=BINARY_SINGLE;
                                }break;
                                case '-':
                                case '*':
                                case '+':                                   
                                case '&':
                                case '|':                                
                                case '<':
                                case '>':{
                                    state=BINARY_DOUBLE;
                                }break;                                                                                                    
                            }
                        }break;
                    }
                }break;
//******************************************************************************
                case ID:{
                    if ((charType(ch, base)!=LETTER)&&(charType(ch, base)!=DIGIT)){
                        lexemeType=Token.IDENTIFIER;
                        state=END;
                        continue;
                    }break;          
                }
//******************************************************************************
                case NUMBER:{
                    if (charType(ch, base)==DIGIT){
                        intPart=intPart*base+digitValue(ch, base);
                    }else if (ch=='#'){
                        base=(int)intPart;
                        state=NUMBER_BASE_SET;
                    }else if (ch=='.'){       
                        lexemeType=Token.REAL_NUMBER;
                        state=NUMBER_PERIOD;
                    }else if ((ch=='e')||(ch=='E')){                        
                        state=NUMBER_EXP;
                        lexemeType=Token.REAL_NUMBER;
                    }else{
                        if ((charType(ch, base)!=OPERATOR)
                                &&(charType(ch, base)!=SPACE)){
                            errorState=state;
                        }else
                            lexemeType=Token.INTEGER_NUMBER;
                        state=END;
                        continue;
                    }
                }break;
                case NUMBER_BASE_SET:{
                    if (charType(ch,base)==DIGIT){
                        intPart=digitValue(ch, base);
                        state=NUMBER_INT;
                    }else{
                        errorState=state;                        
                        state=END;
                        continue;
                    }                    
                }break;
                case NUMBER_INT:{
                    if (charType(ch,base)==DIGIT){
                        intPart=intPart*base+digitValue(ch, base);
                    }else if (ch=='.'){
                        lexemeType=Token.REAL_NUMBER;
                        state=NUMBER_PERIOD;
                    }else if ((ch=='e')||(ch=='E')){
                        lexemeType=Token.REAL_NUMBER;
                        state=NUMBER_EXP;
                    }else{
                        if ((charType(ch, base)!=OPERATOR)
                                &&(charType(ch, base)!=SPACE)){
                            errorState=state;
                        }else
                            lexemeType=Token.INTEGER_NUMBER;
                        state=END;
                        continue;
                    }
                }break;
                case NUMBER_PERIOD:{
                    if (charType(ch,base)==DIGIT){
                        fracPart=digitValue(ch, base);
                        state=NUMBER_FRAC;
                    }else{
                        errorState=state;
                        state=END;
                        continue;
                    }                                        
                }break;
                case NUMBER_FRAC:{
                    if (charType(ch,base)==DIGIT){
                        fracPart=fracPart*base+digitValue(ch, base);
                    }else if ((ch=='e')||(ch=='E')){
                        state=NUMBER_EXP;
                    }else{         
                        if ((charType(ch, base)!=OPERATOR)
                                &&(charType(ch, base)!=SPACE)){
                            errorState=state;
                        }else                        
                        lexemeType=Token.REAL_NUMBER;
                        state=END;
                        continue;
                    }                    
                }break;
                case NUMBER_EXP:{
                    if (charType(ch,base)==DIGIT){
                        exponent=digitValue(ch, base);                        
                        state=NUMBER_EXPONENT;
                    }else if ((ch=='+')){
                        state=NUMBER_OPTSIGN;
                    }else if ((ch=='-')){
                        state=NUMBER_OPTSIGN;
                        expSign=-1;
                    }else{
                        errorState=state;
                        state=END;
                        continue;
                    }                    
                }break;
                case NUMBER_OPTSIGN:{
                    if (charType(ch,base)==DIGIT){
                        exponent=digitValue(ch, base);                        
                        state=NUMBER_EXPONENT;
                    }else{
                        errorState=state;
                        state=END;
                        continue;
                    }                    
                }break;
                case NUMBER_EXPONENT:{
                    if (charType(ch,base)==DIGIT){
                        exponent=exponent*base+digitValue(ch, base);
                    }else{
                        if ((charType(ch, base)!=OPERATOR)
                                &&(charType(ch, base)!=SPACE)){
                            errorState=state;
                        }else                        
                        lexemeType=Token.REAL_NUMBER;
                        exponent*=expSign;
                        state=END;
                        continue;
                    }
                }break;
//******************************************************************************                
                case BINARY_SINGLE:{
                    state=END;
                    if (ch=='='){
                        lexemeType+=256;                       
                    }else continue;                    
                }break;                
                case BINARY_DOUBLE:{
                    state=END;
                    if (ch==lexemeType){
                        lexemeType+=512;
                    }else continue;
                }break;
//******************************************************************************
                case END:{
                    if (lexeme=="") {token=null;return;}
                    switch (lexemeType){
                        case Token.INTEGER_NUMBER:{
                            token=new IntegerNumberToken(cursor.line(), intPart);
                            return;
                        }
                        case Token.REAL_NUMBER:{
                            
                            double val=intPart;
                            if (fracPart!=0){
                                int pow=1+(int)(Math.log(fracPart)/Math.log(base));
                                val+=fracPart/Math.pow(base, pow);                                
                            }
                            val*=Math.pow(base, exponent);
                            token=new RealNumberToken(cursor.line(), val);
                            return;
                        }
                        default:{
                            token=new Token(lexeme,cursor.line(),lexemeType);
                            return;
                        }
                    }
                }     
            }                 
            lexeme+=ch;
            cursor.nextChar();
        }
        
        
    }
    
    
    
    
}
