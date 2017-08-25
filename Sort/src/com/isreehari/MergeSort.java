/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari;

import java.util.Scanner;

/**
 *
 * @author sinukoll
 */
public class MergeSort {
    
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        MergeSort mergeSort = new MergeSort();
        int arraySize1 = inputScanner.nextInt();
        int[] givenArray1 = new int[arraySize1];
        int[] tempArray1 = new int[arraySize1];
        for(int index = 0; index < arraySize1; index++){
            givenArray1[index] = inputScanner.nextInt();
        }
        
        givenArray1 = mergeSort.doMergeSort(givenArray1,givenArray1, 0, arraySize1-1);
        for(int index = 0; index < arraySize1; index++){
            System.out.print(givenArray1[index] + " ");
        }
        
        System.out.println();
        
        
        inputScanner.close();
    }
    
    public int[] doMergeSort(int[] givenArray1, int[] tempArray1, int low, int up){
        
        if(low == up) // one element
            return givenArray1;
        
        int mid = (low + up) / 2;
        
        this.doMergeSort(givenArray1,tempArray1,low,mid);
        this.doMergeSort(givenArray1,tempArray1,mid+1,up);
        
        givenArray1 =  this.doMerge(givenArray1, tempArray1, low, mid, mid+1,up);
        
        return givenArray1;
    }
    
      public int[] doMerge(int temp1[], int[] temp2, int low1, int up1, int low2, int up2){
        
        int i = low1, j = low2, currentIndex = 0;
        
           while(i <= up1 && j <= up2 ){
                if(temp1[i] > temp1[j]){
                    temp2[currentIndex++] = temp1[j++];                    
                }else{
                    temp2[currentIndex++] = temp1[i++];
                }
            }
        
        
        while(i <= up1)
            temp2[currentIndex++] = temp1[i++];
        
        while(j <= up2)
            temp2[currentIndex++] = temp1[j++];
        
        
        return temp2;
    } 
    
}
