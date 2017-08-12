/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.algm.sort;
import java.util.Scanner;

/**
 *
 * @author sinukoll
 */
public class RadixSort {
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Please enter array size: ");
        int arraySize = inputScanner.nextInt();
        int[] expenditures = new int[arraySize];
        for(int tempIndex = 0 ; tempIndex < arraySize; tempIndex++){        // Asymptotic Time complexity O(n)     
             expenditures[tempIndex] = inputScanner.nextInt();            
        }
        
        RadixSort thisRadixSort = new RadixSort();
        
        int[] sortedArray = thisRadixSort.radixSortImplementation(expenditures);
        
        for(int tempIndex=0; tempIndex< sortedArray.length; tempIndex++)
            System.out.print(sortedArray[tempIndex]);
        
        
        inputScanner.close();
    }
    
    public int[] radixSortImplementation(int[] expenditures){
        RadixSortNode[] frontNode = new RadixSortNode[10];
        RadixSortNode[] rearNode = new RadixSortNode[10];
        RadixSortNode newNode, currentNode;
        
        int leastSignificant = 1;
        int mostSignificant = this.getNumberOfDigitsLargerstDigit(expenditures);
        int significantDigit = 0;
        int nonEmptySetPosition = 0;
        for(int k = leastSignificant; k<= mostSignificant; k++){  // Asymptotic Time complexity O( k * n )
            
                for(int j = 0; j< 10; j++){
                    frontNode[j] = null;  // Setting the frontNode and rearNode is null initially
                    rearNode[j] =  null; 
                }
             for(int i = 0; i < expenditures.length; i++){
                 significantDigit = this.getDigit(expenditures[i], k);
                    newNode = new RadixSortNode(expenditures[i]);
                  if(frontNode[significantDigit] == null){
                      frontNode[significantDigit] = newNode;
                  }else{
                      rearNode[significantDigit].nextNode = newNode;
                  }
                  
                  rearNode[significantDigit] = newNode;
             }
             
             nonEmptySetPosition = 0;
             while(frontNode[nonEmptySetPosition] == null) // find initial non empty set position
                nonEmptySetPosition++;
             
             for(int l= nonEmptySetPosition, tempIndex=0; l<10; l++){                 
                 if(frontNode[l] != null){
                     currentNode = frontNode[l];
                     while(currentNode != null){
                         expenditures[tempIndex++] = currentNode.nodeValue;
                         currentNode = currentNode.nextNode;
                     }                     
                 }
             }
            
            
        }
        
        
        
        return expenditures;
    }    
    public int getNumberOfDigitsLargerstDigit(int[] expenditures){
        int numberDigits = 0;
        int largestDigit = 0;
        for(int i=0; i< expenditures.length; i++){ // Asymptotic Time complexity O(n)
            if(largestDigit < expenditures[i])
                largestDigit = expenditures[i];
        }
        
        while(largestDigit > 0){
            numberDigits++;
            largestDigit = largestDigit / 10;
        }
        return numberDigits;
    }
    public int getDigit(int number, int k){
        int digit =0;
        for(int i=1; i<= k; i++){
            digit = number % 10;
            number /= 10;
        }        
        return digit;
    }
    
}
