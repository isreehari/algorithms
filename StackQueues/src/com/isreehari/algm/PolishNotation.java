/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.algm;

/**
 *
 * @author sinukoll
 */
public class PolishNotation {
    
    
    public String infixToPostFix(String infix){
        String postfix = new String();
        PolishNotationStack thisStack = new PolishNotationStack(infix.length());
        if(infix != null && !infix.isEmpty()){
            int infixLength = infix.length();
            char symbol;
            for(int i=0; i<infixLength; i++){
                symbol = infix.charAt(i);
                
                if(symbol == ' ' && symbol == '\t') // ignote blanks and tabs
                    continue;
                
                if(this.isOperant(symbol)){
                  if(symbol =='(')
                            thisStack.push(symbol);
                        else if(symbol == ')'){
                            while(thisStack.peek() != '('){                                
                              postfix += thisStack.pop();                                
                            }
                            thisStack.pop();
                        }else{                            
                            while(!thisStack.isEmpty() && this.precedence(symbol) <= this.precedence(thisStack.peek())){ // new symbol <= old symbol then push
                              postfix += thisStack.pop();
                            }
                               thisStack.push(symbol);
                        }
                        
                }else{
                    postfix += symbol;
                }
            }
            
            while(!thisStack.isEmpty()){
                postfix += thisStack.pop();
            }
        }
        
        return postfix;
    }
    
    public String infixToPrefix(String infix){
        String prefix = new String();
        
        if(infix != null && !infix.isEmpty()){
            int infixLength = infix.length();
            PolishNotationStack thisStack = new PolishNotationStack(infixLength);
            char symbol;
            for(int index = infixLength-1; index>=0; index--){
                symbol = infix.charAt(index);
                
                if(symbol == ' ' && symbol == '\t')
                    continue;
                
                if(this.isOperant(symbol)){
                    if(symbol == ')')
                        thisStack.push(symbol);
                    else if(symbol == '('){
                        while(thisStack.peek() != ')'){
                                prefix = thisStack.pop() + prefix;
                        }
                        thisStack.pop();
                    }else{
                         while(!thisStack.isEmpty() && this.precedence(symbol) < this.precedence(thisStack.peek())){
                             prefix = thisStack.pop() + prefix;
                         }
                         
                         thisStack.push(symbol);
                    }
                }else{
                    prefix = symbol + prefix;
                }                
            }
            
            while(!thisStack.isEmpty()){
                prefix = thisStack.pop() + prefix;
            }
            
        }
        
        
        return prefix;
    }
    
    public int precedence(char symbol){        
        switch(symbol){
            case '(': return 0;
            case '^': return 3;
            case '*': 
            case '/': 
            case '%': return 2;
            case '+': 
            case '-': return 1;
            default: return 0;
        }
    }
    
    public boolean isOperant(char symbol){
        switch(symbol){
            case '(':
            case ')':
            case '^': 
            case '*': 
            case '/': 
            case '%': 
            case '+': 
            case '-': return true;
            default: return false;
        }
    }
    
    public long evaluatePostfixExpression(String postfix){
        long tempResult = 0;
        PolishNotationStackLong thisStackLong = new PolishNotationStackLong();
        int postfixLength = postfix.length();
        char symbol;
        long x, y;
        for(int index = 0; index < postfixLength; index++){
            symbol = postfix.charAt(index);
            if(this.isOperant(symbol)){
                x = thisStackLong.pop();
                y = thisStackLong.pop();
                
                switch(symbol){
                    case '^': tempResult = this.power(y,x); break;
                    case '*': tempResult = y * x; break;
                    case '/': tempResult = y / x; break;             
                    case '%': tempResult = y % x; break;
                    case '+': tempResult = y + x; break;
                    case '-': tempResult = y - x; break;
                }
                
                thisStackLong.push(tempResult);
                
            }else{
                if(Character.isDigit(symbol))
                    thisStackLong.push(Character.getNumericValue(symbol));
            }
        }
        
        
        return thisStackLong.pop();
        
    }
    
    
     public long evaluatePrefixExpression(String prefix){
        long tempResult = 0;
        PolishNotationStackLong thisStackLong = new PolishNotationStackLong();
        int prefixLength = prefix.length();
        char symbol;
        long x, y;
        for(int index = prefixLength-1; index >= 0; index--){
            symbol = prefix.charAt(index);
            if(this.isOperant(symbol)){
                x = thisStackLong.pop();
                y = thisStackLong.pop();
                
                switch(symbol){
                    case '^': tempResult = this.power(x,y); break;
                    case '*': tempResult = x * y; break;
                    case '/': tempResult = x / y; break;             
                    case '%': tempResult = x % y; break;
                    case '+': tempResult = x + y; break;
                    case '-': tempResult = x - y; break;
                }
                
                thisStackLong.push(tempResult);
                
            }else{
                if(Character.isDigit(symbol))
                    thisStackLong.push(Character.getNumericValue(symbol));
            }
        }
        
        
        return thisStackLong.pop();
        
    }
    
    public long power(long temp, long tempPower){
        return (long) java.lang.Math.pow(temp, tempPower);
    }
    
    
    
    
}
