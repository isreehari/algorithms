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
    public RadixSortNode[] frontNodes = new RadixSortNode[201];
    public RadixSortNode[] rearNodes = new RadixSortNode[201];    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] expenditure = new int[n];
        Solution thisSolution = new Solution();
        for(int expenditure_i = 0; expenditure_i < n; expenditure_i++){
            expenditure[expenditure_i] = in.nextInt();  
            if(expenditure_i < d){
                thisSolution.tempExpenditure.add(expenditure[expenditure_i]);
                thisSolution.insertNodeRadixSort(expenditure[expenditure_i]);
            }
        }
        
        int result = thisSolution.activityNotifications(expenditure,n, d);
        System.out.println(result);
        in.close();
    }
    public int activityNotifications(int[] expenditure,int n, int d) {
        // Complete this function
            if(expenditure.length < 0 || d >= expenditure.length){
                 return 0;
             }  
          int newNumber = 0, removeNumber= 0; 
          double median = 0.0;          
          int numberNotifications = 0;
          
          for(int i = d; i< n; i++){       
              
              median = this.getMedian(d);    
              
              if(expenditure[i] >= (median * 2)){                    
                  numberNotifications++;
                }
              
              newNumber = expenditure[i];
              removeNumber = this.tempExpenditure.remove(0);            
              this.tempExpenditure.add(newNumber);  
              
              if( newNumber != removeNumber){
                this.removeNodeRadixSort(removeNumber);                 
                this.insertNodeRadixSort(newNumber);                     
              }                
              
              
          }
              
          return numberNotifications;     
    }                 
    public void insertNodeRadixSort(int significant){                      
        RadixSortNode newNode = new RadixSortNode(significant);
        if(this.frontNodes[significant]== null){
            this.frontNodes[significant] = newNode;            
        }else{
            this.rearNodes[significant].nextNode = newNode;           
        }
        this.rearNodes[significant] = newNode;
        
    }
    public void removeNodeRadixSort(int significant){                      
       this.frontNodes[significant] = this.frontNodes[significant].nextNode;
        if(this.frontNodes[significant] == null)
            this.rearNodes[significant] = null;
    }    
    public double getMedian(int d){        
         RadixSortNode frontNode = null, rearNode = null, currentNode = null;
         double tempMedian = 0.0;        
         int halfLength = (d / 2) - 1;    
         int evenNumberCase1 = 0 , evenNumberCase2 = 0;
         int currentIndex = 0;
         for(int i=0; i<= 200; i++){             
             if(this.rearNodes[i] != null){
                    if(frontNode == null)
                        frontNode = this.frontNodes[i];
                    else{
                        rearNode.nextNode = this.frontNodes[i];
                    }                    
                    rearNode = this.rearNodes[i];
             }
         }             

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