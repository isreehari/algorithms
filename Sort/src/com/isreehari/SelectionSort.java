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
public class SelectionSort {
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int arraySize = inputScanner.nextInt();
        int[] givenArray = new int[arraySize];
        for(int index = 0; index < arraySize; index++){
            givenArray[index] = inputScanner.nextInt();
        }
        SelectionSort selectionSort = new SelectionSort();
        givenArray = selectionSort.doSelectionSort(givenArray, arraySize);
        
        for(int index = 0; index < arraySize; index++){
            System.out.print(givenArray[index] + " ");
        }
        
        System.out.println();
        
        
        inputScanner.close();
    }
    
    public int[] doSelectionSort(int[] givenArray, int arraySize){        
        
        // select the miniest value swape with current element.
        int minIndex = 0;
        int minValue = 0;
        for(int i = 0; i < arraySize - 1; i++ ){
            minIndex = i;
            for(int j = i+1; j < arraySize; j++){
                if( givenArray[minIndex] >  givenArray[j])
                    minIndex = j;
            }            
            if(i != minIndex){
                minValue = givenArray[minIndex];                
                givenArray[minIndex] = givenArray[i];
                givenArray[i] = minValue;
            }
        }
        return givenArray;
    }
}
