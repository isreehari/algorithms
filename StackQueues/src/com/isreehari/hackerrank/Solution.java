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
    public RadixSortNode[] frontNodes = new RadixSortNode[201];    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] expenditure = new int[n];
        Solution thisSolution = new Solution();
        
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
            if(expenditure_i < d){                
                thisSolution.insertNodeRadixSort(expenditure[expenditure_i]);
            } else{
                median = thisSolution.getMedian(d);    
              
                if(expenditure[expenditure_i] >= (median * 2)){                    
                    numberNotifications++;
                  }

                newNumber = expenditure[expenditure_i];
                removeNumber = expenditure[expenditure_i-d];

                if( newNumber != removeNumber){
                  thisSolution.removeNodeRadixSort(removeNumber);                 
                  thisSolution.insertNodeRadixSort(newNumber);                     
                }                
            }
        }
        System.out.println(numberNotifications);
        in.close();
    }    
    public void insertNodeRadixSort(int significant){                      
        RadixSortNode newNode = new RadixSortNode(significant);
        if(this.frontNodes[significant]== null){
            this.frontNodes[significant] = newNode;            
        }else{
            newNode.nextNode = this.frontNodes[significant];
            this.frontNodes[significant] = newNode;
        }
        
        
    }
    public void removeNodeRadixSort(int significant){                      
       this.frontNodes[significant] = this.frontNodes[significant].nextNode;        
    }    
    public double getMedian(int d){        
         RadixSortNode currentNode = null;
         double tempMedian = 0.0;        
         int halfLength = (d / 2) - 1;    
         int evenNumberCase1 = 0 , evenNumberCase2 = 0;
         int currentIndex = 0;
         boolean evenNumber = d % 2 == 0 ? true : false;
         for(int i=0; i<= 200; i++){          
             currentNode = this.frontNodes[i];
             while(currentNode != null){
                 if(currentIndex == halfLength){                      
                     if(evenNumber){
                         evenNumberCase1 = currentNode.nodeValue;                          
                         if(currentNode.nextNode == null){
                              for(int j = i+1; j<= 200; j++){
                                currentNode = this.frontNodes[j];
                                if(currentNode != null){
                                   evenNumberCase2 = currentNode.nodeValue;
                                   break;
                                }    
                              }
                          }else
                            evenNumberCase2 = currentNode.nextNode.nodeValue;
                         tempMedian = (evenNumberCase1*1.0 + evenNumberCase2)/2;
                         return tempMedian;
                     }else{
                          if(currentNode.nextNode == null){
                              for(int j = i+1; j<= 200; j++){
                                currentNode = this.frontNodes[j];
                                if(currentNode != null){
                                   return tempMedian = currentNode.nodeValue;
                                   
                                }    
                              }
                          }else
                            return tempMedian = currentNode.nextNode.nodeValue;
                     }
                     break;
                 }
                 currentIndex++;
                 currentNode = currentNode.nextNode;
             }             

         }             
         return tempMedian;
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