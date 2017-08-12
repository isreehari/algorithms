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
        
        if(initialIndex == 0){                
            for(int i = initialIndex, j=0; i< initialIndex+d ; i++, j++){
                this.tempExpenditure.add(expenditure[i]);            
                this.cumulativeArray[expenditure[i]]++;                               
            }
            this.countingSort(this.tempExpenditure);
                
                 for(int h=0; h< this.sortedArray.size();h++)
                    System.out.print(this.sortedArray.get(h) + " ");        
                    System.out.println();
        }else{
            newNumber = expenditure[initialIndex+d-1];
            removeNumber = this.tempExpenditure.remove(0);            
            this.tempExpenditure.add(newNumber);               
            tempSortedArrayIndex = this.sortedArray.indexOf(removeNumber);
            this.sortedArray.remove(tempSortedArrayIndex);
            this.sortedArray.add(newNumber);
            sort(this.sortedArray);
        }
        
       
        
        
        
        
        int halfLength = d / 2 ;            
        if(d % 2  == 0 ){ // even number count then take avarage 
              tempMedian = ( (this.sortedArray.get(halfLength-1) * 1.0) + this.sortedArray.get(halfLength) ) / 2 ;                     
        }else{                // odd number count then take median            
            tempMedian = this.sortedArray.get(halfLength-1);              
        }

        
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
