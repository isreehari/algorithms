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
    
        public ArrayList<Integer> tempExpenditure = new ArrayList<Integer>();
        public ArrayList<Integer> sortedTempExpenditure = new ArrayList<Integer>();
        
        
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
            //  System.out.println(expenditure[d+i] + " --> " +numberNotifications);
              
          }
              
          return numberNotifications;     
    }    
    public double findMedian(int[] expenditure, int initialIndex, int d){
        double tempMedian = 0;     
        int evenCaseValue1 = 0, evenCaseValue2 = 0;
        int currentIndex = 0;
            if(initialIndex == 0){
                //this.tempExpenditure = new int[d];
                //this.sortedTempExpenditure = new int[d];
                for(int i = initialIndex, j=0; i< initialIndex+d ; i++, j++)
                    this.tempExpenditure.add(expenditure[i]);
            }else{
                this.tempExpenditure.remove(0);
                this.tempExpenditure.add(expenditure[initialIndex+d-1]);
            }
        
        
        
        this.sortedTempExpenditure = this.radixSortImplementation(this.tempExpenditure);
        
        Iterator iterator = this.sortedTempExpenditure.iterator();
        
        int halfLength = d / 2 ;            
        if(d % 2  == 0 ){ // even number count then take avarage 
              tempMedian = ( (this.sortedTempExpenditure.get(halfLength-1) * 1.0) + this.sortedTempExpenditure.get(halfLength) ) / 2 ;                     
        }else{                // odd number count then take median
            
            tempMedian = this.sortedTempExpenditure.get(halfLength-1); 
             
        }
        
        this.sortedTempExpenditure.clear();
        
//         for(int i=0; i< d; i++)
//            System.out.print(tempExpenditure[i] + " ");
//        System.out.print( " -> " + tempMedian * 2  + " --> ");
        
        return tempMedian;         
    }    
   public ArrayList<Integer> radixSortImplementation(ArrayList<Integer> expenditures){
        
        
        //int leastSignificant = 1;
        int arraySize =  this.getLargerstNumber(expenditures) + 1;
        RadixSortNode[] frontNode = new RadixSortNode[arraySize];        
        RadixSortNode newNode, currentNode;
        int significantDigit = 0;
        int nonEmptySetPosition = 0;
        //for(int k = leastSignificant; k<= mostSignificant; k++){  // Asymptotic Time complexity O( k * n )
            
//                for(int j = 0; j<= 200; j++){
//                    frontNode[j] = null;  // Setting the frontNode and rearNode is null initially                    
//                }
//             for(int i = 0; i < expenditures.size(); i++){
//                 //significantDigit = this.getDigit(expenditures[i], k);
//                 significantDigit = expenditures[i];
//                    newNode = new RadixSortNode(significantDigit);
//                  if(frontNode[significantDigit] == null){
//                      frontNode[significantDigit] = newNode;
//                  }else{
//                      newNode.nextNode = frontNode[significantDigit];
//                      frontNode[significantDigit] = newNode;
//                  }                  
//                  
//             }
                Iterator iterator = expenditures.iterator();                
                while(iterator.hasNext()){
                      significantDigit = (int)iterator.next();
                       newNode = new RadixSortNode(significantDigit);
                     if(frontNode[significantDigit] == null){
                         frontNode[significantDigit] = newNode;
                     }else{
                         newNode.nextNode = frontNode[significantDigit];
                         frontNode[significantDigit] = newNode;
                     }
                }
             
             nonEmptySetPosition = 0;
             while(frontNode[nonEmptySetPosition] == null) // find initial non empty set position
                nonEmptySetPosition++;
             
             ArrayList<Integer> expendituresTemp = new ArrayList<Integer>();
             
             for(int l= nonEmptySetPosition; l< arraySize; l++){                 
                 if(frontNode[l] != null){
                     currentNode = frontNode[l];
                     while(currentNode != null){
                         expendituresTemp.add(currentNode.nodeValue);
                         currentNode = currentNode.nextNode;
                     }                     
                 }
             }
            
            
       // }
        
        
        
        return expendituresTemp;
    } 
    public int getLargerstNumber(ArrayList<Integer> expenditures){
        
        int largestDigit = 0, tempCurrentValue;
        Iterator iterator = expenditures.iterator();
//        for(int i=0; i< expenditures.size(); i++){ // Asymptotic Time complexity O(n)
//            if(largestDigit < expenditures[i])
//                largestDigit = expenditures[i];
//        }



        while(iterator.hasNext()){
            tempCurrentValue = (int) iterator.next();
            if(largestDigit < tempCurrentValue){
                largestDigit = tempCurrentValue;
            }
        }
        
        
        return largestDigit;
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

class RadixSortNode {
    public int nodeValue;
    public RadixSortNode nextNode;
    
    public RadixSortNode(){        
        this.nextNode = null;
    }
    
    public RadixSortNode(int newNodeValue){
        this();
        this.nodeValue = newNodeValue;
    }
    
}

