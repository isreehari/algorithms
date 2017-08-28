/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.contest47;

import java.util.Scanner;

/**
 *
 * @author sinukoll
 */
public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        
         boolean result = true;
         int numberNonDecresingValues = 0;  
       
         
         int casingValueIndex = -1;
        
            for(int i = 0; i < nums.length -1; i++){                   
                if( nums[i] <= nums[i+1]){    
                    
                } else{
                    numberNonDecresingValues++;                      
                    if(i > 0)
                    if(nums[i-1] <= nums[i+1])
                        casingValueIndex = i;
                        else
                        casingValueIndex = i+1;
                    else
                    casingValueIndex = i;
                     
                     
                }
            }
            
            
            if(numberNonDecresingValues > 1)
                 result = false;
            else            
            if(casingValueIndex > -1){
                if(casingValueIndex > 0 && casingValueIndex < nums.length -1){
                    if(nums[casingValueIndex-1] <= nums[casingValueIndex+1]){
                        result = true;
                    }else{
                        result = false;
                    }
                        
                }
            }
            
        return result;
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int arraySize  = in.nextInt();
        int[] nums = new int[arraySize];
        
        NonDecreasingArray  nonDecresingArray = new NonDecreasingArray();
        
         for(int arr_i=0; arr_i < arraySize; arr_i++){
            nums[arr_i] = in.nextInt();
        }
         
        System.out.println(nonDecresingArray.checkPossibility(nums));
        
       
        
        in.close();
    }
}
