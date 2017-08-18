/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari;
import java.util.NoSuchElementException;
/**
 *
 * @author sinukoll
 */
public class QueueCircularLinkedList {
    private Node rearNode;
    public QueueCircularLinkedList(){
        this.rearNode = null;
    }
    public boolean isEmpty(){
        return (this.rearNode == null);
    }
    
    public int size(){
        int tempSize = 0;        
            if(this.isEmpty()){
                return tempSize;
            }
            
        Node currentNode = this.rearNode.nextNode;        
        do{
            tempSize++;
            currentNode = currentNode.nextNode;
        }while(currentNode != this.rearNode.nextNode);
        
        return tempSize;
    }
    
    public void insert(int newNodeValue){        
        Node newNode = new Node(newNodeValue);        
        if(this.isEmpty()){
            this.rearNode = newNode;
            this.rearNode.nextNode = this.rearNode;
            return;
        }
       
        newNode.nextNode = this.rearNode.nextNode;
        this.rearNode.nextNode = newNode;
        this.rearNode = newNode;         
    }
    
    public int delete(){
        if(this.isEmpty()){
            System.out.println("Opps! Queue is underflow");
            throw new NoSuchElementException();
        }
        int tempDeletedNodeValue;
        
            if(this.rearNode.nextNode == this.rearNode){ // if there is only one element
                tempDeletedNodeValue = this.rearNode.nextNode.nodeValue;
                this.rearNode= null;
            }else{
                tempDeletedNodeValue = this.rearNode.nextNode.nodeValue;
                this.rearNode.nextNode = this.rearNode.nextNode.nextNode;
            }
            
            
        return tempDeletedNodeValue;
    }
    
    public int peek(){
        if(this.isEmpty()){
            System.out.println("Opps! Queue is underflow");
            throw new NoSuchElementException();
        }
        return (this.rearNode.nextNode.nodeValue);
    }
    
    public void display(){
        if(this.isEmpty()){
            System.out.println("Opps! Queue is underflow");
            return;
        }
        
        Node currentNode = this.rearNode.nextNode;
        do{
            System.out.print(currentNode.nodeValue+" ");
            currentNode = currentNode.nextNode;
        }while(currentNode != this.rearNode.nextNode);
    }
    
    
}
