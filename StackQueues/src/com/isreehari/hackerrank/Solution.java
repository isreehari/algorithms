/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 *
 * @author sinukoll
 */


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] expenditure = new int[n];
        for(int expenditure_i = 0; expenditure_i < n; expenditure_i++){
            expenditure[expenditure_i] = in.nextInt();
        }
        Solution thisSolution = new Solution();
        int result = thisSolution.activityNotifications(expenditure, d);
        System.out.println(result);
        in.close();
    }
    public int activityNotifications(int[] expenditure, int d) {
        // Complete this function
            if(expenditure.length < 0 || d >= expenditure.length){
                 return 0;
             }  
        
          double median = 0.0;          
          int numberNotifications = 0;
          for(int i = 0; i< expenditure.length - d; i++){
              median = this.findMedian(expenditure,i,d);                
                if(expenditure[d+i] >= (median * 2)){                    
                      numberNotifications++;
                  }
             // System.out.println(expenditure[d+i] + " --> " +numberNotifications);
              
          }
              
          return numberNotifications;     
    }    
    public double findMedian(int[] expenditure, int initialIndex, int d){
        double tempMedian = 0;         
        int[] tempExpenditure = Arrays.copyOfRange(expenditure,initialIndex, initialIndex+d);        
        tempExpenditure = this.AddressCalculationSort(tempExpenditure);
        int halfLength = d / 2 ;            
        if(d % 2  == 0 ){ // even number count then take avarage 
            tempMedian = ( (tempExpenditure[halfLength-1] * 1.0) + tempExpenditure[halfLength] ) / 2 ;            
        }else{                // odd number count then take median
            tempMedian = tempExpenditure[halfLength-1];
        }
        
//         for(int i=0; i< d; i++)
//            System.out.print(tempExpenditure[i] + " ");
//        System.out.print( " -> " + tempMedian * 2  + " --> ");
        
        return tempMedian;         
    }    
    public int[] AddressCalculationSort(int[] expenditures){
        AddressCalculationSortNode[] frontNode = new AddressCalculationSortNode[10];        
        AddressCalculationSortNode newNode, currentNode;
        
        
        int mostSignificant = this.getNumberOfDigitsLargerstDigit(expenditures);
        int significantDigit = 0;
        int nonEmptySetPosition = 0;
       // for(int k = leastSignificant; k<= mostSignificant; k++){  // Asymptotic Time complexity O( k * n )
            
                for(int j = 0; j< 10; j++){
                    frontNode[j] = null;  // Setting the frontNode and rearNode is null initially                    
                }
             for(int i = 0; i < expenditures.length; i++){
                 significantDigit = this.getDigit(expenditures[i], mostSignificant);
                    newNode = new AddressCalculationSortNode(expenditures[i]);
                  if(frontNode[significantDigit] == null){
                      frontNode[significantDigit] = newNode;
                  }else{
                        currentNode = frontNode[significantDigit];
                         while(currentNode.nextNode != null){
                                if(currentNode.nodeValue > newNode.nodeValue)
                                    break;                                
                                currentNode = currentNode.nextNode;
                         }
                         newNode.nextNode = currentNode.nextNode;
                         currentNode.nextNode = newNode;                      
                  }
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
            
            
       // }
        
        
        
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

 class AddressCalculationSortNode {
    public int nodeValue;
    public AddressCalculationSortNode nextNode;
    
    public AddressCalculationSortNode(){        
        this.nextNode = null;
    }
    
    public AddressCalculationSortNode(int newNodeValue){
        this();
        this.nodeValue = newNodeValue;
    }
}

