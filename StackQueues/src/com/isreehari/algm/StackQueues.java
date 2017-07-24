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
public class StackQueues {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StackQueues thisStackQueues = new StackQueues();
        Scanner inputScanner = new Scanner(System.in);
        int userChoice;
        
        while(true){
            System.out.println("**************  Main Menu **************");
            System.out.println("1. Stack implementaion with Array");
            System.out.println("2. Stack implementation with Linked list");
            System.out.println("0. Quit the Application");
            System.out.println("**************  /Main Menu **************");
            System.out.print("Please enter your choice: ");
            userChoice = inputScanner.nextInt();            
            switch(userChoice){
                case 1: thisStackQueues.stackImplementationArray(inputScanner); break;
                case 0: inputScanner.close(); System.exit(0); break;
                default: System.out.println("Wrong choice"); break;
            }
        }
        
    }
    
    public void stackImplementationArray(Scanner inputScanner){
        int userChoice, newValue;
        StackArray thisStackArray = new StackArray(8);
        while(true){
              System.out.println("************** Stack implementation with Array **************");
              System.out.println("1. Push an element on the stack");
              System.out.println("2. Pop an element from the stack");
              System.out.println("3. Display the top element");
              System.out.println("4. Display all the stack elements ");
              System.out.println("5. Display size of the stack");
              System.out.println("6. Return Main Menu");
              System.out.println("0. Quit the application");
              System.out.println("************** /Stack implementation with Array **************");              
              System.out.print("Please enter your choice: ");
              userChoice = inputScanner.nextInt();
              switch(userChoice){
                  case 1:  
                           System.out.print("Please enter new value :");
                           newValue = inputScanner.nextInt();
                           thisStackArray.push(newValue); break; 
                  case 2:  thisStackArray.pop(); break;
                  case 3:  System.out.println("Peek of stack is: "+ thisStackArray.peek()); break; 
                  case 4:  thisStackArray.display(); break;
                  case 5:  System.out.println("Size of the stack is: "+ thisStackArray.size()); break;                  
                  case 6: return; 
                  case 0: System.exit(0); break; 
                  default: System.out.println("Wrong choice"); break;
              }
        }
    }
    
}
