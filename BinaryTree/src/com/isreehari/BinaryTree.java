/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 *
 * @author sinukoll
 */
public class BinaryTree {
     public BinaryTreeCharNode  rootNode;     
     public BinaryTree(){
         this.rootNode = null;
     }    
     public void build(Scanner inputScanner){
        int userChoice;
        char newNodeValue;
        BinaryTreeCharNode currentNode, newNode;
        while(true){
                if(this.rootNode == null){
                    System.out.println("1. Do you want add root node?");
                    System.out.println("2. Do you want to pre populate the data? ");
                    System.out.println("0. Return main menu");
                    System.out.print("Please Enter your choice: ");
                    userChoice = inputScanner.nextInt();
                    //inputScanner.next(); // teriminate the input scanner becuase nextInt() function will not teriminate input scanner
                     if(userChoice ==  0){
                         return;
                     }else if (userChoice == 1){
                         System.out.print("Please enter value for Root Node:");                         
                         newNodeValue = inputScanner.next().toUpperCase().charAt(0);  
                         newNode = new BinaryTreeCharNode(newNodeValue);
                         this.rootNode = newNode;
                     }else if (userChoice == 2){
                         this.prePoplateData();
                     }
                }else{
                    System.out.println("1. Do you want add left chid?");
                    System.out.println("2. Do you want add right child?");
                    System.out.println("0. Return main menu");
                    System.out.print("Please Enter your choice: ");
                    userChoice = inputScanner.nextInt();
                    if(userChoice ==  0){
                         return;
                     }else{
                           if(userChoice == 1){
                               
                               System.out.print("Please enter value for Lift Child Node:");                         
                               newNodeValue = inputScanner.next().toUpperCase().charAt(0);  
                               newNode = new BinaryTreeCharNode(newNodeValue);
                               currentNode =  this.rootNode;
                               while(currentNode.leftChildNode != null)
                                   currentNode = currentNode.leftChildNode;
                               
                               currentNode.leftChildNode = newNode;
                               
                           }else if(userChoice == 2){
                               
                               System.out.print("Please enter value for Right Child Node:");                         
                               newNodeValue = inputScanner.next().toUpperCase().charAt(0);  
                               newNode = new BinaryTreeCharNode(newNodeValue);
                               currentNode =  this.rootNode;
                               while(currentNode.rightChildNode != null)
                                   currentNode = currentNode.rightChildNode;
                               
                               currentNode.rightChildNode = newNode;                               
                           }
                        
                    }
                    
                }
                
                
                
        }
        
        
        
        
    }    
     public void prePoplateData(){
        this.rootNode = new BinaryTreeCharNode('P');
        this.rootNode.leftChildNode = new BinaryTreeCharNode('A');        
        this.rootNode.leftChildNode.rightChildNode = new BinaryTreeCharNode('Z');
        this.rootNode.leftChildNode.leftChildNode = new BinaryTreeCharNode('T');
        this.rootNode.leftChildNode.leftChildNode.rightChildNode = new BinaryTreeCharNode('Y');
        
        this.rootNode.rightChildNode = new BinaryTreeCharNode('X');        
        this.rootNode.rightChildNode.leftChildNode = new BinaryTreeCharNode('M');
        this.rootNode.rightChildNode.leftChildNode.leftChildNode = new BinaryTreeCharNode('L');
        
        this.rootNode.rightChildNode.rightChildNode = new BinaryTreeCharNode('G');
        this.rootNode.rightChildNode.rightChildNode.leftChildNode = new BinaryTreeCharNode('F');
        this.rootNode.rightChildNode.rightChildNode.rightChildNode = new BinaryTreeCharNode('C');
        
        System.out.println("Data has been populated");
        
        
        
    }    
     public void display(){
       if(this.rootNode != null){
            this.printTree(this.rootNode, 0,false);
            System.out.println();
       }           
    }    
     private void printTree(BinaryTreeCharNode currentNode, int level, boolean isItLeft){
        int i;
        if(currentNode == null)
            return;
        
        this.printTree(currentNode.rightChildNode, level+1, false);
             System.out.println();
             
        for(i=0; i< level; i++)    {
            if(isItLeft)
                System.out.print("\\  ---");
            else
                System.out.print("/  ---");
        } 
              
        System.out.print(currentNode.nodeValue);
        
        this.printTree(currentNode.leftChildNode, level+1,true);
        
    }    
     public void preOrder(){
        if(this.rootNode != null){
            this.traversPreOrder(this.rootNode);
            System.out.println();
        }
            
    }    
     private void traversPreOrder(BinaryTreeCharNode currentNode){
         if(currentNode == null)
             return;
         
         System.out.print(currentNode.nodeValue +" ");
         this.traversPreOrder(currentNode.leftChildNode);
         this.traversPreOrder(currentNode.rightChildNode);
    }   
     public void postOrder(){
        if(this.rootNode != null){
            this.traversPostOrder(this.rootNode);
            System.out.println();
        }
            
    }    
     private void traversPostOrder(BinaryTreeCharNode currentNode){
         if(currentNode == null)
             return;
         
         this.traversPreOrder(currentNode.leftChildNode);
         this.traversPreOrder(currentNode.rightChildNode);
         System.out.print(currentNode.nodeValue +" ");
    }
     public void inOrder(){
        if(this.rootNode != null){
            this.traversInOrder(this.rootNode);
            System.out.println();
        }
            
    }    
     private void traversInOrder(BinaryTreeCharNode currentNode){
         if(currentNode == null)
             return;
         
         this.traversPreOrder(currentNode.leftChildNode);
         System.out.print(currentNode.nodeValue +" ");
         this.traversPreOrder(currentNode.rightChildNode);
    }     
     public void levelOrder(){
         if(this.rootNode != null)
             this.traversLevelOrder(rootNode);
         
         System.out.println();
     }     
     private void traversLevelOrder(BinaryTreeCharNode currentNode){
         Queue<BinaryTreeCharNode> currentQueue = new LinkedList<BinaryTreeCharNode>();         
         currentQueue.add(currentNode);
         
         while(!currentQueue.isEmpty()){
             currentNode = currentQueue.remove();
             System.out.print(currentNode.nodeValue +" ");
             if(currentNode.leftChildNode != null)
                currentQueue.add(currentNode.leftChildNode);
             if(currentNode.rightChildNode != null)
                 currentQueue.add(currentNode.rightChildNode);
             
             
         }
         
         
         
     }
     public void height(){
        if(this.rootNode != null)   
            System.out.println(this.getHeight(this.rootNode));
        else
            System.out.println(0);
     }     
     public int getHeight(BinaryTreeCharNode currentNode){
         
           if(currentNode == null)
               return 0;
           
           int hL = this.getHeight(currentNode.leftChildNode);
           int hR = this.getHeight(currentNode.rightChildNode);
           
           if(hL > hR)
               return hL + 1;
           else
               return hR + 1;
         
         
     }
}
