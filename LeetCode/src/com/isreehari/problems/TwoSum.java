/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.problems;

import java.util.Scanner;

/**
 *
 * @author sinukoll
 */
public class TwoSum {
    
      public int[] getTwoSum(int[] nums, int target) {
        int arrayLength = nums.length;        
        int[] returnData = new int[2];
        int difference = 0;
        
            for(int index1 = 0; index1 < arrayLength-1; index1++ ){                
                for(int index2 = index1 + 1; index2 < arrayLength; index2++ ){
                    if(nums[index1] + nums[index2] == target){
                        returnData[0] = index1;
                        returnData[1] = index2;
                        return returnData;
                    }
                } 
            } 
        
        return returnData;
    }
      
       public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int arraySize  = in.nextInt();
        int[] nums = new int[arraySize];
        
        TwoSum  twoSum = new TwoSum();
        
         for(int arr_i=0; arr_i < arraySize; arr_i++){
            nums[arr_i] = in.nextInt();
        }
         
         int target = in.nextInt();
         
        int[] resultArray = twoSum.getTwoSum(nums,target);
        
        System.out.print("[");
        for(int index = 0; index < resultArray.length; index++)
            if((index+1) == resultArray.length)
                System.out.print(resultArray[index]);
                else
                System.out.print(resultArray[index] + ", ");
        System.out.print("]");
        System.out.println();
       
        
        in.close();
    }
    
}
