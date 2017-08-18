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
public class PriorityQueueLinkedList {
    
      private PriorityNode frontNode;     
     
     public PriorityQueueLinkedList(){
         this.frontNode = null;              
     }
     
     public boolean isEmpty(){
         return (this.frontNode == null);
     }
     
     public int size(){
         int tempSize = 0;         
         if(this.isEmpty())
             return tempSize;         
         PriorityNode currentNode = this.frontNode;         
         while(currentNode != null){
             tempSize++;
             currentNode = currentNode.nextNode;
         }         
         
         return tempSize;
     }
     
     public void insert(int newNodeValue, int newNodePriority){
         PriorityNode newNode = new PriorityNode(newNodeValue, newNodePriority);
         
         if(this.isEmpty() || newNodePriority < this.frontNode.nodePriority){      
              newNode.nextNode = this.frontNode;
              this.frontNode = newNode;
         }else {
             PriorityNode currentNode = this.frontNode;
                while(currentNode.nextNode != null && currentNode.nextNode.nodePriority <= newNodePriority){      
                    currentNode = currentNode.nextNode;
                }             
                newNode.nextNode = currentNode.nextNode;                
                currentNode.nextNode = newNode;
         }
         
         
     }
     
     public int delete(){
         int tempDeletedValue = 0;
         if(this.isEmpty()){
             System.out.println("Queue is underflow");
             throw new NoSuchElementException();
         }         
         tempDeletedValue = this.frontNode.nodeValue;
         this.frontNode = this.frontNode.nextNode;
         return tempDeletedValue;
     }
     
     public int peek(){
           if(this.isEmpty()){
               System.out.println("Queue is empty");
               throw new NoSuchElementException();
           }
           
           return this.frontNode.nodeValue;
     }
     
     public void display(){
         if(this.isEmpty()){
             System.out.println("Queue is empty");
             return;
         }
         
         PriorityNode currentNode = this.frontNode;
         while(currentNode != null){
             System.out.println(currentNode.nodeValue +" \t " + currentNode.nodePriority);
             currentNode = currentNode.nextNode;
         }
         
     }
    
}
