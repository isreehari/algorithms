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
public class InsertionSort {
    
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int arraySize = inputScanner.nextInt();
        int[] givenArray = new int[arraySize];
        for(int index = 0; index < arraySize; index++){
            givenArray[index] = inputScanner.nextInt();
        }
        InsertionSort insertionSort = new InsertionSort();
        givenArray = insertionSort.doInsertionSort(givenArray, arraySize);
        
        for(int index = 0; index < arraySize; index++){
            System.out.print(givenArray[index] + " ");
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
    
}
