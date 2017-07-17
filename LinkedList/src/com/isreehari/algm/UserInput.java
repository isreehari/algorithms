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
public class UserInput {
    
    public void takeUserInput(){
        int userChoice = 0;
        int userInput = 0;
        
        SingleLinkedList singleLinkedList = new SingleLinkedList();        
        Scanner userChoiceInput = new Scanner(System.in); 
        
        while(true){
        System.out.println("************************************************************");
        System.out.println("0. Create new list");
        System.out.println("1. Display List");
        System.out.println("2. Count the number of nodes");
        System.out.println("3. Serach for an element");
        System.out.println("4. Insert in empty list / Insert in beginning of the list");
        System.out.println("5. Insert a node at the end of the list");
        System.out.println("6. Insert a node after specified node");
        System.out.println("7. Insert a node before a specified node");
        System.out.println("8. Insert a node at a given position");
        System.out.println("9. Delete first node");
        System.out.println("10. Delete last node");
        System.out.println("11. Delete any node");
        System.out.println("12. Reverse the list");
        System.out.println("13. Bubble sort by exchanging data");
        System.out.println("14. Bubble sort by echanging links");
        System.out.println("15. MergeSort By creating new list");
        System.out.println("16. MergeSort By using existing list");
        System.out.println("17. MergeSort");
        System.out.println("18. Insert Cycle");
        System.out.println("19. Detect Cycle");
        System.out.println("20. Remove cycle");
        System.out.println("21. Quit");
        System.out.print("Enter your choice:");
        userChoice = userChoiceInput.nextInt();
        System.out.println("************************************************************");
        
        switch(userChoice){
            case 0: singleLinkedList.createNewList(userChoiceInput); break; 
            case 1: singleLinkedList.displayList(); break; 
            case 2: singleLinkedList.countNumberNodes(); break; 
            case 3: singleLinkedList.searchElement(userChoiceInput); break;
            case 4: singleLinkedList.insertNodeInEmptyOrAtStart(userChoiceInput); break;
            case 5: singleLinkedList.insertNodeAtEnd(userChoiceInput); break;           
            case 6: singleLinkedList.insertNodeAfterSpecificNode(userChoiceInput); break; 
            case 7: singleLinkedList.insertNodeBeforeSpecificNode(userChoiceInput); break;
            case 8: singleLinkedList.insertNodeOnSpecificPosition(userChoiceInput); break;
            case 9: singleLinkedList.deleteFirstNode(); break;
            case 10: singleLinkedList.deleteLastNode(); break;
            case 11: singleLinkedList.deleteAnyNode(userChoiceInput); break; 
            case 12: singleLinkedList.reverseTheList(); break;
            case 13: singleLinkedList.bubbleSortByData(); break;
            case 14: singleLinkedList.bubbleSortByReference(); break;
            case 15: singleLinkedList.mergeSortByNewList(userChoiceInput); break;
            case 16: singleLinkedList.mergeSortByExistingList(userChoiceInput); break;
            case 17: singleLinkedList.mergeSort(); break;
            case 18: singleLinkedList.insertCycle(userChoiceInput); break;
            case 19: singleLinkedList.detectCycle(); break;
            case 20: singleLinkedList.removeCycle(); break;
            case 21:  userChoiceInput.close(); System.exit(0); break; 
            default: System.out.println(userChoice); break;
        }
            
        }
        
        
    }
    
}
