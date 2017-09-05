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
public class KadanesAlgorithm {
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        
        int arraySize = inputScanner.nextInt();
        int[] inputArray = new int[arraySize];
        int index = 0;
        while(index < arraySize){
            inputArray[index++] = inputScanner.nextInt();
        }
        
        KadanesAlgorithm kadanesAlgorithm = new KadanesAlgorithm();
        
        System.out.println(kadanesAlgorithm.getMaxSumSubArray(inputArray, arraySize));
        inputScanner.close();
    }
    
    
    public int getMaxSumSubArray(int[] inputArray, int arraySize){
        int currentMaxSum, globalMaxSum;
            currentMaxSum = globalMaxSum = inputArray[0];
            
            for(int index = 1; index < arraySize; index++){
                currentMaxSum = Math.max(inputArray[index],inputArray[index] + currentMaxSum);
                
                if(currentMaxSum > globalMaxSum)
                    globalMaxSum = currentMaxSum;
            }
            
          
            return globalMaxSum;
    }
}
