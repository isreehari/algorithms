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
public class StackLinkedList {
    private Node top;
    
    public StackLinkedList(){
        this.top = null;
    }
    
    
    
    public int size(){
        Node currentNode;
        int tempSize = 0;
        if(this.top == null)
            return tempSize;
        
        currentNode = this.top;        
        while(currentNode != null){
            tempSize++;
            currentNode = currentNode.nextNode;
        }
        return tempSize;
    }
    
    public boolean isEmpty(){
        return (this.top == null);
    }
    
    public void push(int newNodeValue){
        Node newNode = new Node(newNodeValue);
        
        if(this.isEmpty()){
            this.top = newNode;
            return;
        }        
        newNode.nextNode = this.top;
        this.top = newNode;
    }
    
    public void pop(){
        if(this.isEmpty()){
            System.out.println("Opps! List is empty");
            throw new EmptyStackException();            
        }        
        this.top = this.top.nextNode;
    }
    
    public int peek(){
        if(this.isEmpty()){
            System.out.println("Opps! List is empty");
            throw new EmptyStackException();
        }
        
        return this.top.nodeValue;        
    }
    
    public void displayAll(){
        Node currentNode;
         
        if(this.isEmpty()){
            System.out.println("Opps! List is empty");
            return;
        }
        
        currentNode = this.top;
        while(currentNode != null){
            System.out.println(currentNode.nodeValue);
            currentNode = currentNode.nextNode;
        }
            
    }
}
