/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.algm;
import java.util.NoSuchElementException;
/**
 *
 * @author sinukoll
 */
public class QueueLinkedList {
     private Node frontNode;     
     private Node rearNode;     
     public QueueLinkedList(){
         this.frontNode = null;         
         this.rearNode = null;
     }
     
     public boolean isEmpty(){
         return (this.frontNode == null);
     }
     
     public int size(){
         int tempSize = 0;         
         if(this.isEmpty())
             return tempSize;         
         Node currentNode = this.frontNode;         
         while(currentNode != null){
             tempSize++;
             currentNode = currentNode.nextNode;
         }         
         
         return tempSize;
     }
     
     public void insert(int newValue){
         Node newNode = new Node(newValue);
         
         if(this.isEmpty()){             
             this.frontNode = this.rearNode = newNode;
             return;
         }         
         this.rearNode.nextNode = newNode;
         this.rearNode = this.rearNode.nextNode;
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
         
         Node currentNode = this.frontNode;
         while(currentNode != null){
             System.out.print(currentNode.nodeValue +" ");
             currentNode = currentNode.nextNode;
         }
         
     }
     
     
    
}
