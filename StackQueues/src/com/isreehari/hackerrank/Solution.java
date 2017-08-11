/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.hackerrank;

import java.io.*;
import java.util.*;
import static java.util.Arrays.sort;
import static java.util.Arrays.copyOf;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 *
 * @author sinukoll
 */


public class Solution {
    
    

    static int activityNotifications(int[] expenditure, int d) {
        // Complete this function
            if(expenditure.length < 0 || d >= expenditure.length){
                 return 0;
             }  
        
          int median = 0;          
          int numberNotifications = 0;
          for(int i = 0; i< expenditure.length - d; i++){
              median = findMedian(expenditure,i,d);                
                if(expenditure[d+i] >= (median * 2)){
                      numberNotifications++;
                  }
              
          }
              
          return numberNotifications;     
    }
    
    static int findMedian(int[] expenditure, int initialIndex, int d){
        int tempMedian = 0;         
        int[] tempExpenditure = Arrays.copyOfRange(expenditure,initialIndex, initialIndex+d);        
        sort(tempExpenditure); 
        int halfLength = d / 2 ;            
        if(d % 2  == 0 ){ // even number count then take avarage 
            tempMedian = ( tempExpenditure[halfLength] + tempExpenditure[halfLength+1] ) / 2 ;
        }else{                // odd number count then take median
            tempMedian = tempExpenditure[halfLength];
        }
        
        return tempMedian;         
    }
    
    static int[] selectionSort(int[] tempExpenditure){
        int temp = 0;
         for(int i = 0; i< tempExpenditure.length; i++){             
             for(int j = 0; j< tempExpenditure.length - 1 - i; j++)
             {
                 if(tempExpenditure[j] > tempExpenditure[j+1]){
                     temp = tempExpenditure[j+1];
                     tempExpenditure[j+1] = tempExpenditure[j];
                     tempExpenditure[j] = temp;
                 }
             }
         } 
        
         
                 
        
        
        return tempExpenditure;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] expenditure = new int[n];
        for(int expenditure_i = 0; expenditure_i < n; expenditure_i++){
            expenditure[expenditure_i] = in.nextInt();
        }
        int result = activityNotifications(expenditure, d);
        System.out.println(result);
        in.close();
    }
}

