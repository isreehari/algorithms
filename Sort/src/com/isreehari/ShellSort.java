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
public class ShellSort {
    
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int arraySize = inputScanner.nextInt();
        int[] givenArray = new int[arraySize];
        for(int index = 0; index < arraySize; index++){
            givenArray[index] = inputScanner.nextInt();
        }
        ShellSort shellSort = new ShellSort();
        givenArray = shellSort.doShellSort(inputScanner,givenArray, arraySize);
        
        for(int index = 0; index < arraySize; index++){
            System.out.print(givenArray[index] + " ");
        }
        
        System.out.println();
        
        
        inputScanner.close();
    }
     
     public int[] doShellSort(Scanner inputScanner, int[] givenArray, int arraySize){        
        
        int h = inputScanner.nextInt();
         
        int tempValue = 0;              
        int j = 0;
        
        while(h >= 1){
            for(int i = h; i < arraySize; i++ ){                        
                tempValue = givenArray[i];
                for(j = i-h; j >=0 && givenArray[j] > tempValue; j-=h){
                    givenArray[j+h] = givenArray[j];
                }    

                givenArray[j+h] = tempValue;

            }
            
            h = h - 2;
        }
        
        
        return givenArray;
    }
    
}
