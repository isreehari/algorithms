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
public class BubbleSort {
    
     public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int arraySize = inputScanner.nextInt();
        int[] givenArray = new int[arraySize];
        for(int index = 0; index < arraySize; index++){
            givenArray[index] = inputScanner.nextInt();
        }
        BubbleSort bubbleSort = new BubbleSort();
        givenArray = bubbleSort.doBubbleSort(givenArray, arraySize);
        
        for(int index = 0; index < arraySize; index++){
            System.out.print(givenArray[index] + " ");
        }
        
        System.out.println();
        
        
        inputScanner.close();
    }
     
     public int[] doBubbleSort(int[] givenArray, int arraySize){        
        
        int tempValue = 0;
        int numberSwaps = 0;
        for(int i = arraySize - 2; i >=0; i-- ){            
            numberSwaps = 0;
            for(int j = 0; j <= i; j++){
                if(givenArray[j] > givenArray[j+1]){
                    tempValue = givenArray[j];
                    givenArray[j] = givenArray[j+1];
                    givenArray[j+1] =  tempValue;
                    numberSwaps++;
                }
            }            
            if(numberSwaps == 0)
                return givenArray;
        }
        return givenArray;
    }
    
}
