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
import static java.util.Collections.sort;
import java.util.regex.*;

/**
 *
 * @author sinukoll
 */


public class Solution {    
    public ArrayList<Integer> tempExpenditure = new ArrayList<Integer>();     
    public ArrayList<Integer> sortedArray = new ArrayList<Integer>();
    public RadixSortNode[] frontNodes = new RadixSortNode[201];
    public RadixSortNode[] rearNodes = new RadixSortNode[201];
    public int[] cumulativeArray = new int[201];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] expenditure = new int[n];
        Solution thisSolution = new Solution();
        for(int expenditure_i = 0; expenditure_i < n; expenditure_i++){
            expenditure[expenditure_i] = in.nextInt();            
        }
        
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
        double tempMedian = 0.0;    
        int newNumber = 0, removeNumber= 0, tempSortedArrayIndex = 0;
        int significant = 0;  
        long startTime, endTime, totalTime;
        
        startTime = System.nanoTime();
        if(initialIndex == 0){      
            for(int i = initialIndex, j=0; i< initialIndex+d ; i++, j++){
                this.tempExpenditure.add(expenditure[i]);            
                insertNodeRadixSort(expenditure[i]);
            }            
        }else{
            newNumber = expenditure[initialIndex+d-1];
            removeNumber = this.tempExpenditure.remove(0);            
            this.tempExpenditure.add(newNumber);   
            if( newNumber != removeNumber){
                removeNodeRadixSort(removeNumber);                 
                insertNodeRadixSort(newNumber);                     
            }            
        }
        
        tempMedian = this.getMedian(d);
        
        
//            endTime = System.nanoTime();
//            totalTime =  endTime - startTime;
//            System.out.println( initialIndex +" -> "+ (totalTime * 1.0) / 1000000000.0);
        
                   
       
        
//        for(int i =0; i < this.sortedArray.size(); i++){
//            System.out.print(this.sortedArray.get(i) + " ");
//        }
//        
//        System.out.println(" --> " + tempMedian);

        
        return tempMedian;         
    }    
    public void countingSort(ArrayList<Integer> expenditures){           
       
        int significantDigit = 0;      
        int[] tempCumulativeArray = new int[201];
        for(int tempIndex=0; tempIndex < 201; tempIndex++){
            if(tempIndex > 0){
                tempCumulativeArray[tempIndex] = tempCumulativeArray[tempIndex-1] +  this.cumulativeArray[tempIndex];
            }else
                tempCumulativeArray[tempIndex] = this.cumulativeArray[tempIndex];
        }
        for(int tempIndex= expenditures.size()-1; tempIndex >= 0; tempIndex--){
            significantDigit = expenditures.get(tempIndex);
            this.sortedArray.add(significantDigit);
            tempCumulativeArray[significantDigit]--;            
        }                
       
    } 
    
    public void insertNodeRadixSort(int significant){                      
        RadixSortNode newNode = new RadixSortNode(significant);
        if(this.frontNodes[significant]== null){
            frontNodes[significant] = newNode;            
        }else{
            rearNodes[significant].nextNode = newNode;           
        }
        rearNodes[significant] = newNode;
        
    }
    public void removeNodeRadixSort(int significant){                      
       frontNodes[significant] = frontNodes[significant].nextNode;
        if(frontNodes[significant] == null)
            rearNodes[significant] = null;
    }
    
    public double getMedian(int d){        
         RadixSortNode frontNode = null, rearNode = null, currentNode = null;
         double tempMedian = 0.0;
         sortedArray.removeAll(sortedArray);
         int halfLength = (d / 2) - 1;    
         int evenNumberCase1 = 0 , evenNumberCase2 = 0;
         int currentIndex = 0;
         for(int i=0; i<= 200; i++){             
             if(rearNodes[i] != null){
                    if(frontNode == null)
                        frontNode = frontNodes[i];
                    else{
                        rearNode.nextNode = frontNodes[i];
                    }                    
                    rearNode = rearNodes[i];
             }
         }    
         
         
         //currentNode = frontNode;
         
//         while(currentNode != null){
//                 System.out.print(currentNode.nodeValue + " ");
//                 currentNode = currentNode.nextNode;
//            }
//         System.out.println();         
         
         currentNode = frontNode;
         while(currentNode != null){
                 if(currentIndex == halfLength){                        
                     if(d % 2  == 0 ){
                         evenNumberCase1 = currentNode.nodeValue; 
                         evenNumberCase2 = currentNode.nextNode.nodeValue;
                         tempMedian = (evenNumberCase1*1.0 + evenNumberCase2)/2;
                     }else{
                         tempMedian = currentNode.nextNode.nodeValue;
                     }
                     break;
                 }
                currentNode = currentNode.nextNode;
                currentIndex++;
            }
         
         return tempMedian;
    }
    
    public void insertNewValue(int newValue){        
        int previousValue, insertIndex = -1;
        for(int tempIndex=0; tempIndex< tempExpenditure.size(); tempIndex++){
              if(newValue < this.sortedArray.get(tempIndex)){
                  insertIndex = tempIndex;
                  break;
              }
        }
        
        if(insertIndex == -1){
            this.sortedArray.add(newValue);
        }else{
            for(int tempIndex=insertIndex; tempIndex< tempExpenditure.size(); tempIndex++){
                    if(newValue < this.sortedArray.get(tempIndex)){
                        insertIndex = tempIndex;
                        break;
                    }
              }
        }
        
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