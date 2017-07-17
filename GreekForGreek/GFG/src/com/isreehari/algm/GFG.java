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
public class GFG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TwoDimentionalSingleLinkedList  listTestCases = new TwoDimentionalSingleLinkedList();
        Scanner userInput = new Scanner(System.in);
        listTestCases.createTestCasesLinkedList(userInput);   
        listTestCases.bubbleSortByNodeData();
        listTestCases.displayTestCases();        
        userInput.close();
    }   
}

 /**
 *
 * @author sinukoll
 */
 
class TestCases {
    public Node startNode;
    public TestCases nextTestCaseRef;
    
    public TestCases(Node newTestCaseStartNode){
        this.startNode = newTestCaseStartNode;
        this.nextTestCaseRef = null;
    }
}

class Node {
    public int nodeValue;
    public Node nextNodeRef;
    public Node(int newNodeValue){
        this.nodeValue = newNodeValue;
        this.nextNodeRef = null;
    }
    
}
class TwoDimentionalSingleLinkedList {
    
    TestCases testCaseStartNode;
    
    public TwoDimentionalSingleLinkedList(){
        this.testCaseStartNode = null;
    }
    
    
    public void createTestCasesLinkedList(Scanner userInput){
        TestCases newTestCase, currentTestCase = null;
        int numberTestCases = userInput.nextInt();        
        while(numberTestCases > 0){                            
            Node newNode = createSingleLinkedList(userInput);
            newTestCase = new TestCases(newNode);
            if(this.testCaseStartNode == null){
                this.testCaseStartNode = newTestCase;
                currentTestCase = this.testCaseStartNode;
            }else{
                currentTestCase.nextTestCaseRef = newTestCase;
                currentTestCase = currentTestCase.nextTestCaseRef;
            }             
            numberTestCases--;
        }
    }
    
    public Node createSingleLinkedList(Scanner userInput){
        Node startNode = null, currentNode = null, newNode;
        int numberNodes = userInput.nextInt();
        int newNodeValue;
        
        while(numberNodes > 0){
            newNodeValue = userInput.nextInt();
            newNode = new Node(newNodeValue);
             if(startNode == null){
                 startNode = newNode;
                 currentNode = startNode;
             }                    
             else{
                 currentNode.nextNodeRef = newNode;
                 currentNode = currentNode.nextNodeRef;
             }     
            numberNodes--;
        }     
        
        return startNode;
    }
    
    public void displayTestCases(){
        TestCases currentTestCaseNode;
        Node currentNode;
         if(this.testCaseStartNode == null)
             return;
         
         currentTestCaseNode = this.testCaseStartNode;
         
         while(currentTestCaseNode != null){
                currentNode = currentTestCaseNode.startNode;
               while(currentNode != null){
                   System.out.print(currentNode.nodeValue + " ");
                   currentNode = currentNode.nextNodeRef;
               }
               System.out.println("");
             currentTestCaseNode = currentTestCaseNode.nextTestCaseRef;
         }
    }
    
    public void bubbleSortByNodeData(){
        TestCases currentTestCaseNode;
        Node startNode, currentNode, nextNode, endNode;
        int tempNodeValue;
        if(this.testCaseStartNode == null)
            return;
        
        currentTestCaseNode = this.testCaseStartNode;
        while(currentTestCaseNode != null){
            startNode = currentTestCaseNode.startNode;
             if(startNode != null)
                for(endNode = null; endNode != startNode.nextNodeRef; endNode = currentNode){                 
                    for(currentNode = startNode; currentNode.nextNodeRef != endNode; currentNode = nextNode){
                        nextNode = currentNode.nextNodeRef;                     
                        if(currentNode.nodeValue > nextNode.nodeValue){
                            tempNodeValue = nextNode.nodeValue;
                            nextNode.nodeValue = currentNode.nodeValue;
                            currentNode.nodeValue = tempNodeValue;
                        }

                    }                 
                }
             
            currentTestCaseNode = currentTestCaseNode.nextTestCaseRef;
        }
        
    }
    
    
    
    
}