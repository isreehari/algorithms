/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari;
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
            System.out.println("3. Queue implementation with Array");
            System.out.println("4. Queue implementation with Linked List");
            System.out.println("5. Queue implementation with Circular Linked List");
            System.out.println("6. Queue implementation with Circular Array");
            System.out.println("7. Deque implementation with Circular Array");
            System.out.println("8. Priority Queue implementation with Linked List");
            System.out.println("9. Validate Nested paranthses expression ");
            System.out.println("10. Infix to Postfix");
            System.out.println("11. Infix to Prefix");
            System.out.println("0. Quit the Application");
            System.out.println("**************  /Main Menu **************");
            System.out.print("Please enter your choice: ");
            userChoice = inputScanner.nextInt();            
            switch(userChoice){
                case 1: thisStackQueues.stackImplementationArray(inputScanner); break;
                case 2: thisStackQueues.stackImplementationLinkedList(inputScanner); break;
                case 3: thisStackQueues.queueImplementationArray(inputScanner); break;
                case 4: thisStackQueues.queueImplementationLinkedList(inputScanner); break;
                case 5: thisStackQueues.queueImplementationCircularLinkedList(inputScanner);break;
                case 6: thisStackQueues.queueImplementationCircularArray(inputScanner); break;
                case 7: thisStackQueues.dequeImplementationCircularArray(inputScanner);break;
                case 8: thisStackQueues.priorityQueueImplementationLinkedList(inputScanner); break; 
                case 9: thisStackQueues.validateExpression(inputScanner); break;
                case 10: thisStackQueues.infixToPostfix(); break;
                case 11: thisStackQueues.infixToPrefix(); break;
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
    public void stackImplementationLinkedList(Scanner inputScanner){
        int userChoice, newValue;
        StackLinkedList thisStackLinkedList = new StackLinkedList();
        while(true){
            System.out.println("************** Stack implementaion with Linked List **************");
            System.out.println("1. Push an element on the stack");
            System.out.println("2. Pop an element from the stack");
            System.out.println("3. Display the top element in the stack");    
            System.out.println("4. Display all the stack elements");
            System.out.println("5. Display size of the stack");
            System.out.println("6. Return Main Menu");                        
            System.out.println("0. Quit the application");
            System.out.println("************** /Stack implementaion with Linked List **************");
            System.out.print("Please enter your choice: ");
            userChoice = inputScanner.nextInt();
            switch(userChoice){
                case 1: System.out.print("Please enter new value: ");
                         newValue = inputScanner.nextInt();
                         thisStackLinkedList.push(newValue); break;
                case 2: thisStackLinkedList.pop(); break;
                case 3: System.out.println("Peek of the stack is : "+ thisStackLinkedList.peek()); break;
                case 4: thisStackLinkedList.displayAll(); break;
                case 5: System.out.println("Size of the stack is : "+thisStackLinkedList.size()); break;
                case 6: return;
                case 0: System.exit(0); break;
                default: System.out.println("Wrong choice");                         
            }
        }
    }
    public void queueImplementationArray(Scanner inputScanner){
        int userChoice, newValue;
        QueueArray thisQueueArray = new QueueArray(10);
        while(true){
              System.out.println("************** Queue implementation with Array **************");
              System.out.println("1. Insert an element on the queue");
              System.out.println("2. Delete an element from the queue");
              System.out.println("3. Display the front element in queue");
              System.out.println("4. Display all the elements in the queue");
              System.out.println("5. Display size of the queue");
              System.out.println("6. Return Main Menu");
              System.out.println("0. Quit the application");
              System.out.println("************** /Stack implementation with Array **************");              
              System.out.print("Please enter your choice: ");
              userChoice = inputScanner.nextInt();
              switch(userChoice){
                  case 1:  
                           System.out.print("Please enter new value :");
                           newValue = inputScanner.nextInt();
                           thisQueueArray.insert(newValue); break; 
                  case 2:  thisQueueArray.delete(); break;
                  case 3:  System.out.println("Peek of queue is: "+ thisQueueArray.peek()); break; 
                  case 4:  
                           if(thisQueueArray.isEmpty()){                               
                               System.out.print("Opps! The Queue is empty."); 
                           }else{
                                System.out.print("The Queue is: ["); 
                                thisQueueArray.display(); 
                                System.out.print("]\n");
                           }
                           
                           break;
                  case 5:  System.out.println("Size of the queue is: "+ thisQueueArray.size()); break;                  
                  case 6: return; 
                  case 0: System.exit(0); break; 
                  default: System.out.println("Wrong choice"); break;
              }
        }
        
    }
    public void queueImplementationLinkedList(Scanner inputScanner){
        int userChoice, newValue;
        QueueLinkedList thisQueueLinkedList = new QueueLinkedList();
        while(true){
              System.out.println("************** Queue implementation with Linked List **************");
              System.out.println("1. Insert an element on the queue");
              System.out.println("2. Delete an element from the queue");
              System.out.println("3. Display the front element in queue");
              System.out.println("4. Display all the elements in the queue");
              System.out.println("5. Display size of the queue");
              System.out.println("6. Return Main Menu");
              System.out.println("0. Quit the application");
              System.out.println("************** /Stack implementation with Linked List **************");              
              System.out.print("Please enter your choice: ");
              userChoice = inputScanner.nextInt();
              switch(userChoice){
                  case 1:  
                           System.out.print("Please enter new value :");
                           newValue = inputScanner.nextInt();
                           thisQueueLinkedList.insert(newValue); break; 
                  case 2:   if(thisQueueLinkedList.isEmpty()){
                                    System.out.println("Opp! Queue is underflow");
                            }else{
                                thisQueueLinkedList.delete(); 
                                System.out.println("Element has been deleted"); 
                            }
                            break;
                      
                  case 3:   if(thisQueueLinkedList.isEmpty()){
                                  System.out.println("Opps! Queue is underflow");
                              }else{
                                  System.out.println("Peek of queue is: "+ thisQueueLinkedList.peek());
                              }
                                 break; 
                  case 4:  
                           if(thisQueueLinkedList.isEmpty()){                               
                               System.out.print("Opps! The Queue is empty."); 
                           }else{
                                System.out.print("The Queue is: [");                                
                                thisQueueLinkedList.display(); 
                                System.out.print(" ]\n");
                           }                           
                           break;
                  case 5:   if(thisQueueLinkedList.isEmpty()){
                                System.out.println("Opps! Queue is empty");
                            }else{
                                System.out.println("Size of the queue is: "+ thisQueueLinkedList.size()); break;                  
                            }
                            
                      
                  case 6: return; 
                  case 0: System.exit(0); break; 
                  default: System.out.println("Wrong choice"); break;
              }
        }
        
    }
    public void queueImplementationCircularLinkedList(Scanner inputScanner){
          int userChoice, newValue;
        QueueCircularLinkedList thisQueueCircularLinkedList = new QueueCircularLinkedList();
        while(true){
              System.out.println("************** Queue implementation with Linked List **************");
              System.out.println("1. Insert an element on the queue");
              System.out.println("2. Delete an element from the queue");
              System.out.println("3. Display the front element in queue");
              System.out.println("4. Display all the elements in the queue");
              System.out.println("5. Display size of the queue");
              System.out.println("6. Return Main Menu");
              System.out.println("0. Quit the application");
              System.out.println("************** /Stack implementation with Linked List **************");              
              System.out.print("Please enter your choice: ");
              userChoice = inputScanner.nextInt();
              switch(userChoice){
                  case 1:  
                           System.out.print("Please enter new value :");
                           newValue = inputScanner.nextInt();
                           thisQueueCircularLinkedList.insert(newValue); break; 
                  case 2:   if(thisQueueCircularLinkedList.isEmpty()){
                                    System.out.println("Opp! Queue is underflow");
                            }else{
                                thisQueueCircularLinkedList.delete(); 
                                System.out.println("Element has been deleted"); 
                            }
                            break;
                      
                  case 3:   if(thisQueueCircularLinkedList.isEmpty()){
                                  System.out.println("Opps! Queue is underflow");
                              }else{
                                  System.out.println("Peek of queue is: "+ thisQueueCircularLinkedList.peek());
                              }
                                 break; 
                  case 4:  
                           if(thisQueueCircularLinkedList.isEmpty()){                               
                               System.out.print("Opps! The Queue is empty."); 
                           }else{
                                System.out.print("The Queue is: ["); 
                                thisQueueCircularLinkedList.display(); 
                                System.out.print("]\n");
                           }                           
                           break;
                  case 5:   if(thisQueueCircularLinkedList.isEmpty()){
                                System.out.println("Opps! Queue is empty");
                            }else{
                                System.out.println("Size of the queue is: "+ thisQueueCircularLinkedList.size()); break;                  
                            }
                            
                      
                  case 6: return; 
                  case 0: System.exit(0); break; 
                  default: System.out.println("Wrong choice"); break;
              }
        }
        
    }
    public void queueImplementationCircularArray(Scanner inputScanner){
        int userChoice, newValue;
        QueueCircularArray thisQueueCircularArray = new QueueCircularArray(4);
        while(true){
              System.out.println("************** Queue implementation with Array **************");
              System.out.println("1. Insert an element on the queue");
              System.out.println("2. Delete an element from the queue");
              System.out.println("3. Display the front element in queue");
              System.out.println("4. Display all the elements in the queue");
              System.out.println("5. Display size of the queue");
              System.out.println("6. Return Main Menu");
              System.out.println("0. Quit the application");
              System.out.println("************** /Stack implementation with Array **************");              
              System.out.print("Please enter your choice: ");
              userChoice = inputScanner.nextInt();
              switch(userChoice){
                  case 1:  
                           System.out.print("Please enter new value :");
                           newValue = inputScanner.nextInt();
                           thisQueueCircularArray.insert(newValue); break; 
                  case 2:  thisQueueCircularArray.delete(); break;
                  case 3:  System.out.println("Peek of queue is: "+ thisQueueCircularArray.peek()); break; 
                  case 4:  
                           if(thisQueueCircularArray.isEmpty()){                               
                               System.out.print("Opps! The Queue is empty."); 
                           }else{
                                System.out.print("The Queue is: ["); 
                                thisQueueCircularArray.display(); 
                                System.out.print("]\n");
                           }
                           
                           break;
                  case 5:  System.out.println("Size of the queue is: "+ thisQueueCircularArray.size()); break;                  
                  case 6: return; 
                  case 0: System.exit(0); break; 
                  default: System.out.println("Wrong choice"); break;
              }
        }
        
    }
    public void dequeImplementationCircularArray(Scanner inputScanner){
        int userChoice, newValue;
        DequeCircularArray thisDequeCircularArray = new DequeCircularArray(6);
        while(true){
              System.out.println("************** Queue implementation with Array **************");
              System.out.println("1. Insert an element on the deque at front");
              System.out.println("2. Insert an element on the deque at rear");
              System.out.println("3. Delete an element from the deque at front");
              System.out.println("4. Delete an element from the deque at rear");
              System.out.println("5. Display the front element in Deque");
              System.out.println("6. Display all the elements in the Deque");
              System.out.println("7. Display size of the Deque");
              System.out.println("8. Return Main Menu");
              System.out.println("0. Quit the application");
              System.out.println("************** /Stack implementation with Array **************");              
              System.out.print("Please enter your choice: ");
              userChoice = inputScanner.nextInt();
              switch(userChoice){
                  case 1:  
                           System.out.print("Please enter new value :");
                           newValue = inputScanner.nextInt();
                           thisDequeCircularArray.insertFront(newValue); break; 
                           
                  case 2:  
                           System.out.print("Please enter new value :");
                           newValue = inputScanner.nextInt();
                           thisDequeCircularArray.insertRear(newValue); break;                            
                  case 3:  thisDequeCircularArray.deleteFront(); break;
                  case 4:  thisDequeCircularArray.deleteRear(); break;
                  case 5:  System.out.println("Peek of queue is: "+ thisDequeCircularArray.peek()); break; 
                  case 6:  
                           if(thisDequeCircularArray.isEmpty()){                               
                               System.out.print("Opps! The Queue is empty."); 
                           }else{
                                System.out.print("The Queue is: ["); 
                                thisDequeCircularArray.display(); 
                                System.out.print("]\n");
                           }
                           
                           break;
                  case 7:  System.out.println("Size of the queue is: "+ thisDequeCircularArray.size()); break;                  
                  case 8: return; 
                  case 0: System.exit(0); break; 
                  default: System.out.println("Wrong choice"); break;
              }
        }
        
    }
    public void priorityQueueImplementationLinkedList(Scanner inputScanner){
      int userChoice, newValue,newNodePriority;
        PriorityQueueLinkedList thisPriorityQueueLinkedList = new PriorityQueueLinkedList();
        while(true){
              System.out.println("************** Queue implementation with Linked List **************");
              System.out.println("1. Insert an element on the queue");
              System.out.println("2. Delete an element from the queue");
              System.out.println("3. Display the front element in queue");
              System.out.println("4. Display all the elements in the queue");
              System.out.println("5. Display size of the queue");
              System.out.println("6. Return Main Menu");
              System.out.println("0. Quit the application");
              System.out.println("************** /Stack implementation with Linked List **************");              
              System.out.print("Please enter your choice: ");
              userChoice = inputScanner.nextInt();
              switch(userChoice){
                  case 1:  
                           System.out.print("Please enter new value :");
                           newValue = inputScanner.nextInt();
                           System.out.print("Please enter priority: ");
                           newNodePriority = inputScanner.nextInt();
                           thisPriorityQueueLinkedList.insert(newValue,newNodePriority); break; 
                  case 2:   if(thisPriorityQueueLinkedList.isEmpty()){
                                    System.out.println("Opp! Queue is underflow");
                            }else{
                                thisPriorityQueueLinkedList.delete(); 
                                System.out.println("Element has been deleted"); 
                            }
                            break;
                      
                  case 3:   if(thisPriorityQueueLinkedList.isEmpty()){
                                  System.out.println("Opps! Queue is underflow");
                              }else{
                                  System.out.println("Peek of queue is: "+ thisPriorityQueueLinkedList.peek());
                              }
                                 break; 
                  case 4:  
                           if(thisPriorityQueueLinkedList.isEmpty()){                               
                               System.out.print("Opps! The Queue is empty."); 
                           }else{
                                System.out.println("The Queue is:"); 
                                System.out.println("Element\tPriority");
                                thisPriorityQueueLinkedList.display(); 
                                System.out.println();
                           }                           
                           break;
                  case 5:   if(thisPriorityQueueLinkedList.isEmpty()){
                                System.out.println("Opps! Queue is empty");
                            }else{
                                System.out.println("Size of the queue is: "+ thisPriorityQueueLinkedList.size()); break;                  
                            }
                            
                      
                  case 6: return; 
                  case 0: System.exit(0); break; 
                  default: System.out.println("Wrong choice"); break;
              }
        }  
    }
    public void validateExpression(Scanner inputScanner){
        System.out.print("Please enter the expression: ");
        Scanner newInputScanner = new Scanner(System.in);
        String inputExpression = newInputScanner.nextLine();
        ValidityExpression thisValidityExpression = new ValidityExpression();
        if(thisValidityExpression.isValid(inputExpression))
            System.out.println("Vaild");
        else
            System.out.println("In-Valid");
        
        //newInputScanner.close();
                
    }
    public void infixToPostfix(){
          System.out.print("Please enter the expressin: ");
          Scanner newInputScanner = new Scanner(System.in);
          String inputExpression =  newInputScanner.nextLine();
          PolishNotation thisPolishNotation = new PolishNotation();
          String postfix = thisPolishNotation.infixToPostFix(inputExpression);
          long postfixEvaluationResult = 0;
           if(postfix.isEmpty())
               System.out.println("Opps! Something went wrong");
           else{
               System.out.println("Postfix expression: " + postfix);
              // postfixEvaluationResult = thisPolishNotation.evaluatePostfixExpression(postfix);
               //System.out.println("Postfix evaluation result: " + postfixEvaluationResult);
           }
    }
    
    public void infixToPrefix(){
        System.out.print("Please enter the expressin: ");
          Scanner newInputScanner = new Scanner(System.in);
          String inputExpression =  newInputScanner.nextLine();
          PolishNotation thisPolishNotation = new PolishNotation();
          String prefix = thisPolishNotation.infixToPrefix(inputExpression);
          long prefixEvaluationResult = 0;
           if(prefix.isEmpty())
               System.out.println("Opps! Something went wrong");
           else{
               System.out.println("Prefix expression: " + prefix);
               prefixEvaluationResult = thisPolishNotation.evaluatePrefixExpression(prefix);
               System.out.println("Prefix evaluation result: " + prefixEvaluationResult);
           }
    }
    
}
