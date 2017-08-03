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
public class ValidityExpression {
    public boolean isValid(String expression){        
        ValidityExpressionStack  thisValidityExpressionStack = new ValidityExpressionStack(10);
           int expressionLength = expression.length();
           char currentSymbol, popSymbol;
           for(int i=0; i< expressionLength; i++){
               currentSymbol = expression.charAt(i);
               if(this.isValidPushSymbol(currentSymbol))
                   thisValidityExpressionStack.push(currentSymbol);
               
               if(this.isValidPopSymbol(currentSymbol)){
                    if(thisValidityExpressionStack.isEmpty()){
                        System.out.println("Right parentheses are more than left parentheses");
                        return false;
                    }else{
                        popSymbol = thisValidityExpressionStack.pop();
                        if(!this.matchParantheses(popSymbol,currentSymbol)){
                            System.out.println("Miss matched parantheses are : ");
                            System.out.println(popSymbol + " and " + currentSymbol);
                            return false;
                        }
                    }
                        
               }               
           }
           
           if(thisValidityExpressionStack.isEmpty()){
               return true;
           }
               
        
        
        return false;
    }
    
    public boolean isValidPushSymbol(char symbol){
        switch(symbol){
        case '[': return true;
        case '{': return true;
        case '(': return true;        
        default: return false;
    }
    }
    
    public boolean isValidPopSymbol(char symbol){
        switch(symbol){
            case ']': return true;
            case '}': return true;
            case ')': return true;
            default: return false;
        }
    }
    
    public boolean matchParantheses(char leftParantheses, char rightParantheses){
        if(leftParantheses == '[' && rightParantheses == ']')
            return true;
        
        if(leftParantheses == '{' && rightParantheses == '}')
            return true;
        if(leftParantheses == '(' && rightParantheses == ')')
            return true;        
        
        return false;
        
    }
    
}
