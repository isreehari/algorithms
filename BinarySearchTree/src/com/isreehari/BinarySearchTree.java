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
public class BinarySearchTree {    
    private BinarySearchTreeNode rootNode;    
    public BinarySearchTree(){
        this.rootNode = null;
    }    
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int userChoice;
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        while(true){
            System.out.println("******************* Binary Search Tree *******************");
            System.out.println("*1. Build New Binary Search Tree                         *");
            System.out.println("*2. Display Binary Search Tree                           *");
            System.out.println("*3. Pre Order Travers                                    *");
            System.out.println("*4. In Order Travers                                     *");
            System.out.println("*5. Post Order Travers                                   *");
            System.out.println("*6. Level Order Travers                                  *");
            System.out.println("*7. Height of Binary Search Tree                         *");
            System.out.println("*8. Search a element in Binary Search Tree               *");
            System.out.println("*9. Search a minimum element in Binary Search Tree       *");
            System.out.println("*10. Search a Maximum element in Binary Search Tree      *");
            System.out.println("*11. Delete element in Binary Search Tree                *");
            System.out.println("*0. Quit the App                                         *");
            System.out.println("******************* /Binary Search Tree ******************");
            System.out.print("Please enter your choice: ");
            userChoice = inputScanner.nextInt();
            switch(userChoice){         
                case 1: binarySearchTree.build(inputScanner); break;
                case 2: binarySearchTree.display(); break;
                case 3: binarySearchTree.preOrder();break;
                case 4: binarySearchTree.inOrder(); break;
                case 5: binarySearchTree.postOrder(); break;
                case 6: binarySearchTree.levelOrder(); break;
                case 7: binarySearchTree.height(); break;
                case 8: binarySearchTree.search(inputScanner); break;       
                case 9: binarySearchTree.getMimimumValue(binarySearchTree.rootNode); break;       
                case 10: binarySearchTree.getMaximumValue(binarySearchTree.rootNode); break;  
                case 11: binarySearchTree.delete(inputScanner); break;  
                case 0: inputScanner.close(); System.exit(0); break;
                default: System.out.println("Your choice is wrong."); break;
            }
        }        
    }    
     public void build(Scanner inputScanner){
        int userChoice;
        int newNodeValue;
        BinarySearchTreeNode currentNode, newNode;        
        while(true){                
                    System.out.println("1. Do you want add new node?");                    
                    System.out.println("0. Return main menu");
                    System.out.print("Please Enter your choice: ");
                    userChoice = inputScanner.nextInt();                    
                    
                    
                     if(userChoice ==  0){
                         return;
                     }else if (userChoice == 1){
                         System.out.print("Please enter Node Value:");                         
                         newNodeValue = inputScanner.nextInt();
                         newNode = new BinarySearchTreeNode(newNodeValue);
                          if(this.rootNode == null)
                              this.rootNode = newNode;
                          else
                              this.addNewNodeTree(this.rootNode, newNode);
                     }
                }
    }  
     private void addNewNodeTree(BinarySearchTreeNode currentNode, BinarySearchTreeNode newNode){
        
           if(currentNode == null){                                 
                  return;
           }
           
           if(currentNode.nodeValue > newNode.nodeValue){
               if(currentNode.leftChildNode == null)
                   currentNode.leftChildNode = newNode;
               else
                   this.addNewNodeTree(currentNode.leftChildNode, newNode);
           }else if(currentNode.nodeValue < newNode.nodeValue) {
               if(currentNode.rightChildNode == null){
                   currentNode.rightChildNode = newNode;
               }else
               this.addNewNodeTree(currentNode.rightChildNode, newNode);
           }else{
               System.out.println("There is already node exist with " + newNode.nodeValue + ", Duplicate entry not allowed.");
           }
               
           
           
    }     
     public void display(){
       if(this.rootNode != null){
            this.printTree(this.rootNode, 0,false);
            System.out.println();
       }           
    }    
     private void printTree(BinarySearchTreeNode currentNode, int level, boolean isItLeft){
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
     private void traversPreOrder(BinarySearchTreeNode currentNode){
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
     private void traversPostOrder(BinarySearchTreeNode currentNode){
         if(currentNode == null)
             return;
         
         this.traversPostOrder(currentNode.leftChildNode);
         this.traversPostOrder(currentNode.rightChildNode);
         System.out.print(currentNode.nodeValue +" ");
    }
     public void inOrder(){
        if(this.rootNode != null){
            this.traversInOrder(this.rootNode);
            System.out.println();
        }
            
    }    
     private void traversInOrder(BinarySearchTreeNode currentNode){
         if(currentNode == null)
             return;
         
         this.traversInOrder(currentNode.leftChildNode);
         System.out.print(currentNode.nodeValue +" ");
         this.traversInOrder(currentNode.rightChildNode);
    }     
     public void levelOrder(){
         if(this.rootNode != null)
             this.traversLevelOrder(rootNode);
         
         System.out.println();
     }     
     private void traversLevelOrder(BinarySearchTreeNode currentNode){
         Queue<BinarySearchTreeNode> currentQueue = new LinkedList<BinarySearchTreeNode>();         
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
     public int getHeight(BinarySearchTreeNode currentNode){
         
           if(currentNode == null)
               return 0;
           
           int hL = this.getHeight(currentNode.leftChildNode);
           int hR = this.getHeight(currentNode.rightChildNode);
           
           if(hL > hR)
               return hL + 1;
           else
               return hR + 1;
         
         
     }
     public void search(Scanner inputScanner){
         if(this.rootNode == null){
             System.out.println("Opps! Tree is empty");
         }else{
             System.out.print("Please enter search value: ");
             this.findElement( this.rootNode, inputScanner.nextInt());
         }
             
     }     
     private void findElement(BinarySearchTreeNode currentNode, int searchValue){
          if(currentNode == null){
              System.out.println("Opps! Element is not found in the Binary Search Tree");
              return;
          }
          
          
          if(currentNode.nodeValue > searchValue){
              this.findElement(currentNode.leftChildNode, searchValue);
          }else if(currentNode.nodeValue < searchValue){
              this.findElement(currentNode.rightChildNode, searchValue);
          }else if(currentNode.nodeValue == searchValue){
              System.out.println( searchValue + " Element is found in the Binary Serach Tree");
          }
              
          
     }
     public void getMimimumValue(BinarySearchTreeNode currentNode){
         
         if(currentNode == null){
            System.out.println("Opps! Element is not found in the Binary Search Tree");
            return;
         }
         
          if(currentNode.leftChildNode == null){
              System.out.println( currentNode.nodeValue +  " Element is maximum value int the Binary Search Tree");
          }else
              this.getMaximumValue(currentNode.leftChildNode);
     }     
     public void getMaximumValue(BinarySearchTreeNode currentNode){
          
          if(currentNode == null){
            System.out.println("Opps! Element is not found in the Binary Search Tree");
            return;            
         }
          
          
          if(currentNode.rightChildNode == null){
              System.out.println( currentNode.nodeValue +  " Element is maximum value int the Binary Search Tree");
          }else
              this.getMaximumValue(currentNode.rightChildNode);
              
          
     }     
     public void delete(Scanner inputScanner){
      if(this.rootNode == null){
             System.out.println("Opps! Tree is empty");
         }else{
             System.out.print("Please enter search value: ");
             this.deleteNode(null, this.rootNode, inputScanner.nextInt());
         }    
     }     
     private void deleteNode(BinarySearchTreeNode parentNode, BinarySearchTreeNode currentNode, int deleteNode){
         
         if(currentNode == null){
              System.out.println("Opps! Element is not found in the Binary Search Tree");
              return;
          }
          
          
          if(currentNode.nodeValue > deleteNode){
              parentNode = currentNode;
              this.deleteNode(parentNode, currentNode.leftChildNode, deleteNode);
          }else if(currentNode.nodeValue < deleteNode){
              parentNode = currentNode;
              this.deleteNode(parentNode, currentNode.rightChildNode, deleteNode);
          }else if(currentNode.nodeValue == deleteNode){
              
              //parentNode = currentNode;
              // Case A : If the node does not have child nodes
              if(currentNode.leftChildNode == null && currentNode.rightChildNode == null){   
                  
                      if(parentNode == null){
                          this.rootNode = null;
                      }else{
                             if(parentNode.leftChildNode == currentNode)
                                    parentNode.leftChildNode  = null;
                                else
                                    parentNode.rightChildNode = null;
                      }
                  
                  
                     
              }else if(currentNode.leftChildNode != null && currentNode.rightChildNode != null){ // Case C: If the node has to child nodes
                       
                        BinarySearchTreeNode inOrderSuccerNode = null, inOrderSuccerNodeParent = null;
                        inOrderSuccerNode = currentNode.rightChildNode;

                        while(inOrderSuccerNode.leftChildNode != null){
                            inOrderSuccerNodeParent = inOrderSuccerNode;
                            inOrderSuccerNode = inOrderSuccerNode.leftChildNode;
                        }                  
                        currentNode.nodeValue = inOrderSuccerNode.nodeValue;   
                        if(inOrderSuccerNodeParent == null)
                            currentNode.rightChildNode = null;
                        else
                            this.deleteNode(inOrderSuccerNodeParent, inOrderSuccerNode, inOrderSuccerNode.nodeValue);
                  
              }else{ // case B: If the node has only one child node
                  
                  if(parentNode == null){
                      if(currentNode.leftChildNode == null)
                          this.rootNode = currentNode.rightChildNode;
                          else
                          this.rootNode = currentNode.leftChildNode;
                      }else{                  
                        if(currentNode.leftChildNode == null)
                            parentNode.rightChildNode  = currentNode.rightChildNode;
                        else
                            parentNode.leftChildNode  = currentNode.leftChildNode;
                  }
              }
              
              
              
              
          }
         
         
     }
     
     
     
}
