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
public class MergingTwoSortedArrays {
    
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int arraySize1 = inputScanner.nextInt();
        int[] givenArray1 = new int[arraySize1];
        for(int index = 0; index < arraySize1; index++){
            givenArray1[index] = inputScanner.nextInt();
        }
        
        MergingTwoSortedArrays mergingTwoSortedArrays = new MergingTwoSortedArrays();
        givenArray1 = mergingTwoSortedArrays.doInsertionSort(givenArray1, arraySize1);
        
        int arraySize2 = inputScanner.nextInt();
        int[] givenArray2 = new int[arraySize2];
        for(int index = 0; index < arraySize2; index++){
            givenArray2[index] = inputScanner.nextInt();
        }
        
       
        givenArray2 = mergingTwoSortedArrays.doInsertionSort(givenArray2, arraySize2);
        
        
        
        int tempArraySize = arraySize1 + arraySize2;
        int[] tempArray = new int[tempArraySize];
        tempArray = mergingTwoSortedArrays.doMerge(givenArray1, givenArray2, tempArray);
        
        for(int index = 0; index < tempArraySize; index++){
            System.out.print(tempArray[index] + " ");
        }
        
        System.out.println();
        
        
        inputScanner.close();
    }
     
     public int[] doInsertionSort(int[] givenArray, int arraySize){        
        
        int tempValue = 0;              
        int j = 0;
        for(int i = 1; i < arraySize; i++ ){                        
            tempValue = givenArray[i];
            for(j = i-1; j >=0 && givenArray[j] > tempValue; j--){
                givenArray[j+1] = givenArray[j];
            }    
            
            givenArray[j+1] = tempValue;
            
        }
        return givenArray;
    }
     
    public int[] doMerge(int a1[],int a2[], int temp[]){
        
        int i =0, j = 0, currentIndex = 0;
        
        
           while(i < a1.length && j < a2.length ){
                if(a1[i] > a2[j]){
                    temp[currentIndex++] = a2[j++];                    
                }else{
                    temp[currentIndex++] = a1[i++];
                }
            }
        
        
        while(i < a1.length)
            temp[currentIndex++] = a1[i++];
        
        while(j < a2.length)
            temp[currentIndex++] = a2[j++];
        
        
        return temp;
    } 
    
}
