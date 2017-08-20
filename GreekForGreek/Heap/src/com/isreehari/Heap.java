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
public class Heap {

      private int heapSize;
      private int heapIndex;
      private int[] heapArray;
      
      public Heap(){
          this.heapSize = 100;
          this.heapArray = new int[this.heapSize+1];
          this.heapIndex = 0;
          this.heapArray[0] = 999999;
      }
      
      public Heap(int newSize){
          this.heapSize = newSize;
          this.heapArray = new int[this.heapSize+1];
          this.heapIndex = 0;
          this.heapArray[0] = 999999;
      }
      
      
        
    /**
     * @param args the command line arguments
     */
  public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        Heap heap = new Heap(100);
        int userChoice;      
        while(true){
            System.out.println("******************* Heap *******************");
            System.out.println("*1. Insert into Heap                       *");
            System.out.println("*2. Display Heap                           *");
            System.out.println("*3. Delete Root Node in Heap               *");  
            System.out.println("*4. Build in Heap                          *");  
            System.out.println("*0. Quit the App                           *");
            System.out.println("******************* /Heap ******************");
            System.out.print("Please enter your choice: ");
            userChoice = inputScanner.nextInt();
            switch(userChoice){         
                case 1: heap.build(inputScanner); break;
                case 2: heap.display(); break;                                
                case 3: heap.deleteRoot(); break;  
                case 4: heap.buildHeap(); break;
                case 0: inputScanner.close(); System.exit(0); break;
                default: System.out.println("Your choice is wrong."); break;
            }
        }        
    }    
  
     public boolean isEmpty(){         
         return (this.heapIndex == 0);
     }
     public boolean isFull(){
         return (this.heapIndex == this.heapSize);
     }
     public void build(Scanner inputScanner){            
         
         if(this.isFull()){
            System.out.println("Opps! Heap is full");
            return;
         }
         
         System.out.print("Please enter new node value: ");
         int newValue = inputScanner.nextInt();
         
         if(newValue > this.heapArray[0])
             this.heapArray[0] = newValue;
         
         this.heapIndex++;
         this.heapArray[this.heapIndex] = newValue;
         this.heapArray = this.restoreUp(this.heapIndex, this.heapArray);
         
        }
     
     public int[] restoreUp(int currentNodeIndex, int[] currentHeapArray ){
         int newNodeValue = currentHeapArray[currentNodeIndex];         
         int currentNodeParentIndex = currentNodeIndex / 2; 
         int tempNodeValue = 0;
         
         while( currentNodeParentIndex >= 1 && newNodeValue > currentHeapArray[currentNodeParentIndex] ){                         
             currentHeapArray[currentNodeIndex] = currentHeapArray[currentNodeParentIndex];             
             currentNodeIndex = currentNodeParentIndex;
             currentNodeParentIndex = currentNodeIndex / 2;
         }
         
         currentHeapArray[currentNodeIndex] = newNodeValue;
         
         return currentHeapArray;
         
     }
          
     public void display(){           
          if(this.isEmpty()){
              System.out.println("Heap is empty");
              return;
          }
          for( int i = 1; i <= this.heapIndex; i++)
              System.out.print(this.heapArray[i] +" ");
          System.out.println();
    }  
     
     public int deleteRoot(){
         if(this.isEmpty()){
              System.out.println("Heap is empty");
              return -1;
          }
         
         int tempMax = this.heapArray[1];
         this.heapArray[1] = this.heapArray[this.heapIndex];
         this.heapIndex--;
         this.heapArray = this.restoreDown(1, this.heapArray, this.heapIndex);
         
         
         
         
         return tempMax;
         
     }
     
     public int[] restoreDown(int currentNodeIndex, int[] currentHeapArray, int currentHeapMaxIndex){
         
         int newNodeValue = currentHeapArray[currentNodeIndex];         
         int leftChildNodeIndex = 2 * currentNodeIndex; 
         int rightChildNodeIndex = leftChildNodeIndex + 1; 
        
         
         while( rightChildNodeIndex <= currentHeapMaxIndex ){    
             // case 1 if the newNodeValue is greater than left & right no action
             
             if(newNodeValue > currentHeapArray[leftChildNodeIndex] && newNodeValue > currentHeapArray[rightChildNodeIndex]){
                 currentHeapArray[currentNodeIndex] = newNodeValue;
                 return currentHeapArray;
             }else if(currentHeapArray[leftChildNodeIndex] > currentHeapArray[rightChildNodeIndex]){
                 // case 3 if the newNode Value is less than both child - replace with greater between left and right child    
                     currentHeapArray[currentNodeIndex] = currentHeapArray[leftChildNodeIndex];     
                      currentNodeIndex = leftChildNodeIndex;
                 
                 
             } else{
                     currentHeapArray[currentNodeIndex] = currentHeapArray[rightChildNodeIndex];                 
                     currentNodeIndex = rightChildNodeIndex;
                 
             }      
             leftChildNodeIndex = 2 * currentNodeIndex;
             rightChildNodeIndex = leftChildNodeIndex + 1;
         }
         
         // If number of nodes is even
         if(leftChildNodeIndex == currentHeapMaxIndex && newNodeValue < currentHeapArray[leftChildNodeIndex]){
             currentHeapArray[currentNodeIndex] = currentHeapArray[leftChildNodeIndex];
             currentNodeIndex = leftChildNodeIndex;
         }
         
         currentHeapArray[currentNodeIndex] = newNodeValue;
         
         return currentHeapArray;
         
     }
     
     public void buildHeap(){
          int a1[] = {99999,1,4,5,7,9,10};
          int n1 = a1.length - 1;
          
          a1 = this.buildHeapBottomUp(a1,n1);
          
          for(int i=1; i <= n1; i++)
              System.out.print(a1[i] + " ");
          System.out.println();
          
          int a2[] = {99999,1,4,5,7,9,10};
          int n2 = a2.length - 1;
          
          a2 = this.buildHeapTopDown(a2,n2);
          
          for(int i=1; i <= n2; i++)
              System.out.print(a2[i] + " ");
          System.out.println();
          
     }
     
     public int[] buildHeapBottomUp(int[] a2, int n2){
         for(int i= n2/2; i >= 1; i--)
             a2 = this.restoreDown(i, a2, n2);
         
         return a2;
     }
     
     public int[] buildHeapTopDown(int[] a1, int n1){
         
         
         for(int i=2; i<= n1; i++)
             a1 = this.restoreUp(i, a1);
         
         return a1;
     }
     
     
     
     
        
}
