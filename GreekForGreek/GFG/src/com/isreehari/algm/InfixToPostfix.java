/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.algm;
import java.util.EmptyStackException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author sinukoll
 */
public class InfixToPostfix {
    
    public static void main(String[] args){
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        int numberTestCases;
        try {
            numberTestCases = Integer.parseInt(inputReader.readLine());
            String[] inputExpression = new String[numberTestCases];
            String postfix = new String();

            for(int tempTestCases = 0 ; tempTestCases < numberTestCases; tempTestCases++){            
                inputExpression[tempTestCases] = inputReader.readLine();  
            }

            PolishNotation thisPolishNotation = new PolishNotation();
            for(int tempTestCases = 0 ; tempTestCases < numberTestCases; tempTestCases++){            
                 System.out.println(thisPolishNotation.infixToPostFix(inputExpression[tempTestCases]));
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
    
}


/**
 *
 * @author sinukoll
 */
class PolishNotationStack {
    private char[] stackArray;
    private int top;
    
    public PolishNotationStack(){
        this.stackArray = new char[10];
        this.top = -1;
    }
    
    public PolishNotationStack(int sizeArray){
        this.stackArray = new char[sizeArray];
        this.top = -1;
    }
    
    public int size(){
        if(this.top == -1)            
            return 0;
        else
            return this.top + 1;
    }
    
    public boolean isEmpty(){
        return (this.top == -1);
    }
    
    public boolean isFull(){
        return (this.top == this.stackArray.length - 1);
    }
    
    public void push(char newSymbol){
        if(this.isFull()){
            System.out.println("Stack is over flow");
            throw new StackOverflowError();
        }        
        this.top++;        
        this.stackArray[this.top] = newSymbol;        
    }
    
    public char pop(){
        if(this.isEmpty()){
            System.out.println("Stack is under flow");
            throw new EmptyStackException();
        }
        char tempSymbol = this.stackArray[this.top];
        this.top--;
        return tempSymbol;
    }
    
    public char peek(){
         if(this.isEmpty()){
             System.out.println("Stack is underflow");
             throw new EmptyStackException();
         }         
       return this.stackArray[this.top];             
    }
    
    public void display(){
        if(this.isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        for(int i= this.top; i >= 0; i--){
            System.out.println(this.stackArray[i]);
        }        
    }    
    
    
    
    
}

class PolishNotation {    
    
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
    
}
