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
public class DoubleLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Operations doubleLinkedListOps = new Operations();        
        Scanner inputScanner = new Scanner(System.in);
        int userChoice;
        
        while(true){
            System.out.println("0. Create new list");
            System.out.println("1. Display list");
            System.out.println("2. Count the number of nodes");
            System.out.println("3. Search for an element");
            System.out.println("4. Insert in empty list / Insert in begining of the list");
            System.out.println("5. Insert a node at the end of the list");
            System.out.println("6. Insert a node after a sepcified node");
            System.out.println("7. Insert a node before a specified node");
            System.out.println("8. Insert a node at a given position");
            System.out.println("9. Delete first node");
            System.out.println("10. Delete last node");
            System.out.println("11. Delete any node");
            System.out.println("12. Reverse the list");
            System.out.println("13. Bubble sort by exchaning data");
            System.out.println("14. Bubble sort by exchaning links");
            System.out.println("15. Mergesort");
            System.out.println("16. Insert Cycle");
            System.out.println("17. Detect Cycle");
            System.out.println("18. Remove Cycle");
            System.out.println("19. Quit");
            System.out.print("Please enter your choice: ");
            userChoice = inputScanner.nextInt();
            switch(userChoice){
                case 0: doubleLinkedListOps.createNewList(inputScanner); break;
                case 1: doubleLinkedListOps.displayList(); break;
                case 2: doubleLinkedListOps.countNumberOfNodes(); break;
                case 3: doubleLinkedListOps.searchElement(inputScanner); break;
                case 4: doubleLinkedListOps.insertNodeToEmptyListOrBeginning(inputScanner); break;
                case 5: doubleLinkedListOps.insertNodeAtEndList(inputScanner);break;
                case 6: doubleLinkedListOps.insertNodeAfterSpecifiedNode(inputScanner); break;
                case 7: doubleLinkedListOps.insertNodeBeforeSpecifiedNode(inputScanner); break;
                case 8: doubleLinkedListOps.insertNodeSpecifiedPosition(inputScanner);  break;
                case 19: System.exit(0); break;
                default: System.out.println("Please chose the valid choice."); break;
            }
            
            
            
            
            
        }
        
        
        
        
        
        
    }
    
}
