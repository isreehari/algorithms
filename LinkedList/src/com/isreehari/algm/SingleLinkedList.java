/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.algm;
import java.util.Scanner;
/**
 *
 * @author sinukoll
 */
public class SingleLinkedList {
    private Node startNode;
    private Scanner userInput =  new Scanner(System.in);
    
    public SingleLinkedList(){
            this.startNode = null; 
    }
    
    public void createNewList(){
        System.out.print("Please enter how nodes you want in list: ");        
        int numberNodes = this.userInput.nextInt();
        int newValue;
        Node currentNode; 
        System.out.println("");
        while(numberNodes > 0){
            System.out.print("Please enter new node value:");
            newValue = this.userInput.nextInt();
                
               if(this.startNode == null)
                   this.startNode = new Node(newValue);
               else{
                   currentNode = this.startNode;
                   while(currentNode.nextNodeRef != null)
                    currentNode = currentNode.nextNodeRef;                   
                   currentNode.nextNodeRef = new Node(newValue);
               }
                   
            
            
            numberNodes--;
        }
    }
    
    public void displayList(){
        Node currentNode;
        if(this.checkListIsEmpty())
            return ;
        System.out.print("List is : [ "); 
        currentNode = this.startNode;
        while(currentNode !=null){
            System.out.print(currentNode.nodeValue);
            System.out.print(" ");
            currentNode = currentNode.nextNodeRef; 
        }
        System.out.println("]");
    }
    
    public void countNumberNodes(){
        int numberNodes = 0;
        Node currentNode;
        if(this.checkListIsEmpty())
            return; 
        
        currentNode = this.startNode;
        while(currentNode != null){
            numberNodes++;
            currentNode = currentNode.nextNodeRef;
        }        
        System.out.println("Number of nodes: " + numberNodes);                       
    }
    
    public void searchElement(){
        Node currentNode; 
        int currentPosition = 1; 
        int searchElement;
        
        System.out.print("Please search element: ");
        searchElement = this.userInput.nextInt();            
            if(this.checkListIsEmpty())
                return;
        currentNode = this.startNode; 
        while(currentNode != null){
            if(searchElement == currentNode.nodeValue){
                System.out.println("Element : " + searchElement + " has found at the position : " + currentPosition +" in the list.");                
                return; 
            }          
            currentPosition++;
            currentNode = currentNode.nextNodeRef;                
        }        
        System.out.println("Sorry, Element is not found");
    }
    
    public void insertNodeInEmptyOrAtStart(){
        System.out.print("Please enter new value: ");
        int userValue = this.userInput.nextInt();
        Node newNode = new Node(userValue);
         if(this.startNode == null)
            this.startNode = newNode; 
         else{
             newNode.nextNodeRef = this.startNode;
             this.startNode = newNode;
         }
        System.out.println("");
        System.out.println("Node has been added to list.");
    }
    
    public void insertNodeAtEnd(){
        
        System.out.print("Pelase enter new value:");
        int userValue = this.userInput.nextInt();
        
        Node newNode = new Node(userValue);
        Node currentNode;
        if(this.startNode == null){
           this.startNode = newNode;   
        }else{
             currentNode = this.startNode;        
             while(currentNode.nextNodeRef != null){
                currentNode = currentNode.nextNodeRef;
             }
             currentNode.nextNodeRef = newNode;
        }
       
        System.out.println("New node has been added");
    }
    
    public void insertNodeAfterSpecificNode(){
        Node currentNode; 
        Node newNode;
        int searchElement;        
        int newValue;
        System.out.print("Please enter the specific node value: ");
        searchElement = this.userInput.nextInt();
                
        currentNode = this.startNode;
        while(currentNode != null){
            if(searchElement == currentNode.nodeValue){
                System.out.print("Please enter new node value: ");
                newValue = this.userInput.nextInt();
                newNode = new Node(newValue);
                newNode.nextNodeRef = currentNode.nextNodeRef;
                currentNode.nextNodeRef = newNode;
                System.out.println("");
                System.out.println("New node added after node: " + searchElement);
                return;
            }
            
            currentNode = currentNode.nextNodeRef;
        }
        
        System.out.println("Opps! The specific nonde has not found");
    }
    
    public void insertNodeBeforeSpecificNode(){
        Node newNode;
        Node currentNode; 
        int searchElement;
        int newNodeValue;        
        System.out.print("Please enter specific node value: ");
        searchElement = this.userInput.nextInt();        
        currentNode = this.startNode;        
        while(currentNode != null){
            if(currentNode.nextNodeRef !=null){
                if(currentNode.nextNodeRef.nodeValue == searchElement){
                    System.out.print("Please enter new node value: ");
                    newNodeValue = this.userInput.nextInt();
                    newNode = new Node(newNodeValue);
                    newNode.nextNodeRef = currentNode.nextNodeRef;
                    currentNode.nextNodeRef = newNode;   
                    System.out.println("New node has been added to the list");
                    return;
                }
               
            }else if(currentNode.nodeValue == searchElement ){ // this code will handle if the element is found as first element of the list or if there is only one element in the list.
                System.out.print("Please enter new node vlaue:");
                newNodeValue = this.userInput.nextInt();
                newNode = new Node(newNodeValue);
                newNode.nextNodeRef = currentNode;
                this.startNode = newNode;
                System.out.println("New node has been added to the list");
                return;
            }
        }
        
        System.out.println("Opps! the specific node is not found in the list");
        
        
    }
    
    public void insertNodeOnSpecificPosition(){
        Node currentNode;
        Node newNode;
        int newNodeValue;
        int currentPosition = 1; 
        int beforeCurrentPosition;
        int specificPosition;
        System.out.print("Please enter the specific position: ");
        specificPosition = this.userInput.nextInt();
        currentNode = this.startNode;
        while(currentNode != null){            
            if(specificPosition == 1){
                System.out.print("Please enter new node value:");
                newNodeValue = this.userInput.nextInt();
                newNode = new Node(newNodeValue);
                newNode.nextNodeRef = currentNode;
                this.startNode = newNode;
                System.out.print("New Node has added to list");
                return;
            }else{
                beforeCurrentPosition = currentPosition + 1; 
                if(beforeCurrentPosition  == specificPosition){
                System.out.print("Please enter new node value: ");
                newNodeValue = this.userInput.nextInt();
                newNode = new Node(newNodeValue);
                if(currentNode.nextNodeRef == null){
                   currentNode.nextNodeRef = newNode;
                }else{
                    newNode.nextNodeRef = currentNode.nextNodeRef;
                    currentNode.nextNodeRef = newNode;
                }
                
                System.out.println("New node has been added to list");
                return; 
                
            }
            }
            
            
            currentPosition++;
            currentNode = currentNode.nextNodeRef;
        }
        
        System.out.println("Opps! The specified position is not found");
                
        
    }
    
    
    
    
    public boolean checkListIsEmpty(){
        if(this.startNode == null){
            System.out.println("List is empty");
            return true;
        }else{
            return false;
        }
            
    }
    
    
}
