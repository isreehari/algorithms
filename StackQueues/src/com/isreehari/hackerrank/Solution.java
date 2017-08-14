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
    
    public int[] counter = new int[201];
    public int largestElement = 0;
    public int smallestElement = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] expenditure = new int[n];
        Solution thisSolution = new Solution();
        int halfLength = (d / 2);  
        boolean evenNumber = d % 2 == 0 ? true : false;
        
         if(expenditure.length < 0 || d >= expenditure.length){
                 in.close();
                 System.out.println(0);
                 return;
             }  
          int newNumber = 0, removeNumber= 0; 
          double median = 0.0;          
          int numberNotifications = 0;
          
        
        for(int expenditure_i = 0; expenditure_i < n; expenditure_i++){
            expenditure[expenditure_i] = in.nextInt(); 
            
            if(expenditure[expenditure_i] > thisSolution.largestElement)
                thisSolution.largestElement = expenditure[expenditure_i];
            
            if(expenditure_i < d){                
                thisSolution.counter[expenditure[expenditure_i]]++;                
            } else{
                median = thisSolution.getMedian(halfLength,evenNumber);                  
                if(expenditure[expenditure_i] >= (median * 2)){                    
                    numberNotifications++;
                  }                
                thisSolution.counter[expenditure[expenditure_i]]++;
                thisSolution.counter[expenditure[expenditure_i-d]]--; 
                
                if(expenditure[expenditure_i] < thisSolution.smallestElement)
                    thisSolution.smallestElement = expenditure[expenditure_i];
                
                
            }
        }
        System.out.println(numberNotifications);
        in.close();
    }
    public double getMedian(int halfLength, boolean evenNumber){        
         
         double tempMedian = 0.0;                   
         int evenNumberCase1 = 0 , evenNumberCase2 = 0;
         int numberElements = 0;         
         for(int i=this.smallestElement; i<= this.largestElement; i++){                  
             if(numberElements == 0 && this.counter[i] > 0){                 
                 this.smallestElement = i;
             }
             numberElements = numberElements + this.counter[i];                
             if(numberElements > halfLength){ 
                    if(evenNumber){
                        if(this.counter[i] > 1 && ((numberElements - this.counter[i] ) - halfLength ) != 0){  
                             evenNumberCase2  = i;
                             evenNumberCase1  = i;
                        }else{
                            evenNumberCase1  = i;
                            for(int j= i - 1; j >= 0; j--){
                                if(this.counter[j] > 0){
                                    evenNumberCase2  = j;
                                    break;
                                }
                            }
                        }
                        return tempMedian = ((evenNumberCase1 * 1.0) + (evenNumberCase2)) / 2;
                        
                    }else
                    {
                        return tempMedian = i;
                    }
                    
             }
         }             
         return tempMedian;
    }        
}
