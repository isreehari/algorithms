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
    public int largestElement = 201;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] expenditure = new int[n];        
        int halfLength = (d / 2);
        boolean evenNumber = d % 2 == 0 ? true : false;
        Solution thisSolution = new Solution();        
        if(expenditure.length < 0 || d >= expenditure.length){
                in.close();
                System.out.println(0);
                return;
            }  
          
        double median = 0.0;          
        int numberNotifications = 0;
        for(int expenditure_i = 0; expenditure_i < n; expenditure_i++){
            expenditure[expenditure_i] = in.nextInt();  
//            if(expenditure[expenditure_i] > thisSolution.largestElement)
//                thisSolution.largestElement = expenditure[expenditure_i];
            
            if(expenditure_i > (d - 1)){                
                median = thisSolution.getMedianCountingSort(expenditure,expenditure_i-d,d,halfLength,evenNumber);                  
                if(expenditure[expenditure_i] >= (median * 2)){                    
                    numberNotifications++;
                  }             
            }
        }
        System.out.println(numberNotifications);
        in.close();
    }              
    public double getMedianCountingSort(int[] tempExpenditures, int initialIndex, int maximumSize, int halfLength, boolean evenNumber){        
               
        int[] tempCumulativeArray = new int[this.largestElement];
        int significantValue = 0;
        int tempArraySize =0;
         for(int i = initialIndex; tempArraySize < maximumSize; i++, tempArraySize++){
            significantValue = tempExpenditures[i];
            tempCumulativeArray[significantValue]++;
        } 
        int[] sortedArray = new int[maximumSize];        
           
        
        for(int i = 1; i< this.largestElement; i++){
               tempCumulativeArray[i] += tempCumulativeArray[i-1];
        }
        
        for(int j = (initialIndex + maximumSize - 1); j >=initialIndex; j--){
            sortedArray[tempCumulativeArray[tempExpenditures[j]]-1] = tempExpenditures[j];
            tempCumulativeArray[tempExpenditures[j]]--;
            
            
        }        
        
        if(evenNumber){
            return (( sortedArray[halfLength-1] * 1.0) + sortedArray[halfLength] ) / 2;
         }else{
            return sortedArray[halfLength] * 1.0;
        }
    }
}