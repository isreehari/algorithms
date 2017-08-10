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
    
    public static int[] tempExpenditure;

    static int activityNotifications(int[] expenditure, int d) {
        // Complete this function
            if(expenditure.length < 0 || d >= expenditure.length){
                 return 0;
             }  
        
          int median = 0;          
          int numberNotifications = 0;
          for(int i = 0; i<= expenditure.length - d; i++){
              median = findMedian(expenditure, i,d);
              for(int j = d+i; j <= expenditure.length; j++ ){
                  if(expenditure[i] >= (median * 2))
                    numberNotifications++;
              }
              
          }
              
          return numberNotifications;     
    }
    
    static int findMedian(int[] expenditure, int initialIndex, int d){
        int tempMedian = 0; 
        if(tempExpenditure == null){ // initial sort first d of transactions 
            tempExpenditure = new int[d];
            tempExpenditure = selectionSort(expenditure, initialIndex, d);
        } else{ // After initial sort then insert new value to sorting array
            
        }
        
        int halfLength = d / 2 ; 
        if(d % 2  == 0){ // even number count then take avarage 
            tempMedian = ( tempExpenditure[halfLength] + tempExpenditure[halfLength+1] ) / 2 ;
        }else{                // odd number count then take median
            tempMedian = tempExpenditure[halfLength];
        }
        
        
        return tempMedian; 
        
    }
    
    static int[] selectionSort(int[] expenditure,int initialIndex, int maximumSortLength){
        int tempExpenditure = 0;
        int[] newExpenditure = new int[maximumSortLength];
       
         for(int i=initialIndex; i < maximumSortLength ; i++){
             newExpenditure[i] = expenditure[i];           
        }
         for(int i = 0; i< maximumSortLength; i++){             
             for(int j = 0; j< maximumSortLength - 1 - i; j++)
             {
                 if(newExpenditure[j] > newExpenditure[j+1]){
                     tempExpenditure = newExpenditure[j+1];
                     newExpenditure[j+1] = newExpenditure[j];
                     newExpenditure[j] = tempExpenditure;
                 }
             }
         }
         
//         for(int i=0; i < maximumSortLength ; i++){
//            System.out.print(newExpenditure[i]+" ");
//             
//        }
//         System.out.println();
         
                 
        
        
        return newExpenditure;
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

