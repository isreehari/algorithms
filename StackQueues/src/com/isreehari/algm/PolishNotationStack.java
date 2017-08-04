/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.algm;

import java.util.EmptyStackException;

/**
 *
 * @author sinukoll
 */
public class PolishNotationStack {
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
