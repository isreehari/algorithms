/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari;
import java.util.EmptyStackException;
/**
 *
 * @author sinukoll
 */
public class StackArray {
    private int[] stackArray;
    private int top;
    
    
    public StackArray(){
        this.stackArray = new int[10];
        this.top = -1;
    }
    
    public StackArray(int stackArraySize){        
        this.stackArray = new int[stackArraySize];
        this.top = -1;
    }
    
    public int size(){
        return this.top + 1;
    }
    
    public boolean isEmpty(){
        return (this.top == -1);
    }
    
    public boolean isFull(){
        return ( this.top == this.stackArray.length -1 );
    }
    
    public void push(int newValue){
        
        if(this.isFull()){
            System.out.println("Stack Overflow");
            return;
        }
        
        this.top++;
        this.stackArray[this.top] = newValue;
        System.out.println("Element has been pushed to array");
    }
    
    public int pop(){
        int tempValue;
        
        if(this.isEmpty()){
            System.out.println("Stack is underflow");
            throw new EmptyStackException();            
        }
        
        tempValue = this.stackArray[this.top];
        this.top--;        
        return tempValue;
    }
    
    public int peek(){
        
          if(this.isEmpty()){
                System.out.println("Stack is underflow");
                throw new EmptyStackException();
          }
        
        return this.stackArray[this.top];
    }
    
    public void display(){        
        
        
        if(this.isEmpty()){
            System.out.println("Stack is underflow");
            throw new EmptyStackException();
        }
        
        System.out.println("Stack is: ");
        for(int tempValue=this.top; tempValue >= 0; tempValue--){
            System.out.println(this.stackArray[tempValue]);
        }
        System.out.println();
        
    }
    
}
