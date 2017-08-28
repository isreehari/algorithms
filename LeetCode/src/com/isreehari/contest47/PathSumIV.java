/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.contest47;

import java.util.Scanner;
import java.math.*;

/**
 *
 * @author sinukoll
 */
public class PathSumIV {
    
    public int pathSum(int[] nums) {
        int[] tempNums = new int[nums.length];
       // nums = this.mergeSort(nums,tempNums,0,nums.length-1);
        int significant1,significant2,significant3;
        significant1 =significant2 =significant3 = 0;     
        int newValue = 0;
        int newNodeIndex = 0;
        int numberNodes = 0;
        
        int[][] bTreeArray = new int[4][8];
        
        BinaryTreeNode rootNode = null, newNode = null;
        
        
        for(int index =0; index< nums.length; index++){
            newValue = nums[index]; // 123            
            significant1 = newValue % 10; // 3 - 123
            newValue = newValue / 10;             
            significant2 = newValue % 10; // 2 - 12
            newValue = newValue / 10;            
            significant3 = newValue % 10; // 1 - 1            
            bTreeArray[significant3-1][significant2-1] = significant1;            
        }
        
        int totalSum = 0;
        
        for(int i = 0; i< 4; i++){
            numberNodes = (int)Math.pow(2,i);
            for(int j = 0; j< numberNodes; j++)
            System.out.print(bTreeArray[i][j] +" ");
            
            System.out.println();
        }
         
        
        
        
        return 0;
    }
    
    public int[] mergeSort(int[] nums, int[] tempNums, int low, int up){
        if(low == up) // single element
            return nums;
        
        int mid = (low + up) / 2;
        
        this.mergeSort(nums, tempNums, low, mid);
        this.mergeSort(nums, tempNums, mid+1,up);
        
        tempNums = this.merge(nums, tempNums, low, mid, mid+1, up);
        
        for(int i= low; i<= up; i++)
            nums[i] = tempNums[i];
        
        return nums;
        
    }
    
    public int[] merge(int[] nums, int[] tempNums, int low1, int up1, int low2, int up2){        
        int currentIndex = low1;

        while(low1<= up1 && low2 <= up2){
            if(nums[low1] > nums[low2]){
                    tempNums[currentIndex++] = nums[low2++];
                }else{
                    tempNums[currentIndex++] = nums[low1++];
                }
        }
        
        while(low1<=up1)
            tempNums[currentIndex++] = nums[low1++];
        
        while(low2<=up2)
            tempNums[currentIndex++] = nums[low2++];
        
        
        
        return tempNums;
    }
    
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int arraySize  = in.nextInt();
        int[] nums = new int[arraySize];
        
        PathSumIV  pathSumIV = new PathSumIV();
        
         for(int arr_i=0; arr_i < arraySize; arr_i++){
            nums[arr_i] = in.nextInt();
        }
         
        System.out.println(pathSumIV.pathSum(nums));
        
       
        
        in.close();
    }
     
     
    
}

class BinaryTreeNode{
    public BinaryTreeNode leftChildeNode ;
    public int nodeValue;
    public BinaryTreeNode rightChildeNode ;
    
    public BinaryTreeNode(int newNodeValue){
        this.leftChildeNode = null;
        this.nodeValue = newNodeValue;
        this.rightChildeNode = null;
    }
    
}
