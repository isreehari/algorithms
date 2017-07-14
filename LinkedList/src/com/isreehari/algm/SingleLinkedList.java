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
    
    
    
    
    public boolean checkListIsEmpty(){
        if(this.startNode == null){
            System.out.println("List is empty");
            return true;
        }else{
            return false;
        }
            
    }
    
    
}
