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
    
    private String inFix = new String();
    private String postFix = new String();
    
    public PolishNotation(String newInFix){
        this.inFix = newInFix;
    }
    
    public void infixToPostFix(){
        
    }
    
    public int precedence(char symbol){
        
        switch(symbol){
            case '^': return 3;
            case '*': 
            case '/': 
            case '%': return 2;
            case '+': 
            case '-': return 1;
            default: return 0;
        }
    }
    
    
    
}
