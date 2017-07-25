/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.algm;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
/**
 *
 * @author sinukoll
 */
public class QueueArray {
    private int[] queueArray;
    private int front;
    private int rear;
    
    public QueueArray(){
        this.queueArray = new int[10]; // Setting maximum size of 
        this.front = -1;
        this.rear = -1;
    }
    
    public QueueArray(int maximumSize){
        this.queueArray = new int[maximumSize];
        this.front = -1;
        this.rear = -1;
    }
    
    public boolean isEmpty(){
       return (this.front == -1 || this.front == this.rear + 1);
    }
    
    public boolean isFull(){
        return (this.rear == this.queueArray.length-1);
    }
    
    public int size(){
        if(this.isEmpty())
            return 0;
        else
            return (this.rear - this.front + 1);
    }
    
    public void insert(int newValue){
        if(this.isFull()){
            System.out.println("Opps! Queue is full\n");
            return;
        }
        
        if(this.front == -1)
            this.front = 0;
        
        this.rear++;
        this.queueArray[this.rear] = newValue;        
    }
    
    public int delete(){
        if(this.isEmpty()){
            System.out.println("Opps! Queue is Underflow");
            throw new EmptyStackException();
        }
        int tempValue = this.queueArray[this.front];
        this.front++;
        
        return tempValue;
    }
    
    public int peek(){
         if(this.isEmpty()){
             System.out.println("Opps! Queue is Underflow");
             throw new NoSuchElementException();
         }
         
        return this.queueArray[this.front];
    }
    
    public void display(){
        if(this.isEmpty()){
            System.out.println("Opps! Queue is Underflow");
            throw new EmptyStackException();
        }
        
        for(int tempIndex= this.front; tempIndex <= this.rear; tempIndex++)
            System.out.print(this.queueArray[tempIndex] + " ");
    }
    
    
    
    
}
