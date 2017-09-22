/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.avltree;
import java.util.Scanner;
/**
 *
 * @author sinukoll
 */
public class AVLTreeDemo1 {
    
    private AVLNode rootNode;    
    static boolean taller;
    static boolean shoter;
    
    public AVLTreeDemo1(){
        this.rootNode = null;
    }
    
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int userChoice, nodeValue;
        
        AVLTreeDemo1 avlTreeDemo1 = new AVLTreeDemo1();
        
        while(true){
            System.out.println("1. Display Tree");
            System.out.println("2. Insert New Node");
            System.out.println("3. Delete Node");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Quit");
            System.out.print("Enter your choice : ");
            userChoice = inputScanner.nextInt();
            
            switch(userChoice){
                case 1: avlTreeDemo1.display();  break;
                case 2: System.out.println();
                        System.out.print("Please enter Node Value: ");
                        nodeValue = inputScanner.nextInt();
                        avlTreeDemo1.insert(nodeValue); break;
                case 3: avlTreeDemo1.display();  break;
                case 4: avlTreeDemo1.inoder(); break;                
                case 5: inputScanner.close(); System.exit(0);
            }
            
        }
        
        
        
        
        
    }
    
    public boolean isEmpty(){
        return this.rootNode == null;
    }
    
    public void display(){
        this.displayTree(this.rootNode, 0);
        System.out.println();
    }
    
    private void displayTree(AVLNode currentNode, int level){
        
        int i;
        
        if(currentNode == null)
            return;
        
        this.displayTree(currentNode.rightChild, level+1);
        System.out.println();
        
        for(i =0; i < level; i++)
            System.out.print("    ");
        
        System.out.print(currentNode.nodeValue);
        
        this.displayTree(currentNode.leftChild, level+1);
        
        
    }
    
    
    public void inoder(){
        this.inorderTraversal(this.rootNode);
        System.out.println();
    }
    
    private void inorderTraversal(AVLNode currentNode){
        
        if(currentNode == null)
            return;
        
        this.inorderTraversal(currentNode.leftChild);
        System.out.print(currentNode.nodeValue +" ");
        this.inorderTraversal(currentNode.rightChild);
        
        
    }
    
    public void insert(int x){
        this.rootNode = this.insert(this.rootNode,x);
    }
    
    private AVLNode insert(AVLNode currentNode, int newNodeValue){
        
            if(currentNode == null){
                currentNode = new AVLNode(newNodeValue);
                taller = true;
            }
            else
            if(currentNode.nodeValue < newNodeValue){
                currentNode.leftChild = this.insert(currentNode.leftChild, newNodeValue);
                if(taller == true)
                    currentNode = this.insertionLeftSubTreeCheck(currentNode);
            }
            else
            if(currentNode.nodeValue > newNodeValue)   
                currentNode.rightChild = this.insert(currentNode.rightChild, newNodeValue);
                if(taller == true)
                    currentNode = this.insertionRightSubTreeCheck(currentNode);
            else{
                System.out.println("Duplicate entry found.");
                taller = false;
            } 
        
        return currentNode;
    }
    
    
    public AVLNode insertionLeftSubTreeCheck(AVLNode currentNode){   
        
        switch(currentNode.balanceFactor){            
            case 0:  // Case L_1 : was balanced                 
                    currentNode.balanceFactor = 1;  // now left heavy
                    break; 
            case -1: // Case L_2 : was right heavy
                    currentNode.balanceFactor = 0;  // now balanced
                    taller = false;
                    break;
            case 1:  // Case L_3 : was left heavy       
                    currentNode = this.insertionLeftBalance(currentNode); // left balancing 
                    taller = false;
                    break;
        }
        
        
        return currentNode;
    }
    
    
    public AVLNode insertionRightSubTreeCheck(AVLNode currentNode){    
        
         switch(currentNode.balanceFactor){            
            case 0:  // Case L_1 : was balanced                 
                    currentNode.balanceFactor = -1;  // now right heavy
                    break; 
            case 1: // Case L_2 : was left heavy
                    currentNode.balanceFactor = 0;  // now balanced
                    taller = false;
                    break;
            case -1:  // Case L_3 : was righ heavy       
                    currentNode = this.insertionRightBalance(currentNode); // left balancing 
                    taller = false;
                    break;
        }
         
        return currentNode;
    }
    
    
     public AVLNode insertionLeftBalance(AVLNode currentNode){    
         
         
         AVLNode a, b;
         
         a = currentNode.leftChild;
         
         if(a.balanceFactor == 1){  // Case L_3A : Insertion in AL
             currentNode.balanceFactor = 0;
             a.balanceFactor = 0;
             currentNode = this.rotateRight(currentNode);
         }
         else{
              b = a.rightChild;
              
              switch(b.balanceFactor){ 
                  case 1: // Case L_3B2: Insertion in BL                      
                            currentNode.balanceFactor = -1 ;
                            a.balanceFactor = 0;
                            break;
                  case -1: // Case L_3B2 : Insertion in BR
                           currentNode.balanceFactor = 0;
                           a.balanceFactor = 1; 
                           break;
                  case 0:  // Case L_3B2: B is the newly inserted node                      
                           currentNode.balanceFactor = 0;
                           a.balanceFactor = 0; 
                           break;
              }
              
              b.balanceFactor = 0;
              currentNode.leftChild = this.rotateLeft(a);
              currentNode = this.rotateRight(currentNode);
              
         }
         
         
         
         
         
        return currentNode;
    }
     
      public AVLNode insertionRightBalance(AVLNode currentNode){    
        
           AVLNode a, b;
         
         a = currentNode.rightChild;
         
         if(a.balanceFactor == -1){  // Case R_3A : Insertion in AR
             currentNode.balanceFactor = 0;
             a.balanceFactor = 0;
             currentNode = this.rotateLeft(currentNode);
         }
         else{   // Case R_3B : Insertion in AL
              b = a.leftChild;
              
              switch(b.balanceFactor){ 
                  case -1: //  Insertion in BR                      
                            currentNode.balanceFactor = 1 ;
                            a.balanceFactor = 0;
                            break;
                  case 1: // Insertion in BL
                           currentNode.balanceFactor = 0;
                           a.balanceFactor = -1; 
                           break;
                  case 0:  // B is the newly inserted node                      
                           currentNode.balanceFactor = 0;
                           a.balanceFactor = 0; 
                           break;
              }
              
              b.balanceFactor = 0;
              currentNode.rightChild = this.rotateRight(a);
              currentNode = this.rotateLeft(currentNode);
              
         }
          
          
        return currentNode;
    }
      
      public AVLNode rotateRight(AVLNode currentNode){
          AVLNode a = currentNode.leftChild;
          currentNode.leftChild = a.rightChild;
          a.rightChild = currentNode;
          
          return a;
      }
      
      
       public AVLNode rotateLeft(AVLNode currentNode){
          AVLNode a = currentNode.rightChild;
          currentNode.rightChild = a.leftChild;
          a.leftChild = currentNode;
          
          return a;
      }
    
    
    
    
    
    
}
