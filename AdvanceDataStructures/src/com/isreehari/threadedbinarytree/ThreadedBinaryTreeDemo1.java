/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.threadedbinarytree;

import java.util.Scanner;

/**
 *
 * @author sinukoll
 */
public class ThreadedBinaryTreeDemo1 {
      private Node root;
      
      public ThreadedBinaryTreeDemo1(){
          this.root = null;
      }
      
      public static void main(String[] args){
          Scanner inputScanner = new Scanner(System.in);
        int userChoice, nodeValue;
        
        ThreadedBinaryTreeDemo1 avlTreeDemo1 = new ThreadedBinaryTreeDemo1();
        
        while(true){
            System.out.println("1. Display Tree");
            System.out.println("2. Insert New Node");
            System.out.println("3. Delete Node");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Quit");
            System.out.print("Enter your choice : ");
            userChoice = inputScanner.nextInt();
            
            switch(userChoice){
                case 1: //ThreadedBinaryTreeDemo1.display();  break;
                case 2: System.out.println();
                        System.out.print("Please enter Node Value: ");
                        nodeValue = inputScanner.nextInt();
                       // ThreadedBinaryTreeDemo1.insert(nodeValue); break;
                case 3: //avlTreeDemo1.display();  break;
                case 4: //avlTreeDemo1.inoder(); break;                
                case 5: inputScanner.close(); System.exit(0);
            }
            
        }
      }
      
      
      public boolean isEmpty(){
          return (this.root == null);
      }
      
      private Node inorderPredecessor(Node currentNode){
          if(currentNode.leftThread == true)
              return currentNode.leftNode;
          else{
              currentNode = currentNode.leftNode;
               while(currentNode.rightThread == false){
                   currentNode = currentNode.rightNode;
               }
               
               return currentNode;
          }
      }
      
      
       private Node inorderSuccessor(Node currentNode){
          if(currentNode.rightThread == true)
              return currentNode.rightNode;
          else{
              currentNode = currentNode.rightNode;
               while(currentNode.leftThread == false){
                   currentNode = currentNode.leftNode;
               }
               
               return currentNode;
          }
      }
       
       public void inorder(){
           
           if(this.root == null){
               System.out.println("Tree is empty");
               return;
           }
           
           
           Node currentNode = this.root;
           while(currentNode.leftThread == false)
               currentNode = currentNode.leftNode;
           
           while( currentNode != null){
                System.out.print(currentNode.nodeValue + " ");
                
                if(currentNode.rightThread == true)
                    currentNode = currentNode.rightNode;
                else{
                    currentNode = currentNode.rightNode;
                       while(currentNode.leftThread == false)
                           currentNode = currentNode.leftNode;
                }
           }
           
           System.out.println();
           
           
       }
       
       
       public void insert(int newNodeValue){
           Node currentNode = this.root;
           Node parentNode = null;
           
           while(currentNode != null){
               parentNode = currentNode;
               
                if(newNodeValue < currentNode.nodeValue){
                    if(currentNode.leftThread == false)
                        currentNode = currentNode.leftNode;
                    else
                        break;
                }else if( newNodeValue > currentNode.nodeValue){
                    
                        if(currentNode.rightThread == false)
                            currentNode = currentNode.rightNode;
                        else
                            break;
                    
                }else{
                    System.out.println(" Value is already present in the tree");
                    return;
                }
               
           }
           
           Node newNode = new Node(newNodeValue);
           
           if(parentNode == null)
               this.root = newNode;
           else if(newNodeValue < parentNode.nodeValue) { // Inserted as left child               
               newNode.leftNode = parentNode.leftNode;
               newNode.rightNode = parentNode;
               parentNode.leftThread = false;
               parentNode.leftNode = newNode;               
           }else{ // Inserted as right child 
               newNode.leftNode = parentNode;
               newNode.rightNode = parentNode.rightNode;
               parentNode.rightThread = false;
               parentNode.rightNode = newNode;
           }
           
           
       }
       
       public void delete(int deleteValue){
           
           Node currentNode = this.root;
           Node parentNode = null;
           
           while( currentNode != null){
               if( deleteValue == currentNode.nodeValue){
                   break;
               }
               
               parentNode = currentNode;
               
               if(deleteValue < currentNode.nodeValue){
                     if(currentNode.leftThread == false)
                         currentNode = currentNode.leftNode;
                     else
                         break;
               }else{
                     if(currentNode.rightThread == false)
                         currentNode = currentNode.rightNode;
                     else
                         break;
               }
                   
           }
           
           if(currentNode == null || currentNode.nodeValue != deleteValue){
               System.out.println("Opps! Element is not found");
               return;
           }
           
           if(currentNode.leftThread == false && currentNode.rightThread == false){ // node has 2 children
               
               Node inOrderSuccessorParent = currentNode;
               Node inOrderSuccessor = currentNode.rightNode;
               
               while(inOrderSuccessor.leftThread == false){
                   inOrderSuccessorParent = inOrderSuccessor;
                   inOrderSuccessor = inOrderSuccessor.leftNode;
               }
               
               currentNode.nodeValue = inOrderSuccessor.nodeValue;
               currentNode = inOrderSuccessor;
               parentNode = inOrderSuccessorParent;
               
           }
           
           // Case A: No child 
           if(currentNode.leftThread == true && currentNode.rightThread == true){
               if(parentNode == null)
                   this.root = null;
               else if(currentNode == parentNode.leftNode){
                   parentNode.leftThread = true;
                   parentNode.leftNode = currentNode.leftNode;
               }else{
                   parentNode.rightThread = true;
                   parentNode.rightNode  = currentNode.rightNode;
               }
               
               return ;
           }
           
            // Case B: One child 
           Node childNode;
           
           if(currentNode.leftThread == false) // Node to deleted has left child
               childNode = currentNode.leftNode;
           else
               childNode = currentNode.rightNode;
           
           if(parentNode == null)
               this.root = childNode;
           else if( currentNode == parentNode.leftNode)
               parentNode.leftNode = childNode;
           else
               parentNode.rightNode = childNode;
           
           Node pred = this.inorderPredecessor(currentNode);
           Node succ = this.inorderPredecessor(currentNode);
           
           if(currentNode.leftThread == false)
               pred.rightNode = succ;
           else
               succ.leftNode = pred;
           
           
               
           
           
       }
       
       
       
       
       
       
      
}
