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
    
    
    public SingleLinkedList(){
            this.startNode = null; 
    }
    
    public void createNewList(Scanner userChoiceInput){
        System.out.print("Please enter how nodes you want in list: ");        
        int numberNodes = userChoiceInput.nextInt();
        int newValue;
        Node currentNode; 
        System.out.println("");
        while(numberNodes > 0){
            System.out.print("Please enter new node value:");
            newValue = userChoiceInput.nextInt();
                
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
    
    public void searchElement(Scanner userChoiceInput){
        Node currentNode; 
        int currentPosition = 1; 
        int searchElement;
        
        System.out.print("Please search element: ");
        searchElement = userChoiceInput.nextInt();            
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
    
    public void insertNodeInEmptyOrAtStart(Scanner userChoiceInput){
        System.out.print("Please enter new value: ");
        int userValue = userChoiceInput.nextInt();
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
    
    public void insertNodeAtEnd( Scanner userChoiceInput){
        
        System.out.print("Pelase enter new value:");
        int userValue = userChoiceInput.nextInt();
        
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
    
    public void insertNodeAfterSpecificNode(Scanner userChoiceInput ){
        Node currentNode; 
        Node newNode;
        int searchElement;        
        int newValue;
        System.out.print("Please enter the specific node value: ");
        searchElement = userChoiceInput.nextInt();
                
        currentNode = this.startNode;
        while(currentNode != null){
            if(searchElement == currentNode.nodeValue){
                System.out.print("Please enter new node value: ");
                newValue = userChoiceInput.nextInt();
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
    
    public void insertNodeBeforeSpecificNode(Scanner userChoiceInput){
        Node newNode;
        Node currentNode; 
        int searchElement;
        int newNodeValue;        
        System.out.print("Please enter specific node value: ");
        searchElement = userChoiceInput.nextInt();        
        currentNode = this.startNode;        
        while(currentNode != null){
            if(currentNode.nextNodeRef !=null){
                if(currentNode.nextNodeRef.nodeValue == searchElement){
                    System.out.print("Please enter new node value: ");
                    newNodeValue = userChoiceInput.nextInt();
                    newNode = new Node(newNodeValue);
                    newNode.nextNodeRef = currentNode.nextNodeRef;
                    currentNode.nextNodeRef = newNode;   
                    System.out.println("New node has been added to the list");
                    return;
                }
               
            }else if(currentNode.nodeValue == searchElement ){ // this code will handle if the element is found as first element of the list or if there is only one element in the list.
                System.out.print("Please enter new node vlaue:");
                newNodeValue = userChoiceInput.nextInt();
                newNode = new Node(newNodeValue);
                newNode.nextNodeRef = currentNode;
                this.startNode = newNode;
                System.out.println("New node has been added to the list");
                return;
            }
        }
        
        System.out.println("Opps! the specific node is not found in the list");
        
        
    }
    
    public void insertNodeOnSpecificPosition(Scanner userChoiceInput){
        Node currentNode;
        Node newNode;
        int newNodeValue;
        int currentPosition = 1; 
        int beforeCurrentPosition;
        int specificPosition;
        System.out.print("Please enter the specific position: ");
        specificPosition = userChoiceInput.nextInt();
        currentNode = this.startNode;
        while(currentNode != null){            
            if(specificPosition == 1){
                System.out.print("Please enter new node value:");
                newNodeValue = userChoiceInput.nextInt();
                newNode = new Node(newNodeValue);
                newNode.nextNodeRef = currentNode;
                this.startNode = newNode;
                System.out.print("New Node has added to list");
                return;
            }else{
                beforeCurrentPosition = currentPosition + 1; 
                if(beforeCurrentPosition  == specificPosition){
                System.out.print("Please enter new node value: ");
                newNodeValue = userChoiceInput.nextInt();
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
    
    public void deleteFirstNode(){
        Node currentNode;
        if(checkListIsEmpty())
            return;
        currentNode = this.startNode.nextNodeRef;
        this.startNode = currentNode;        
        System.out.println("First node of the list has been deleted");
    }
    
    public void deleteLastNode(){
        Node currentNode;
        if(checkListIsEmpty())
            return;
        currentNode = this.startNode;        
        while(currentNode.nextNodeRef != null){            
            currentNode = currentNode.nextNodeRef;        
        }        
        currentNode.nextNodeRef = null;        
        System.out.println("Last node of the list has been deleted");            
    }
    
    public void deleteAnyNode(Scanner userChoiceInput){
        Node currentNode; 
        int specifiedNodeValue; 
        int currentPosition = 1;
        if(checkListIsEmpty())
            return; 
        
        System.out.print("Please specifie which node you want to delete: ");
        specifiedNodeValue = userChoiceInput.nextInt();        
        currentNode = this.startNode; 
        
        while(currentNode != null){
            if(currentNode.nextNodeRef != null){
                if(currentNode.nextNodeRef.nodeValue == specifiedNodeValue){
                    currentNode.nextNodeRef = currentNode.nextNodeRef.nextNodeRef;
                    System.out.println("The specified node has been deleted from the list");
                    return ;    
                } else{ // handling if the specified node is first node with n > 1
                    if(currentPosition == 1 && currentNode.nodeValue == specifiedNodeValue){
                        currentNode = currentNode.nextNodeRef; 
                        this.startNode = currentNode;
                        System.out.println("The specified node has been deleted from the list");
                        return;
                    }
                }                
            }else{ // handling if the specified node is first node with n == 1
                if(currentPosition == 1 && currentNode.nodeValue == specifiedNodeValue){
                     currentNode = null;
                     this.startNode = currentNode;
                     System.out.println("The specified node has been deleted from the list");
                     return;
                }
            }
            
            currentPosition++;
            currentNode = currentNode.nextNodeRef;
            
            
        }
        
        System.out.println("Specified Node has not been found.");
       
        
        
        
    
    
    }
    
    public void reverseTheList(){
        Node previousNode, currentNode, nextNode;
        
        if(checkListIsEmpty())
            return;
        
        previousNode = null;
        currentNode = this.startNode;
        
        while(currentNode != null){
            nextNode = currentNode.nextNodeRef;
            currentNode.nextNodeRef = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        
        this.startNode = previousNode; 
        
        System.out.println("List has been reversed");
        
                
       
    }
    
    public void bubbleSortByData(){
        Node currentNode, nextNode, endNode; 
        int tempNodeValue;
        
        if(checkListIsEmpty())
            return; 
        
        System.out.println("********************* Bubble Sort by Value ****************************");
        System.out.print("List before bubble sort: ");
        displayList();
        //currentNode = this.startNode;        
        for(endNode = null; endNode != this.startNode.nextNodeRef; endNode = currentNode){                        
            
            for(currentNode= this.startNode; currentNode.nextNodeRef != endNode; currentNode = nextNode){              
                nextNode = currentNode.nextNodeRef;
                    if(currentNode.nodeValue > nextNode.nodeValue){
                        tempNodeValue = currentNode.nodeValue;
                        currentNode.nodeValue = nextNode.nodeValue;
                        nextNode.nodeValue = tempNodeValue;
                        
                    }                
            }
            
        }
        System.out.print("List after bubble sort: ");
        displayList();
        System.out.println("********************* / Bubble Sort Value ****************************");
        
    }
    
    
    public void bubbleSortByReference(){
        Node previousNode, currentNode, nextNode, tempNode, endNode;
        
        if(checkListIsEmpty())
            return;
        
        System.out.println("****************** Bubble Sort By Node Reference *********************************");
        System.out.print("List before sort:");
        displayList();
        
        for(endNode = null; endNode != this.startNode.nextNodeRef; endNode = currentNode){            
                for(previousNode = currentNode= this.startNode; currentNode.nextNodeRef != endNode; previousNode = currentNode, currentNode = nextNode){
                    nextNode = currentNode.nextNodeRef;
                    if(currentNode.nodeValue > nextNode.nodeValue){
                        currentNode.nextNodeRef = nextNode.nextNodeRef;
                        nextNode.nextNodeRef = currentNode;
                        if(currentNode != this.startNode)
                            previousNode.nextNodeRef = nextNode;
                        else
                            this.startNode = nextNode;
                        
                        tempNode = currentNode; 
                        currentNode = nextNode;
                        nextNode = tempNode;                        
                    }
                }
                
        }
         
        System.out.print("List after sort:");
        displayList();
        System.out.println("****************** / Bubble Sort By Node Reference *********************************");

        
    }
    
    public void mergeSortByNewList(Scanner userChoiceInput){
        SingleLinkedList list1 = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();
        SingleLinkedList mergeSortedList = new SingleLinkedList();
        
        System.out.println("Please enter first list: ");
            list1.createNewList(userChoiceInput);
            list1.bubbleSortByData();
        System.out.println("Please enter second list: ");
            list2.createNewList(userChoiceInput);
            list2.bubbleSortByData();
        
         Node mergeListLastNode;
         Node list1Node = list1.startNode;
         Node list2Node = list2.startNode;
         
         if(list1Node.nodeValue <= list2Node.nodeValue){
             mergeListLastNode = mergeSortedList.startNode = new Node(list1Node.nodeValue);
             list1Node = list1Node.nextNodeRef;             
         }else{
             mergeListLastNode = mergeSortedList.startNode = new Node(list2Node.nodeValue);
             list2Node = list2Node.nextNodeRef;
         }
         
         
         while( list1Node != null && list2Node != null){
             
                if(list1Node.nodeValue <= list2Node.nodeValue){
                    mergeListLastNode.nextNodeRef = new Node(list1Node.nodeValue);
                    list1Node = list1Node.nextNodeRef;
                }else{
                    mergeListLastNode.nextNodeRef = new Node(list2Node.nodeValue);
                    list2Node = list2Node.nextNodeRef;
                }                   
             
                mergeListLastNode = mergeListLastNode.nextNodeRef;
         }
         
         while(list1Node != null){
             mergeListLastNode.nextNodeRef = new Node(list1Node.nodeValue);
             list1Node = list1Node.nextNodeRef;                     
         }
         
         while(list2Node != null){
             mergeListLastNode.nextNodeRef = new Node(list2Node.nodeValue);
             list2Node = list2Node.nextNodeRef;
         }
         
         System.out.print("Merge Sorted ");
         mergeSortedList.displayList();            
        
    }
    
     public void mergeSortByExistingList(Scanner userChoiceInput){
        SingleLinkedList list1 = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();
        
        
        System.out.println("Please enter first list: ");
            list1.createNewList(userChoiceInput);
            list1.bubbleSortByData();
        System.out.println("Please enter second list: ");
            list2.createNewList(userChoiceInput);
            list2.bubbleSortByData();
        
         Node mergerListStartNode;   
         Node mergeListLastNode;
         Node list1Node = list1.startNode;
         Node list2Node = list2.startNode;
         
         if(list1Node.nodeValue <= list2Node.nodeValue){
             mergerListStartNode = list1.startNode;
             list1Node = list1Node.nextNodeRef;             
         }else{
             mergerListStartNode = list2.startNode;
             list2Node = list2Node.nextNodeRef;
         }
         
         mergeListLastNode = mergerListStartNode;
         
         
         while( list1Node != null && list2Node != null){
             
                if(list1Node.nodeValue <= list2Node.nodeValue){
                    mergeListLastNode.nextNodeRef = new Node(list1Node.nodeValue);
                    list1Node = list1Node.nextNodeRef;
                }else{
                    mergeListLastNode.nextNodeRef = new Node(list2Node.nodeValue);
                    list2Node = list2Node.nextNodeRef;
                }                   
             
                mergeListLastNode = mergeListLastNode.nextNodeRef;
         }
         
         while(list1Node != null){
             mergeListLastNode.nextNodeRef = new Node(list1Node.nodeValue);
             list1Node = list1Node.nextNodeRef;                     
         }
         
         while(list2Node != null){
             mergeListLastNode.nextNodeRef = new Node(list2Node.nodeValue);
             list2Node = list2Node.nextNodeRef;
         }
         
         System.out.print("Merge Sorted ");
         if(mergerListStartNode == list1.startNode)
            list1.displayList();            
         else
            list2.displayList();
        
    }
     
     public void mergeSort(){
           this.startNode = mergeSortRec(this.startNode);
     }
     
     public Node mergeSortRec(Node listStartNode){
            
         if(listStartNode == null || listStartNode.nextNodeRef == null) // if the list empty or has one element 
             return listStartNode;
         
         // if there is more than one list. 
         Node start1 = listStartNode;
         Node start2 = divideList(listStartNode);
         start1 =   mergeSortRec(start1);
         start2 =  mergeSortRec(start2);         
         Node mergedStartNode = mergeLists(start1, start2);
         
         return mergedStartNode;
     }
     
      public Node divideList(Node evenNode){
          Node oddNode = evenNode.nextNodeRef.nextNodeRef;
            
            while(oddNode != null && oddNode.nextNodeRef != null ) // oddNode == null when we have even number of elements vice varsay oddNode.nextNodeRef.nextNodeRef of odd
            {
                evenNode = evenNode.nextNodeRef;
                oddNode = oddNode.nextNodeRef.nextNodeRef;
            }
            oddNode = evenNode.nextNodeRef;
            evenNode.nextNodeRef = null;
          
          return oddNode;
      }
    
      public Node mergeLists(Node list1Node, Node list2Node){
        
         Node mergerListStartNode;   
         Node mergeListLastNode;
         
         
         if(list1Node.nodeValue <= list2Node.nodeValue){
             mergerListStartNode = list1Node;
             list1Node = list1Node.nextNodeRef;             
         }else{
             mergerListStartNode = list2Node;
             list2Node = list2Node.nextNodeRef;
         }
         
         mergeListLastNode = mergerListStartNode;
         
         
         while( list1Node != null && list2Node != null){
             
                if(list1Node.nodeValue <= list2Node.nodeValue){
                    mergeListLastNode.nextNodeRef = new Node(list1Node.nodeValue);
                    list1Node = list1Node.nextNodeRef;
                }else{
                    mergeListLastNode.nextNodeRef = new Node(list2Node.nodeValue);
                    list2Node = list2Node.nextNodeRef;
                }                   
             
                mergeListLastNode = mergeListLastNode.nextNodeRef;
         }
         
         while(list1Node != null){
             mergeListLastNode.nextNodeRef = new Node(list1Node.nodeValue);
             list1Node = list1Node.nextNodeRef;                     
         }
         
         while(list2Node != null){
             mergeListLastNode.nextNodeRef = new Node(list2Node.nodeValue);
             list2Node = list2Node.nextNodeRef;
         }
         
         return mergerListStartNode;
    }
      
    public void insertCycle(Scanner userChoiceInput){
       
        if(checkListIsEmpty())
            return;
       
        Node currentNode = this.startNode, cycleNode = null, previousNode = null;
        System.out.print("Please enter the element where you wnat make a cylce: ");
        int searchElement = userChoiceInput.nextInt();        
        while(currentNode != null){
            if(currentNode.nodeValue == searchElement)
                 cycleNode = currentNode;
            previousNode = currentNode;
            currentNode = currentNode.nextNodeRef;
        }        
        
         if(cycleNode != null)
             previousNode.nextNodeRef = cycleNode;
         else
             System.out.println(searchElement + " not present in the list");
       
        
    }
    
    
    
    public void detectCycle(){
        Node currentNode= findCycle();        
        if(currentNode == null)
            System.out.println("There is no cycle in the list");
        else
            System.out.println("There is a cycle in the list at : " + currentNode.nodeValue);
    }
    
    public Node findCycle(){
        
         if(this.startNode == null || this.startNode.nextNodeRef == null)
             return null;
         
         Node slowNode = this.startNode, fastNode = this.startNode;
         
         while(fastNode != null && fastNode.nextNodeRef != null){
             
             slowNode = slowNode.nextNodeRef;
             fastNode = fastNode.nextNodeRef.nextNodeRef;
             
             if(slowNode == fastNode)
                 return slowNode;
             
         }
        
        return null;
    }
    
    public void removeCycle(){
        Node cycliedNode = findCycle();        
        if(cycliedNode == null)
             return;
        
        System.out.println("Cycle found at: " + cycliedNode.nodeValue );
        // Finding the length of cycle
        Node mainNode = cycliedNode, loopNode = cycliedNode;
        int cycleLength = 0;
        do{
            cycleLength++;            
            loopNode = loopNode.nextNodeRef;
        }while(mainNode != loopNode);
        
        System.out.println("Length of Cycle: " + cycleLength);
         
        // Find the length of the list which is not in cylce
        mainNode = this.startNode;        
        int unCycliedLength = 0;
        
        while(mainNode != loopNode){
            unCycliedLength++;
            mainNode = mainNode.nextNodeRef;
            loopNode = loopNode.nextNodeRef.nextNodeRef;
        }        
        int totalLengthList = cycleLength + unCycliedLength - 1;
        System.out.println("Length of UnCyclied: " + unCycliedLength);
        System.out.println("Total Length of list is: " + totalLengthList);
        int lengthList = 1;
        mainNode = this.startNode;
        while(lengthList != totalLengthList){
            mainNode = mainNode.nextNodeRef;
            lengthList++;
        }
        
        mainNode.nextNodeRef = null;
        
        System.out.println("Cycle has removed from list.");
       
        
            
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
