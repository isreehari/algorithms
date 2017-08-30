/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.contest47;

import java.util.Scanner;
import java.util.Stack;
import java.util.Iterator;
import java.math.*;

/**
 *
 * @author sinukoll
 */
public class PathSumIV {
    public Stack<Integer> currentStack = new Stack<Integer>();
    public int totalSum = 0;
    public int pathSum(int[] nums) {
        //int[] tempNums = new int[nums.length];
        //nums = this.mergeSort(nums,tempNums,0,nums.length-1);
        int significant1,significant2,significant3;
        significant1 =significant2 =significant3 = 0;     
        int newValue = 0;
       
        int[] treeArray = new int[17];
        int treeIndex = 0;
        
        for(int index = 1; index< treeArray.length; index++){
            treeArray[index] = -1;
        }
        
        
        for(int index =0; index< nums.length; index++){
            newValue = nums[index]; // 123            
            significant1 = newValue % 10; // 3 - 123
            newValue = newValue / 10;             
            significant2 = newValue % 10; // 2 - 12
            newValue = newValue / 10;            
            significant3 = newValue % 10; // 1 - 1            
            
            treeIndex = ((int)Math.pow(2,(significant3-1)) + (significant2)) - 1 ;
            
            treeArray[treeIndex] = significant1;
            
        }
        
            for(int index = 1; index< treeArray.length; index++){
                System.out.println( index + " --> " +treeArray[index] + " ");
             }
            
            
           
         
        
        
        this.getPathSumInOrder(treeArray, 1);
        return this.totalSum;
    }
    
    public void getPathSumInOrder(int[] nums, int rootIndex){
     
        int leftChildIndex = 2 * rootIndex ;
        int rightChildIndex = leftChildIndex + 1;
        
        if( rightChildIndex > nums.length || nums[rootIndex] == -1 )
            return;
        
       
        
        this.currentStack.push(rootIndex);
        this.getPathSumInOrder(nums, leftChildIndex);
        int newIndex = 0;
        if( rightChildIndex < nums.length )            
         if(nums[leftChildIndex] == -1 && nums[rightChildIndex] == -1){
             Iterator<Integer> stackNode = this.currentStack.iterator();
             while(stackNode.hasNext()){
                 newIndex = stackNode.next();
                 this.totalSum = this.totalSum + nums[newIndex];
             }
             this.currentStack.pop();
         }
             
        this.getPathSumInOrder(nums, rightChildIndex);
            
        
       
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
