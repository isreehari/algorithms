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
public class Operations {
      public Node startNode;      
      public Operations(){
            this.startNode = null;
      }
      
      public void createNewList(Scanner inputScanner){
          Node currentNode, newNode;
          int numberNodes;
          int newNodeValue;
          System.out.print("Please enter number of nodes: ");
          numberNodes = inputScanner.nextInt();
          while(numberNodes > 0){              
              System.out.print("Please enter node value: ");
              newNodeValue = inputScanner.nextInt();
              
                 newNode = new Node(newNodeValue);
                 
                 if(this.startNode == null)
                     this.startNode = newNode;
                 else{                     
                     currentNode = this.startNode;
                     
                     while(currentNode != null){
                        currentNode = currentNode.nextNode;
                     }
                     
                     newNode.previousNode = currentNode;
                     currentNode.nextNode = newNode;                     
                 }
              
              numberNodes--;
          }
      }
      
      
      public void displayList(){
          Node currentNode;
           if(this.startNode == null){
               System.out.println("List is empty");
               return;
           }
           
           currentNode = this.startNode;
           System.out.print("[");
           while(currentNode != null){
               System.out.print(currentNode.nodeValue);
               System.out.print(" ");
           }
           System.out.print("]");
           System.out.println(" ");
      } 
      
      
      public void searchElement(Scanner inputScanner){
          Node currentNode;
          int searchNodeValue;
          
          if(this.startNode == null){
                System.out.println("List is empty");
                return;
          }
          
          System.out.print("Please enter node value which you want to search: ");
          searchNodeValue = inputScanner.nextInt();
          
          currentNode = this.startNode;
          while(currentNode != null){
              if(currentNode.nodeValue == searchNodeValue){
                  System.out.println(searchNodeValue + " has found in the list");
                  return;
              }
          }
          
          System.out.println(searchNodeValue + " node element is not found in the list");
      }
      
      public void insertNodeToEmptyListOrBeginning(Scanner inputScanner){
          Node newNode;
          int newNodeValue;
          System.out.print("Please enter new node value:");
          newNodeValue = inputScanner.nextInt();
          newNode = new Node(newNodeValue);
          
          if(this.startNode == null)
              this.startNode = newNode;
          else{              
              newNode.nextNode = this.startNode;
              this.startNode.previousNode = newNode;
              this.startNode = newNode;
          }
              
          
      }
      
      public void insertNodeAtEndList(Scanner inputScanner){
          Node newNode, currentNode;
          int newNodeValue;
          
          System.out.print("Please enter new node value : ");
          newNodeValue = inputScanner.nextInt();
          
          newNode = new Node(newNodeValue);
          
          if(this.startNode == null){
                this.startNode = newNode;                
          }          
          else{
                currentNode = this.startNode;
                while(currentNode != null){
                    currentNode = currentNode.nextNode;
                }

                newNode.previousNode = currentNode;
                currentNode.nextNode = newNode;
          }          
          System.out.println(newNodeValue +" new node has been inserted at the end of list.");              
      }
      
      public void insertNodeAfterSpecifiedNode(Scanner inputScanner){
          Node currentNode, newNode;
          int newNodeValue, searchNodeValue;            
          if(this.startNode ==  null){
              System.out.println("List is empty");
              return;
          }
          
          currentNode = this.startNode;
          System.out.print("Please enter search node value:");
          searchNodeValue = inputScanner.nextInt();
          
          while(currentNode != null){
              if(searchNodeValue == currentNode.nodeValue){
                  System.out.print("Please enter new node value:");
                  newNodeValue = inputScanner.nextInt();
                  newNode = new Node(newNodeValue);
                  
                  newNode.nextNode = currentNode.nextNode;
                  newNode.previousNode = currentNode;
                  currentNode.nextNode.previousNode = newNode;
                  currentNode.nextNode = newNode;
                  System.out.println("New node has been added to list");
                  return;
              }
          }
          
          System.out.println(searchNodeValue + " node has not found in the list");
              
            
          
      }
      
      public void insertNodeBeforeSpecifiedNode(Scanner inputScanner){
          Node currentNode, newNode;
          int newNodeValue, searchNodeValue;            
          if(this.startNode ==  null){
              System.out.println("List is empty");
              return;
          }
          
          currentNode = this.startNode;
          System.out.print("Please enter search node value:");
          searchNodeValue = inputScanner.nextInt();
          
          while(currentNode != null){
              if(searchNodeValue == currentNode.nodeValue){
                  System.out.print("Please enter new node value:");
                  newNodeValue = inputScanner.nextInt();
                  newNode = new Node(newNodeValue);
                  
                  newNode.nextNode = currentNode;
                  newNode.previousNode = currentNode.previousNode;                   
                  currentNode.previousNode.nextNode = newNode;
                  currentNode.previousNode = newNode;
                  System.out.println("New node has been added to list");
                  return;
              }
          }
          
          System.out.println(searchNodeValue + " node has not found in the list");
              
            
          
      }
      
      
      public void insertNodeSpecifiedPosition(Scanner inputScanner){
          Node currentNode, newNode;
          int newNodeValue, searchNodeValue;            
          if(this.startNode ==  null){
              System.out.println("List is empty");
              return;
          }
          
          currentNode = this.startNode;
          System.out.print("Please enter search node value:");
          searchNodeValue = inputScanner.nextInt();
          
          while(currentNode != null){
              if(searchNodeValue == currentNode.nodeValue){
                  System.out.print("Please enter new node value:");
                  newNodeValue = inputScanner.nextInt();
                  newNode = new Node(newNodeValue);
                  
                  newNode.nextNode = currentNode;
                  newNode.previousNode = currentNode.previousNode;                   
                  currentNode.previousNode.nextNode = newNode;
                  currentNode.previousNode = newNode;
                  System.out.println("New node has been added to list");
                  return;
              }
          }
          
          System.out.println(searchNodeValue + " node has not found in the list");
              
            
          
      }
      
      
    
}
