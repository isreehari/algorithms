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
public class QueueCircularArray {
    private int[] queueArray;
    private int front;
    private int rear;
    
    public QueueCircularArray(){
        this.queueArray = new int[10]; // Setting maximum size of 
        this.front = -1;
        this.rear = -1;
    }
    
    public QueueCircularArray(int maximumSize){
        this.queueArray = new int[maximumSize];
        this.front = -1;
        this.rear = -1;
    }
    
    public boolean isEmpty(){
       return (this.front == -1);
    }
    
    public boolean isFull(){
        return (this.front == this.rear+1 || (this.front == 0 && this.rear == this.queueArray.length-1));
    }
    
    public int size(){
        
        int tempSize = 0;
        if(this.isEmpty())
            return tempSize;
       
        if(this.isFull())
            return this.queueArray.length;
        
         if(this.front <= this.rear)
            for(int tempIndex= this.front; tempIndex <= this.rear; tempIndex++)
                tempSize++;
        else{
            for(int tempIndex= this.front; tempIndex <= (this.queueArray.length-1); tempIndex++)
                tempSize++;
        
            for(int tempIndex= 0; tempIndex <= this.rear; tempIndex++)
                tempSize++;
        }
            
        return tempSize;
            
    }
    
    public void insert(int newValue){
        if(this.isFull()){ // if the queue is full 
                System.out.println("Opps! Queue is Overflow\n");
                return;
            }
        
        if(this.front == -1)
            this.front = 0;
        if(this.rear == this.queueArray.length-1)
            this.rear = 0;
        else
            this.rear++;
        
        this.queueArray[this.rear] = newValue;        
    }
    
    public int delete(){
        if(this.isEmpty()){
            System.out.println("Opps! Queue is Underflow");
            throw new EmptyStackException();
        }
        int tempValue = this.queueArray[this.front];
        
        if(this.front == this.rear){ // If the queue has only one element
            this.front = -1;
            this.rear = -1;
        }else if(this.front == this.queueArray.length-1){
            this.front = 0;
        }else
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
        if(this.front <= this.rear)
            for(int tempIndex= this.front; tempIndex <= this.rear; tempIndex++)
                System.out.print(this.queueArray[tempIndex] + " ");
        else{
            for(int tempIndex= this.front; tempIndex <= (this.queueArray.length-1); tempIndex++)
                System.out.print(this.queueArray[tempIndex] + " ");
        
            for(int tempIndex= 0; tempIndex <= this.rear; tempIndex++)
                System.out.print(this.queueArray[tempIndex] + " ");
        }
            
    }
    
}
